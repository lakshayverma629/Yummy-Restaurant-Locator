package com.example.yummy;

import java.sql.Date;

import android.R.animator;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Time_remaining extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_remaining);
        

        final Spinner otspnres=(Spinner)findViewById(R.id.tspnres);
        final Spinner otspntab=(Spinner)findViewById(R.id.tspntab);
        Button otbtnshow=(Button)findViewById(R.id.tbtnshow);
        Button otbtnshwtab=(Button)findViewById(R.id.tbtnshwtab);
        final TextView ottvtimerem=(TextView)findViewById(R.id.ttvtimerem);
        
        dbyummy obj=new dbyummy(getApplicationContext(), "yummy4", null,1);
        final SQLiteDatabase db=obj.getWritableDatabase();
        
        ArrayAdapter a1=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item );
        a1.add("none");
        a1.add("chandigarh");
        a1.add("ladwa");
        a1.add("delhi");
        a1.add("radaur");
        a1.add("yamunanagar");
        a1.add("panipat");
        a1.add("ambala");
        a1.add("karnal");
      
        otspnres.setAdapter(a1);
        final ArrayAdapter tab=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1);
        
        
    otbtnshow.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		String res=otspnres.getSelectedItem().toString();
		String tab=otspntab.getSelectedItem().toString();
			Cursor cs=db.rawQuery("select * from '"+res+"' where table_no= '"+tab+"' ", null);
		
			
			if(cs.moveToNext())
		{
			/*
			long seconds=remtime/1000;
			long minutes=seconds/60;
			long ssec=seconds%60;
			long hours=minutes/60;
			long minut=minutes%60;
			 
			*/
			}
		
		long bktime=Long.parseLong(cs.getString(2));
		long crnttime=System.currentTimeMillis();
		long remtime=crnttime-bktime;
		
		
		String time=Long.toString(remtime);
		ottvtimerem.setText(time);
	
		}
	});
    
    otbtnshwtab.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 
			String ct=otspnres.getSelectedItem().toString();
			tab.clear();
			
			
			Cursor cs=db.rawQuery("select * from '"+ct+"'  ", null);
		       
			if(cs.moveToNext())
		       	{
		       		do{
		       		if(cs.getString(1).equals("booked"))
		       		{
		       		tab.add(cs.getString(0));
		       	}
		       		}while(cs.moveToNext());
		       	}
		       	else{
		       		
		       		Toast.makeText(getApplicationContext(), "No table booked", 2000);
		       	}
		otspntab.setAdapter(tab);
		}
	});
    
    
    }

    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
    	
    	
    	
		super.onResume();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_time_remaining, menu);
        return true;
    }
}
