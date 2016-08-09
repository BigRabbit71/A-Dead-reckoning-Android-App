package deadreckoning.graph;

import java.util.ArrayList;

import deadreckoning.object.ObjectDatas;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class MyView extends View{
	Context mycontext;
	
	public MyView(Context context) {
		super(context);
		mycontext = context;
	}
	
	//��дOnDraw������������ÿ���ػ�ʱ����ʵ�ֻ�ͼ  
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		
		
		//ObjectDatas user = new ObjectDatas();
		//ArrayList<Float> pointList = user.getPointList();
		//float[] pts = new float[4000];
		//for (int i = 0; i < 4000; i++)
          // pts[i] = pointList.get(i);
		
		//���û��ʻ�������
		Paint paint1 = new Paint();
		paint1.setAntiAlias(true); //����ݹ���
		paint1.setColor(Color.BLACK);	//������ɫ
		paint1.setStyle(Style.FILL);	//���������ʽ		
		paint1.setStrokeWidth(5);	//���û��ʿ���
		paint1.setShadowLayer(10, 15, 15, Color.GREEN);	//������Ӱ
		
		//���û��ʻ�������
		Paint paint2 = new Paint();
		paint2.setAntiAlias(true); //����ݹ���
		paint2.setColor(Color.BLUE);	//������ɫ
		paint2.setStyle(Style.FILL);	//���������ʽ
		paint2.setStrokeWidth(5);	//���û��ʿ���
		paint2.setShadowLayer(10, 15, 15, Color.GREEN);	//������Ӱ
		
		//���û���������ɫ
		canvas.drawRGB(255, 255, 255);
		
		//������ԭ��
		canvas.drawCircle(540, 960, 10, paint1);
		//x
		canvas.drawLine(0,960,1080,960,paint1);
		//y
		canvas.drawLine(540, 0, 540, 1920, paint1);
		
		//float[] pts = new float[user.pointList.size()];
        //for (int i = 0; i < user.pointList.size(); i++)
            //pts[i] = user.pointList.get(i);
		
		//float[] pts = {1,1,10,10,100,100,1000,1000};
		//double[] pts_d = {540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,540.0,960.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,959.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,539.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,958.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,538.0,957.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,956.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,537.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,955.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,954.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,536.0,953.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,952.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,535.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,951.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,534.0,950.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,949.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,533.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,948.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,532.0,947.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,946.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,531.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,945.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,530.0,944.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,943.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,529.0,942.0,528.0,941.0,528.0,941.0,528.0,941.0,528.0,941.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,940.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,528.0,939.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,938.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,527.0,937.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,936.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,526.0,935.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,525.0,934.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0,524.0,933.0};
		//float[] pts_f = new float[4000];
		//for(int i=0; i< 4000; i++)
		//{
			//pts_f[i] = (float)pts_d[i];
		//}
		//canvas.drawPoints(pts_f,0,4000,paint2);
		//canvas.drawPoints(pts,0,5000,paint2);
		
	}
	
	
}
