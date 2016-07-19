package com.example.allsensors;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{	
	private SensorManager sensorManager;
	
	//�شŽ�
	private TextView anglez, angley, anglex;	
	//���ٶ�
	private TextView xaccelerometerLevel, yaccelerometerLevel, zaccelerometerLevel;
	//���ٶ�
	private TextView xangularVelocity, yangularVelocity, zangularVelocity;	

	//���ٶȵ�ƽ��ֵ
	private TextView xaccelerometerAverage, yaccelerometerAverage, zaccelerometerAverage;
	//��ʼ�� Theta��ʼ�����ǣ� Gamma��ʼ����ǣ� Phi��ʼ�������Ϊ0
	private TextView FuyangTheta0, HenggunGamma0, HangxiangPhi0;
	//��ȥ�����ĸ�����ٶ�
	private TextView xaccelerometerLevelTrue, yaccelerometerLevelTrue, zaccelerometerLevelTrue;

	//���߾���
	private TextView xdistance, ydistance, zdistance;
	
	//��ʼ�� Theta��ʼ�����ǣ� Gamma��ʼ����ǣ� Phi��ʼ�������Ϊ0
	//private double theta, gamma, phi;

	//���ٶȵ�ƽ��ֵ
	//private double ax, ay, az;
	//����������������ļн�
	//private double ox, oy, oz;
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//phi = 0 ;
		
		/*
		anglez = (TextView) findViewById(R.id.angle_z);
		angley = (TextView) findViewById(R.id.angle_y);
		anglex = (TextView) findViewById(R.id.angle_x);
		*/
		
		xaccelerometerLevel = (TextView) findViewById(R.id.accelerometerLevel_x);
		yaccelerometerLevel = (TextView) findViewById(R.id.accelerometerLevel_y);
		zaccelerometerLevel = (TextView) findViewById(R.id.accelerometerLevel_z);
		
		xangularVelocity = (TextView) findViewById(R.id.angularVelocity_x);
		yangularVelocity = (TextView) findViewById(R.id.angularVelocity_y);
		zangularVelocity = (TextView) findViewById(R.id.angularVelocity_z);
		
		FuyangTheta0 = (TextView) findViewById(R.id.Theta_0);
		HenggunGamma0 = (TextView) findViewById(R.id.Gamma_0);
		HangxiangPhi0   = (TextView) findViewById(R.id.Phi_0);
		
		/*
		xaccelerometerAverage = (TextView) findViewById(R.id.accelerometerAverage_x);
		yaccelerometerAverage = (TextView) findViewById(R.id.accelerometerAverage_y);
		zaccelerometerAverage = (TextView) findViewById(R.id.accelerometerAverage_z);
		*/

		xaccelerometerLevelTrue = (TextView) findViewById(R.id.accelerometerLevelTrue_x);
		yaccelerometerLevelTrue = (TextView) findViewById(R.id.accelerometerLevelTrue_y);
		zaccelerometerLevelTrue = (TextView) findViewById(R.id.accelerometerLevelTrue_z);
			
		/*
		xdistance = (TextView) findViewById(R.id.distance_x);
		ydistance = (TextView) findViewById(R.id.distance_y);
		zdistance = (TextView) findViewById(R.id.distance_z);
		*/
		
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		
		Sensor magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);	//�Ƕȴ�����
		Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);	//���ٶȴ�����
		Sensor gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);	//������
		
		sensorManager.registerListener(listener, magneticSensor, SensorManager.SENSOR_DELAY_GAME);	//game is faster than normal
		sensorManager.registerListener(listener, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME);	
		sensorManager.registerListener(listener, gyroscopeSensor, SensorManager.SENSOR_DELAY_GAME);
	
		Button button1 = (Button) findViewById(R.id.button_1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
			
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(sensorManager != null) {
			sensorManager.unregisterListener(listener);
		}
	}
	
	private SensorEventListener listener = new SensorEventListener() {
		float[] accelerometerValues = new float[3];	 //���������ԭʼֵ
		//float[] magneticValues = new float[3];
		float[] gyroscopeValues = new float[3];
		float[] angleDatas = new float[3];
		//double[] trueAccelerometer0 = new double[3];
		double[] accelerometerValuesTrue = new double[3];	//��ȥ�������ٶȺ�ļ��ٶ�ֵ
		//double[] distanceDatas = new double[3];
		//double[] v = new double[3];

		int i = 0;	//���ڼ���
		int N = 20;	//����ǰN�������������ʼԭʼ���ٶ�ƽ��ֵ
		//float sumx = 0;
		//float sumy = 0;
		//float sumz = 0;
		//double ax0, ay0, az0;

		objectDatas user = new objectDatas();
		
		@Override
		public void onSensorChanged(SensorEvent event) {			
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				//��ֵҪ����clone()����
				user.setaccelerometerValues( event.values.clone() );
				//accelerometerValues = event.values.clone();
			}else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
				user.setmagneticValues( event.values.clone() );
				//magneticValues = event.values.clone();
			}else if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
				user.setgyroscopeValues( event.values.clone() );
				//gyroscopeValues = event.values.clone();
			}

			accelerometerValues = user.getaccelerometerValues();
			xaccelerometerLevel.setText("X original a : " + accelerometerValues[0] + " ;");
			yaccelerometerLevel.setText("Y original a : " + accelerometerValues[1] + " ;");
			zaccelerometerLevel.setText("Z original a : " + accelerometerValues[2] + " ;");
			
			gyroscopeValues = user.getgyroscopeValues();
			xangularVelocity.setText("X angular Velocity: " + gyroscopeValues[0] + " ;");
			yangularVelocity.setText("Y angular Velocity: " + gyroscopeValues[1] + " ;");
			zangularVelocity.setText("Z angular Velocity: " + gyroscopeValues[2] + " ;");
			
			if (i < N) {
				user.setsumaccelerometerx( user.getsumaccelerometerx() + accelerometerValues[0] ); 
				user.setsumaccelerometery( user.getsumaccelerometery() + accelerometerValues[1] );
				user.setsumaccelerometerz( user.getsumaccelerometerz() + accelerometerValues[2] );
				i++;
			}
			else {
				//��ʼ����ƫ���
				MyUtils.deflectAngle(user, N);
				//�õ���ȥ�������ٶȵ���ʵ���ٶ�
				MyUtils.getTrueaccelerometer(user);
				
				//��ʼ�������
				//MyUtils.walk(trueAccelerometer, distanceDatas, v);				
			}
		
			
			angleDatas = user.getangleDatas();
			FuyangTheta0.setText("Theta0 is: " + angleDatas[0] + " ;" );
			HenggunGamma0.setText("Gamma0 is: " + angleDatas[1] + " ;" );
			HangxiangPhi0.setText("Phi0 is: " + angleDatas[2] + " ;" );		
			
			
			accelerometerValuesTrue = user.gettrueAccelerometer();
			xaccelerometerLevelTrue.setText("X true a: " + accelerometerValuesTrue[0] + ";");
			yaccelerometerLevelTrue.setText("Y true a: " + accelerometerValuesTrue[1] + ";");
			zaccelerometerLevelTrue.setText("Z true a: " + accelerometerValuesTrue[2] + ";");
			
			/*
			xdistance.setText("X distance: " + (float)distanceDatas[0] + " m;");
			ydistance.setText("Y distance: " + (float)distanceDatas[1] + " m;");
			zdistance.setText("Z distance: " + (float)distanceDatas[2]+ " m;");
			*/
			
			/*
			float[] R = new float[9];
			float[] anglevalues = new float[3];
			SensorManager.getRotationMatrix(R, null, accelerometerValues, magneticValues);
			SensorManager.getOrientation(R, anglevalues);
			*/
			/*
			anglez.setText("Z angle is " + Math.toDegrees(anglevalues[2]) + " ;\n");
			angley.setText("Y angle is " + Math.toDegrees(anglevalues[1]) + " ;\n");
			anglex.setText("X angle is " + Math.toDegrees(anglevalues[0]) + " .\n");
			*/

			//������д���ļ�
			FileOutputStream out = null;
			BufferedWriter writer = null;
			String data2 = "TrueAccelerometer is: ";
			String data = Float.toString(accelerometerValues[0]);
			try {
				out = openFileOutput("data", Context.MODE_APPEND);
				writer = new BufferedWriter(new OutputStreamWriter(out));
				writer.write( data2 + data + "\n");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if ( writer != null ) {
						writer.close();
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}	

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO �Զ����ɵķ������
			
		}
	};
	

	/****һϵ�м���ĺ���****/
	public static class MyUtils {	
		/****�����ʼƫ��Ǻ���****/
		public static void deflectAngle(objectDatas user, int N) {

			float[] datas = new float[3];
			//g
			float averagex = user.getsumaccelerometerx()/N;
			float averagey = user.getsumaccelerometery()/N;
			float averagez = user.getsumaccelerometerz()/N;
			user.setG( (float)Math.sqrt(Math.pow(averagex, 2) + Math.pow(averagey, 2) + Math.pow(averagez, 2)) );
			
			//theta����
			datas[0] = (float)Math.asin(averagex/user.getG());	
			//gamma���� 
			datas[1] = (float)Math.atan(-averagex/averagez);
			//phi����
			datas[2] = 0;

			user.setangleDatas(datas);
		}
		
		/****������ʵ���ٶȺ���****/
		public static void getTrueaccelerometer(objectDatas user) {			
			float g = user.getG();	//�������ٶ�
			
			float[] datas = new float[3];		//��Ƕ�
			datas = user.getangleDatas();

			float[] accelerometer = new float[3];	//���ʼ������ٶ�
			accelerometer = user.getaccelerometerValues();
			float ax, ay, az;
			ax = accelerometer[0];
			ay = accelerometer[1];
			az = accelerometer[2];

			double q0, q1, q2, q3;
			double c11,c12,c13, c21,c22,c23, c31,c32,c33;	//for cbn					
			q0 = Math.cos(datas[2]) * Math.cos(datas[0]) * Math.cos(datas[1]) + Math.sin(datas[2]) * Math.sin(datas[0]) * Math.sin(datas[1]);
			q1 = Math.cos(datas[2]) * Math.cos(datas[0]) * Math.sin(datas[1]) - Math.sin(datas[2]) * Math.sin(datas[0]) * Math.cos(datas[1]);
			q2 = Math.cos(datas[2]) * Math.sin(datas[0]) * Math.cos(datas[1]) + Math.sin(datas[2]) * Math.cos(datas[0]) * Math.sin(datas[1]);
			q3 = Math.sin(datas[2]) * Math.cos(datas[0]) * Math.cos(datas[1]) - Math.cos(datas[2]) * Math.sin(datas[0]) * Math.sin(datas[1]);			
			c11 = q0*q0 + q1*q1 -q2*q2 - q3*q3;
			c12 = 2*(q1*q2 - q0*q3);
			c13 = 2*(q1*q3 + q0*q2);
			c21 = 2*(q1*q2 + q0*q3);
			c22 = q0*q0 -q1*q1 + q2*q2 -q3*q3;
			c23 = 2*(q2*q3 - q0*q1);
			c31 = 2*(q1*q3 - q0*q2);
			c32 = 2*(q0*q1 + q2*q3);
			c33 = q0*q0 - q1*q1 -q2*q2 +q3*q3;
			
			double[] accelerometerTrue = new double[3];
			accelerometerTrue[0] = c11*ax + c12*ay + c13*az;
			accelerometerTrue[1] = c21*ax + c22*ay + c23*az;
			accelerometerTrue[2] = c31*ax + c32*ay + c33*az - g;
			user.settrueAccelerometer(accelerometerTrue);
		}
		
		/****�������߾��뺯����Ȼ��һ�㶼��׼����****/
		/****���κ��������⣡��������****/
		/*
		public static void walk(double[] trueAccelerometers, double[] distance, double[] v) {
			double T = 0.02;
			
			v[0] += (trueAccelerometers[0]-0) * T;
			v[1] += (trueAccelerometers[1]-0) * T;
			v[2] += (trueAccelerometers[2]-0) * T;
			distance[0] += v[0]*T + 0.5*trueAccelerometers[0]*T*T;
			distance[1] += v[1]*T + 0.5*trueAccelerometers[1]*T*T;
			distance[2] += v[2]*T + 0.5*trueAccelerometers[2]*T*T;	
		}
		*/

		/****������ʽ�����ò�Ƶ�Ʋ�����ʽ****/
		/*
		public static double frequence(  ) {

		}

*/	
	}

	public class objectDatas {
		private float[] accelerometerValues = new float[3];	 //���������ԭʼֵ
		private float[] magneticValues = new float[3];
		private float[] gyroscopeValues = new float[3];
		private float[] angleDatas = new float[3];	//��ƫ���ֵ
		//private double[] trueAccelerometer0 = new double[3];
		private double[] trueAccelerometer = new double[3];	//��ȥ�������ٶȺ�ļ��ٶ�ֵ
		private double[] distanceDatas = new double[3];
		//private double[] v = new double[3];

		private float g = 0;	//�������ٶ�
		private float sumaccelerometerx = 0;
		private float sumaccelerometery = 0;
		private float sumaccelerometerz = 0;

		public void setaccelerometerValues (float[] accelerometerValues) {
			this.accelerometerValues = accelerometerValues;
		}

		public void setmagneticValues (float[] magneticValues) {
			this.magneticValues = magneticValues;
		}

		public void setgyroscopeValues (float[] gyroscopeValues) {
			this.gyroscopeValues = gyroscopeValues;
		}

		public void setangleDatas (float[] angleDatas) {
			this.angleDatas  = angleDatas ;
		}

		public void settrueAccelerometer (double[] trueAccelerometer) {
			this.trueAccelerometer  = trueAccelerometer ;
		}

		public void setdistanceDatas (double[] distanceDatas) {
			this.distanceDatas  = distanceDatas ;
		}

		public void setG (float g) {
			this.g = g;
		}

		public void setsumaccelerometerx(float sumaccelerometerx) {
			this.sumaccelerometerx = sumaccelerometerx;
		}

		public void setsumaccelerometery(float sumaccelerometery) {
			this.sumaccelerometery = sumaccelerometery;
		}

		public void setsumaccelerometerz(float sumaccelerometerz) {
			this.sumaccelerometerz = sumaccelerometerz;
		}

		public float[] getaccelerometerValues() {
			return accelerometerValues;
		}

		public float[] getmagneticValues() {
			return magneticValues;
		}

		public float[] getgyroscopeValues() {
			return gyroscopeValues;
		}

		public float[] getangleDatas() {
			return angleDatas;
		}

		public double[] gettrueAccelerometer() {
			return trueAccelerometer;
		}

		public double[] getdistanceDatas() {
			return distanceDatas;
		}

		public float getG() {
			return g;
		}

		public float getsumaccelerometerx() {
			return sumaccelerometerx;
		}

		public float getsumaccelerometery() {
			return sumaccelerometery;
		}

		public float getsumaccelerometerz() {
			return sumaccelerometerz;
		}

	}



	
}


