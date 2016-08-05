package deadreckoning.object;

public class ObjectDatas {
	private float[] accelerometerValues = new float[3];	 
	private float[] magneticValues = new float[3];
	private float[] gyroscopeValues = new float[3];
	private float[] orientationDatas = new float[3];	//¸÷Æ«Ïò½ÇÖµ
	//private double[] trueAccelerometer0 = new double[3];
	private double[] trueAccelerometer = new double[3];	//³ýÈ¥ÖØÁ¦¼ÓËÙ¶ÈºóµÄ¼ÓËÙ¶ÈÖµ
	private double[] distanceDatas = new double[3];
	//private double[] v = new double[3];
	
	private int step = 0;	//����
	private int statustemp = 1;	//��һ״̬�ϳɼ��ٶȱ仯״̬��1Ϊ����0Ϊ��
	private int uppoint = 0;	//�ϳɼ��ٶ��ۻ����ӵĲ�������
	private int downpoint = 0;	//�ϳɼ��ٶ��ۻ���С�Ĳ�������
	private int periodpoint = 0;	//һ�����ڵĲ�������
	private double frequency = 0;	//��Ƶ
	private double length = 0;		//������
	private double distance = 0;	//���߾���
	
	private float g = 0;
	private float[] averageAccelerometer = new float[3];
	private int straightPoint = 0;	//�ۼ�ֱ�еĲ�����������������ƽ��ֵ��
	private boolean straightFlag = false;

	private float theta = 0;
	private float gamma = 0;
	private float phi = 0;
	
	private float totalPhi = 0;
	private float xdistance = 0;
	private float ydistance = 0;
	
	

	public void setaccelerometerValues (float[] accelerometerValues) {
		this.accelerometerValues = accelerometerValues;
	}

	public void setmagneticValues (float[] magneticValues) {
		this.magneticValues = magneticValues;
	}

	public void setgyroscopeValues (float[] gyroscopeValues) {
		this.gyroscopeValues = gyroscopeValues;
	}

	public void setorientationDatas (float[] orientationDatas) {
		this.orientationDatas  = orientationDatas ;
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
	
	public void setaverageAccelerometer (float[] averageAccelerometer) {
		this.averageAccelerometer = averageAccelerometer;
	}
	
	public void setstraightPoint(int straightPoint) {
		this.straightPoint = straightPoint;
	}

	public void setstraightFlag(boolean straightFlag) {
		this.straightFlag = straightFlag;
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public void setstatustemp(int statustemp) {
		this.statustemp = statustemp;
	}
	
	public void setUppoint(int uppoint) {
		this.uppoint = uppoint;
	}

	public void setDownpoint(int downpoint) {
		this.downpoint = downpoint;
	}

	public void setPeriodpoint(int periodpoint) {
		this.periodpoint = periodpoint;
	}
	
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setTheta(float theta) {
		this.theta = theta;
	}
	
	public void setGamma(float gamma) {
		this.gamma = gamma;
	}

	public void setPhi(float phi) {
		this.phi = phi;
	}
	
	public void setTotalPhi(float totalPhi) {
		this.totalPhi = totalPhi;
	}
	
	public void setXdistance(float xdistance) {
		this.xdistance = xdistance;
	}
	
	public void setYdistance(float ydistance) {
		this.ydistance = ydistance;
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

	public float[] getorientationDatas() {
		return orientationDatas;
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
	
	public float[] getaverageAccelerometer() {
		return averageAccelerometer;
	}
	
	public int getstraightPoint() {
		return straightPoint;
	}
	
	public boolean getstraightFlag() {
		return straightFlag;
	}
	
	public int getstep() {
		return step;
	}
	
	public int getstatustemp() {
		return statustemp;
	}

	public int getUppoint() {
		return uppoint;
	}

	public int getDownpoint() {
		return downpoint;
	}

	public int getPeriodpoint() {
		return periodpoint;
	}

	public double getFrequency() {
		return frequency;
	}

	public double getLength() {
		return length;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public float getTheta() {
		return theta;
	}
	
	public float getGamma() {
		return gamma;
	}
	
	public float getPhi() {
		return phi;
	}
	
	public float getTotalPhi() {
		return totalPhi;
	}
	
	public float getXdistance() {
		return xdistance;
	}
	
	public float getYdistance() {
		return ydistance;
	}
	
}
