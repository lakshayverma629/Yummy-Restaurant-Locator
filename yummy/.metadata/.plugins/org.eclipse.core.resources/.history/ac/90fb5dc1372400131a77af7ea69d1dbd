package com.example.yummy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class Yummy extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yummy);
        
        ImageView oaivlogo=(ImageView)findViewById(R.id.aivlogo);
        Animation an=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alp);
    	
        android.util.Log.i("Data present", "start");
    	
        oaivlogo.setAnimation(an);
    	
    an.setAnimationListener(new AnimationListener() {
		
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
		    			
		}
		
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			Intent in=new Intent(getApplicationContext(), Pass.class);
			startActivity(in);
		finish();
		}
	});

           }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_yummy, menu);
        return true;
    }
}
