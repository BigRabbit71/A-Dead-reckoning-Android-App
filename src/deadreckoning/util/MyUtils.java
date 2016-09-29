package deadreckoning.util;

import deadreckoning.object.ObjectDatas;

public final class MyUtils {
	
	/****峰值检测&步数步长处理****/
	public static void maxTest (ObjectDatas user) {	
		double delta = 0.02;
	
		float[] accelerometer = new float[3];	
		accelerometer = user.getaccelerometerValues();
		int step = user.getstep();
		int statusTemp = user.getstatustemp();	//上一状态合成加速度状态，增或者减
		int uppoint = user.getUppoint();
		int downpoint = user.getDownpoint();
		int periodpoint = user.getPeriodpoint();
		double Atemp = user.getAccelermeterTemp();	//上一状态合成加速度
		
		double frequency = user.getFrequency();
		double length = user.getLength();
		double xdistance = user.getXdistance();
		double ydistance = user.getYdistance();
			
		double A = 0;	//合成加速度
		//double Atemp = 12;	//上一状态合成加速度
		A = Math.sqrt( Math.pow(accelerometer[0], 2) + Math.pow(accelerometer[1], 2) + Math.pow(accelerometer[2], 2) );

		if( A > Atemp ) {//合成加速度是否大于阈值
			periodpoint++;
			user.setPeriodpoint(periodpoint);
			if( (periodpoint>15) && (periodpoint<100) ) {//时间间隔是否合理
				if( (Math.abs(A-Atemp)>0.7) && (Math.abs(A-Atemp)<10) ) {//加速度差值是否合理
					step++;
					user.setStep(step);				
					
					//根据步频和步长的线性关系得到步长
					frequency = 1/(periodpoint * delta);
					user.setFrequency(frequency);
					if(frequency <= 1.35) {
						length = 0.4375;
						user.setLength(length);
						xdistance += length * Math.sin(user.getPhi());
						user.setXdistance((float) xdistance);
						ydistance += length * Math.cos(user.getPhi());
						user.setYdistance((float) ydistance);
					}
					else if( (frequency>1.35) && (frequency<2.45) ) {
						length = 0.45*frequency-0.22;
						user.setLength(length);
						xdistance += length * Math.sin(user.getPhi());
						user.setXdistance((float) xdistance);
						ydistance += length * Math.cos(user.getPhi());
						user.setYdistance((float) ydistance);
					}
					else if(frequency >= 2.45){
						length = 0.9325;
						user.setLength(length);
						xdistance += length * Math.sin(user.getPhi());
						user.setXdistance((float) xdistance);
						ydistance += length * Math.cos(user.getPhi());
						user.setYdistance((float) ydistance);
					}
					
					
				}
				periodpoint = 0;
				user.setPeriodpoint(periodpoint);
			}		
		}
		
		
		
		
		/*
		if( A<Atemp ) {	//合成加速度减小
			user.setAccelermeterTemp(A);
			periodpoint++;
			user.setPeriodpoint(periodpoint);
			downpoint++;
			user.setDownpoint(downpoint);

			if(statusTemp == 1) {	//上一状态合成加速度增加
				//if( (A>12) && (downpoint>12) ) {	//一个周期结束
				if( (A>12) && (periodpoint>12) ) {	//一个周期结束?????有疑问！！！
					step++;
					user.setStep(step);

					frequency = 1/(periodpoint * delta);
					user.setFrequency(frequency);
					//根据步频和步长的线性关系得到步长
					
					if(frequency <= 1.35) {
						length = 0.4375;
						user.setLength(length);
						xdistance += length * Math.sin(user.getPhi());
						user.setXdistance((float) xdistance);
						ydistance += length * Math.cos(user.getPhi());
						user.setYdistance((float) ydistance);
					}
					else if( (frequency>1.35) && (frequency<2.45) ) {
						length = 0.45*frequency-0.22;
						user.setLength(length);
						xdistance += length * Math.sin(user.getPhi());
						user.setXdistance((float) xdistance);
						ydistance += length * Math.cos(user.getPhi());
						user.setYdistance((float) ydistance);
					}
					else if(frequency >= 2.45){
						length = 0.9325;
						user.setLength(length);
						xdistance += length * Math.sin(user.getPhi());
						user.setXdistance((float) xdistance);
						ydistance += length * Math.cos(user.getPhi());
						user.setYdistance((float) ydistance);
					}
					

					periodpoint = 0;
					user.setPeriodpoint(periodpoint);
				}
			}
			statusTemp = 0;
			user.setstatustemp(statusTemp);
		}
		else {	//合成加速度增加
			user.setAccelermeterTemp(A);
			periodpoint++;
			user.setPeriodpoint(periodpoint);
			uppoint++;
			user.setUppoint(uppoint);
			statusTemp = 1;
			user.setstatustemp(statusTemp);
		}
		*/
	}
		
