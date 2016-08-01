package deadreckoning.util;

import deadreckoning.object.ObjectDatas;

public final class MyUtils {
	
	/****��ֵ���&������������****/
	public static void maxTest (ObjectDatas user) {	
		double delta = 0.02;
	
		float[] accelerometer = new float[3];	
		accelerometer = user.getaccelerometerValues();
		int step = user.getstep();
		int statusTemp = user.getstatustemp();	//��һ״̬�ϳɼ��ٶ�״̬�������߼�
		int uppoint = user.getUppoint();
		int downpoint = user.getDownpoint();
		int periodpoint = user.getPeriodpoint();
		double frequency = user.getFrequency();
		double length = user.getLength();
		double distance = user.getDistance();
			
		double A = 0;	//�ϳɼ��ٶ�
		double Atemp = 20;	//��һ״̬�ϳɼ��ٶ�
		A = Math.sqrt( Math.pow(accelerometer[0], 2) + Math.pow(accelerometer[1], 2) + Math.pow(accelerometer[2], 2) );

		if( A<Atemp ) {	//�ϳɼ��ٶȼ�С
			Atemp = A;
			periodpoint++;
			user.setPeriodpoint(periodpoint);
			downpoint++;
			user.setDownpoint(downpoint);

			if(statusTemp == 1) {	//��һ״̬�ϳɼ��ٶ�����
				if( (A>14) && (downpoint>20) ) {	//һ�����ڽ���
				//if( (A>11)  ) {
					step++;
					user.setStep(step);

					frequency = 1/(periodpoint * delta);
					user.setFrequency(frequency);
					//���ݲ�Ƶ�Ͳ��������Թ�ϵ�õ�����
					
					if(frequency <= 1.35) {
						length = 0.4375;
						user.setLength(length);
						distance += length;
						user.setDistance(distance);
					}
					else if( (frequency>1.35) && (frequency<2.45) ) {
						length = 0.45*frequency-0.22;
						user.setLength(length);
						distance += length;
						user.setDistance(distance);
					}
					else if(frequency >= 2.45){
						length = 0.9325;
						user.setLength(length);
						distance += length;
						user.setDistance(distance);
					}

					periodpoint = 0;
					user.setPeriodpoint(periodpoint);
				}
			}
			statusTemp = 0;
			user.setstatustemp(statusTemp);
		}
		else {	//�ϳɼ��ٶ�����
			Atemp = A;
			periodpoint++;
			user.setPeriodpoint(periodpoint);
			uppoint++;
			user.setUppoint(uppoint);
			statusTemp = 1;
			user.setstatustemp(statusTemp);
		}
	}
		
	/****����ֱ��ʱ���ٶȵ�����ƽ��ֵ****/
	public static void averageAccelerometerUpdate(ObjectDatas user) {
		float[] accelerometerValues = user.getaccelerometerValues();
		int straightPoint = user.getstraightPoint();
		float g = user.getG();

		float[] averageAccelerometer = user.getaverageAccelerometer();
		averageAccelerometer[0] = (averageAccelerometer[0]*(straightPoint-1) + accelerometerValues[0])/straightPoint;
		averageAccelerometer[1] = (averageAccelerometer[1]*(straightPoint-1) + accelerometerValues[1])/straightPoint;
		averageAccelerometer[2] = (averageAccelerometer[2]*(straightPoint-1) + accelerometerValues[2])/straightPoint;
		user.setaverageAccelerometer(averageAccelerometer);
		g = (float) Math.sqrt( Math.pow(averageAccelerometer[0],2)+Math.pow(averageAccelerometer[1],2)+Math.pow(averageAccelerometer[2],2) );
		//g = (float) Math.sqrt( Math.pow(accelerometerValues[0],2)+Math.pow(accelerometerValues[1],2)+Math.pow(accelerometerValues[2],2) );
		user.setG(g);
	}

