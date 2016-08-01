package deadreckoning.activity;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.example.allsensors.R;

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

import deadreckoning.object.ObjectDatas;
import deadreckoning.util.MyUtils;

public class MainActivity extends Activity{	
	private SensorManager sensorManager;
	
	//地磁�?
	private TextView anglez, angley, anglex;	
	//加�?�度
	private TextView xaccelerometerLevel, yaccelerometerLevel, zaccelerometerLevel;
	//角�?�度
	private TextView xangularVelocity, yangularVelocity, zangularVelocity;	

	
	private TextView xaccelerometerAverage, yaccelerometerAverage, zaccelerometerAverage;

	private TextView FuyangTheta0, HenggunGamma0, HangxiangPhi0;

	private TextView xaccelerometerLevelTrue, yaccelerometerLevelTrue, zaccelerometerLevelTrue;

	//鲁玫脢录陆脟 Theta鲁玫脢录赂漏脩枚陆脟拢卢 Gamma鲁玫脢录潞谩鹿枚陆脟拢卢 Phi鲁玫脢录潞陆脧貌陆脟脕卯脦陋0
	//private double theta, gamma, phi;

	//录脫脣脵露脠碌脛脝陆戮霉脰碌
	//private double ax, ay, az;
	//脳酶卤锚脰谩脫毛脰脴脕娄路陆脧貌碌脛录脨陆脟
	//private double ox, oy, oz;
	
	//步数
	private TextView steptext;
	
	//频率
	private TextView frequencytext;

	//行走距离
	private TextView distancetext;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		anglez = (TextView) findViewById(R.id.angle_z);
		angley = (TextView) findViewById(R.id.angle_y);
		anglex = (TextView) findViewById(R.id.angle_x);
		
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
				
		steptext = (TextView) findViewById(R.id.stepNumber);
		frequencytext = (TextView) findViewById(R.id.frequency);
		distancetext = (TextView) findViewById(R.id.distance);
		
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		
		Sensor magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		Sensor gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		
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
		float[] accelerometerValues = new float[3];
		float g = 0;
		float[] magneticValues = new float[3];
		float[] gyroscopeValues = new float[3];
		float[] angleDatas = new float[3];
		//double[] trueAccelerometer0 = new double[3];
		double[] accelerometerValuesTrue = new double[3];
		//double[] distanceDatas = new double[3];
		//double[] v = new double[3];
		float[] floatClear = new float[3];


		ObjectDatas user = new ObjectDatas();
		
		@Override
		public void onSensorChanged(SensorEvent event) {			
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				user.setaccelerometerValues( event.values.clone() );
			}else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
				user.setmagneticValues( event.values.clone() );
			}else if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
				user.setgyroscopeValues( event.values.clone() );
			}
			
			accelerometerValues = user.getaccelerometerValues();
			xaccelerometerLevel.setText("X original a : " + accelerometerValues[0] + " ;");
			yaccelerometerLevel.setText("Y original a : " + accelerometerValues[1] + " ;");
			zaccelerometerLevel.setText("Z original a : " + accelerometerValues[2] + " ;");
			
			g = (float) Math.sqrt( Math.pow(accelerometerValues[0],2)+Math.pow(accelerometerValues[1],2)+Math.pow(accelerometerValues[2],2) );
			user.setG(g);
			
			magneticValues = user.getmagneticValues();
			anglex.setText("X angle: " + magneticValues[0] + " ;");
			angley.setText("Y angle: " + magneticValues[1] + " ;");
			anglez.setText("Z angle: " + magneticValues[2] + " ;");
			
			gyroscopeValues = user.getgyroscopeValues();
			xangularVelocity.setText("X angular Velocity: " + gyroscopeValues[0] + " ;");
			yangularVelocity.setText("Y angular Velocity: " + gyroscopeValues[1] + " ;");
			zangularVelocity.setText("Z angular Velocity: " + gyroscopeValues[2] + " ;");	
			
			MyUtils.maxTest(user);
			steptext.setText("Step: " + user.getstep() + " ;");
			frequencytext.setText("Frequency: " + user.getFrequency() + " Hz;");
			distancetext.setText("North distance: " + user.getDistance() + " m;");
					
			MyUtils.averageAccelerometerUpdate(user);
			MyUtils.updateAttitude(user);
			if( user.getstraightFlag() ) {
				HangxiangPhi0.setText("Phi is: " + user.getPhi() + " ;" );				
			}
			else {
				HangxiangPhi0.setText("Phi is: " + user.getPhi() + " ;" );
				user.setstraightPoint(1);
				user.setaverageAccelerometer(floatClear);				
			}
				



			
			/*
			if (i < N) {
				user.setsumaccelerometerx( user.getsumaccelerometerx() + accelerometerValues[0] ); 
				user.setsumaccelerometery( user.getsumaccelerometery() + accelerometerValues[1] );
				user.setsumaccelerometerz( user.getsumaccelerometerz() + accelerometerValues[2] );
				i++;
			}
			else {
				//驴陋脢录录脝脣茫脝芦脧貌陆脟
				MyUtils.deflectAngle(user, N);
				//碌脙碌陆鲁媒脠楼脰脴脕娄录脫脣脵露脠碌脛脮忙脢碌录脫脣脵露脠
				MyUtils.getTrueaccelerometer(user);
				
				//驴陋脢录录脝脣茫戮脿脌毛
				//MyUtils.walk(trueAccelerometer, distanceDatas, v);
				
				//脰脴脰脙
				i = 0;
				user.setsumaccelerometerx(0);
				user.setsumaccelerometery(0);
				user.setsumaccelerometerz(0);
			}
			 */
			
			/*
			angleDatas = user.getangleDatas();
			FuyangTheta0.setText("Theta0 is: " + angleDatas[0] + " ;" );
			HenggunGamma0.setText("Gamma0 is: " + angleDatas[1] + " ;" );
			HangxiangPhi0.setText("Phi0 is: " + angleDatas[2] + " ;" );		
			
			
			accelerometerValuesTrue = user.gettrueAccelerometer();
			xaccelerometerLevelTrue.setText("X true a: " + accelerometerValuesTrue[0] + ";");
			yaccelerometerLevelTrue.setText("Y true a: " + accelerometerValuesTrue[1] + ";");
			zaccelerometerLevelTrue.setText("Z true a: " + accelerometerValuesTrue[2] + ";");
			*/
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

			
			//陆芦脢媒戮脻脨麓脠毛脦脛录镁
			FileOutputStream out = null;
			BufferedWriter writer = null;
			//String data2 = "TrueAccelerometer is: ";
			//String data = Double.toString(Math.sqrt( Math.pow(accelerometerValues[0], 2) + Math.pow(accelerometerValues[1], 2) + Math.pow(accelerometerValues[2], 2) ) );
			String data = Float.toString(user.getPhi());
			try {
				out = openFileOutput("data", Context.MODE_APPEND);
				writer = new BufferedWriter(new OutputStreamWriter(out));
				writer.write( data+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   " \n");
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
			// TODO 
			
		}
	};

}


