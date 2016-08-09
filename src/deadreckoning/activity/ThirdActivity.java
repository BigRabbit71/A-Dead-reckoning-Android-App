package deadreckoning.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.example.allsensors.R;

import deadreckoning.graph.MyView;



public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.third_layout);
        
        //Intent intent = getIntent();
      
      	FrameLayout root=(FrameLayout)findViewById(R.id.root);
      	root.addView(new MyView(ThirdActivity.this));
    }

}