	/****�����˶���̬****/
	public static void updateAttitude(ObjectDatas user) {
		float[] gyroscopeValues = user.getgyroscopeValues();
		float[] averageAccelerometer = user.getaverageAccelerometer();
		float phi = user.getPhi();
		float[] rotation = new float[3];
		double T = 0.02;

		rotation[0] = (float) Math.toDegrees(gyroscopeValues[0] * T);
		rotation[1] = (float) Math.toDegrees(gyroscopeValues[1] * T);
		rotation[2] = (float) Math.toDegrees(gyroscopeValues[2] * T);

		if( ( Math.abs(rotation[0]) < 5 ) && ( Math.abs(rotation[1]) < 5 ) && ( Math.abs(rotation[2]) < 5 ) ) {
			user.setstraightFlag(true);
			user.setPhi(0);
		}
		else {
			user.setstraightFlag(false);
			phi += (float) Math.toDegrees((averageAccelerometer[0]*rotation[0] + averageAccelerometer[1]*rotation[1] + averageAccelerometer[2]*rotation[2])/user.getG());
			user.setPhi(phi);
		}


	}




	/****��ʼƫ��Ǽ���****/
	public static void firstDeflectAngle(ObjectDatas user) {
		int N = 10;
		float[] accelerometerValues = user.getaccelerometerValues();
		user.setG( (float)Math.sqrt( Math.pow(accelerometerValues[0],2)+Math.pow(accelerometerValues[1],2)+Math.pow(accelerometerValues[2],2) ) );
		user.setTheta( (float)Math.asin( accelerometerValues[1]/user.getG() ) );
		user.setGamma( (float)Math.atan( -accelerometerValues[0]/accelerometerValues[2] ) );
		user.setPhi(0);
	}
	
	/****��ʼ��̬�������****/
	public static void firstAttitudeMatrix(ObjectDatas user) {
		float theta = user.getTheta();
		float gamma = user.getGamma();
		float phi   = user.getPhi();

		double q0, q1, q2, q3;
		double C11, C12, C13, C21, C22, C23, C31, C32, C33; //for Cnb

		q0 = Math.cos(phi/2) * Math.cos(theta/2) * Math.cos(gamma/2) + Math.sin(phi/2) * Math.sin(theta/2) * Math.sin(gamma/2);
		q1 = Math.cos(phi/2) * Math.cos(theta/2) * Math.sin(gamma/2) - Math.sin(phi/2) * Math.sin(theta/2) * Math.cos(gamma/2);
		q2 = Math.cos(phi/2) * Math.sin(theta/2) * Math.cos(gamma/2) + Math.sin(phi/2) * Math.cos(theta/2) * Math.sin(gamma/2);
		q3 = Math.sin(phi/2) * Math.cos(theta/2) * Math.cos(gamma/2) - Math.cos(phi/2) * Math.sin(theta/2) * Math.sin(gamma/2);

		C11 = Math.pow(q0,2) + Math.pow(q1,2) - Math.pow(q2,2) - Math.pow(q3,2);
		C12 = 2 * (q1*q2 + q0*q3);
		C13 = 2 * (q1*q3 - q0*q2);
		C21 = 2 * (q1*q2 - q0*q3);
		C22 = Math.pow(q0,2) - Math.pow(q1,2) + Math.pow(q2,2) - Math.pow(q3,2);
		C23 = 2 * (q0*q1 + q2*q3);
		C31 = 2 * (q1*q3 + q0*q2);
		C32 = 2 * (q2*q3 - q0*q1);
		C33 = Math.pow(q0,2) - Math.pow(q1,2) - Math.pow(q2,2) + Math.pow(q3,2);
	}

	/****��̬����****/
	/*
	public static void updateAttitude(ObjectDatas user) {
		float theta = user.getTheta();
		float gamma = user.getGamma();
		float phi   = user.getPhi();
		float T = 0.05;

		float[] gyroscopeValues = user.getgyroscopeValues();
		double[] rotationVector = new double[3];
		//��������ø��ӣ���һ����

	}
	*/
	
}
