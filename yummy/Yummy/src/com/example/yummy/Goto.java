package com.example.yummy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Goto extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto);
    Button obutret=(Button)findViewById(R.id.gbtnret);
    Button obutstat=(Button)findViewById(R.id.gbtnstat);
    Button obtnst=(Button)findViewById(R.id.gbtnst);
    Button obtnbook=(Button)findViewById(R.id.gbtnbook);
    Button obtnabt=(Button)findViewById(R.id.gbtnabt);
    
    obtnabt.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
		Intent in1=new Intent(getApplicationContext(),About.class);
		startActivity(in1);
		}
	});
    
    obutstat.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent in1=new Intent(getApplicationContext(),Time_remaining.class);
			startActivity(in1);
		}
	});
    
    obutret.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent in2=new Intent(getApplicationContext(),Map.class);
				startActivity(in2);
		
		}
	});
    obtnst.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
		Intent in2=new Intent(getApplicationContext(),Hotel_info.class);	
		startActivity(in2);
		finish();
		}
	});
    
    obtnbook.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
		Intent in3=new Intent(getApplicationContext(), Book_table.class);	
		startActivity(in3);
		finish();
		}
	});
    
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_goto, menu);
        return true;
    }
}