	/****计算直行时加速度的算术平均值****/
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
		user.setG(g);
	}

	/****更新运动姿态****/
	public static void updateAttitude(ObjectDatas user) {
		float[] gyroscopeValues = user.getgyroscopeValues();
		//float[] averageAccelerometer = user.getaverageAccelerometer();
		float[] Accelerometer = user.getaccelerometerValues();
		float phi = 0;
		float totalPhi = 0;
		float[] rotation = new float[3];
		double T = 0.05;
		float temp0 = 0;
		float temp1 = 0;

		rotation[0] = (float) Math.toDegrees(gyroscopeValues[0] * T);
		rotation[1] = (float) Math.toDegrees(gyroscopeValues[1] * T);
		rotation[2] = (float) Math.toDegrees(gyroscopeValues[2] * T);

		if( ( Math.abs(rotation[0]) < 15 ) && ( Math.abs(rotation[1]) < 15 ) && ( Math.abs(rotation[2]) < 15 ) ) {
			user.setstraightFlag(true);
			user.setPhi(0);
		}
		else {
			user.setstraightFlag(false);
			phi = (float) ((Accelerometer[0]*rotation[0] + Accelerometer[1]*rotation[1] + Accelerometer[2]*rotation[2])/9.8);	

			//temp0 = totalPhi;
			totalPhi = user.getTotalPhi();
			totalPhi = totalPhi + phi;	//???????+=

			user.setPhi(phi);
			user.setTotalPhi(totalPhi);
			//totalPhi += user.getPhi();

		}
		//user.setTotalPhi(totalPhi);
	}

	/****航位推算****/
	public static void DR(ObjectDatas user) {
		float xdistance = user.getXdistance();
		float ydistance = user.getYdistance();
		float length = (float) user.getLength();
		float phirad = (float) Math.toRadians(user.getPhi());

	
		xdistance += (float) (length*Math.sin(phirad));	//???????????
		user.setXdistance(xdistance);
		ydistance += (float) (length*Math.cos(phirad));	//?????????????
		user.setYdistance(ydistance);	

	}








	/****初始偏向角计算****/
	public static void firstDeflectAngle(ObjectDatas user) {
		int N = 10;
		float[] accelerometerValues = user.getaccelerometerValues();
		user.setG( (float)Math.sqrt( Math.pow(accelerometerValues[0],2)+Math.pow(accelerometerValues[1],2)+Math.pow(accelerometerValues[2],2) ) );
		user.setTheta( (float)Math.asin( accelerometerValues[1]/user.getG() ) );
		user.setGamma( (float)Math.atan( -accelerometerValues[0]/accelerometerValues[2] ) );
		user.setPhi(0);
	}
	
	/****初始姿态矩阵计算****/
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

	/****姿态更新****/
	/*
	public static void updateAttitude(ObjectDatas user) {
		float theta = user.getTheta();
		float gamma = user.getGamma();
		float phi   = user.getPhi();
		float T = 0.05;

		float[] gyroscopeValues = user.getgyroscopeValues();
		double[] rotationVector = new double[3];
		//矩阵运算好复杂，放一放先

	}
	*/
	
}
