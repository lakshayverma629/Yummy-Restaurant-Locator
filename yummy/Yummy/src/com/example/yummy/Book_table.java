package com.example.yummy;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import android.R.string;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.Time;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;

public class Book_table extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_table);
   final Spinner obspnres=(Spinner)findViewById(R.id.bspnres);
  final Spinner obspntab=(Spinner)findViewById(R.id.bspntab);
   
   final ArrayAdapter a1=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1);
   
   Button obbtnbook=(Button)findViewById(R.id.bbtnbook);
  Button obbtnback=(Button)findViewById(R.id.bbtnback);
Button obbtnshow=(Button)findViewById(R.id.bbtnshow);   
   final ArrayAdapter a=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item);
   a.add("none");
   a.add("chandigarh");
   a.add("ladwa");
   a.add("delhi");
   a.add("radaur");
   a.add("yamunanagar");
   a.add("panipat");
   a.add("ambala");
   a.add("karnal");
 
 obspnres.setAdapter(a);
 final ArrayAdapter tabinfo=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item);  
 
 	dbyummy obj=new dbyummy(getApplicationContext(), "yummy4", null,1);
 
 	final SQLiteDatabase db=obj.getWritableDatabase();

 obbtnback.setOnClickListener(new OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent in=new Intent(getApplicationContext(), Goto.class);
	
	startActivity(in);
	finish();
	}
});
 
 obbtnbook.setOnClickListener(new OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
	String tab=obspntab.getSelectedItem().toString();	
	String cit=obspnres.getSelectedItem().toString();
	
	if(tab.equals("")||cit.equals("none"))
	{
		Toast.makeText(getApplicationContext(), "Fill choices first", 3000);
	}
	else
	{
		String time=Long.toString(System.currentTimeMillis());
		
	db.execSQL("update '"+cit+"' set time_booked = '"+time+"' where table_no= '"+tab+"'");
	db.execSQL("update '"+cit+"' set status= 'booked' where table_no= '"+tab+"'");
	Toast.makeText(getApplicationContext(), "Your table is booked", 2000);
	long etime=System.currentTimeMillis()+86400000;
	
	/*
	for(int i=0;i<59;i++)
	{
		for(int j=0;j<59;j++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(i==59)
		{
			db.execSQL("update '"+cit+"' set status='vacant' and time_booked = '' where table_no= '"+tab+"'");
		}
		}
	}
	
	*/
	}}
});
 
 obbtnshow.setOnClickListener(new OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
	String ct=obspnres.getSelectedItem().toString();
	obspntab.setAdapter(a1);
	tabinfo.clear();
	if(ct.equals("none"))
	{
	Toast.makeText(getApplicationContext(), "Select one city", 3000).show();	
	}
	else
	{
		Cursor cr=db.rawQuery("select table_no from '"+ct+"' where status= 'vacant' ", null);
	if(cr.moveToNext())
	{
		do{
		String st=cr.getString(0); 
		tabinfo.add(st);
	}while(cr.moveToNext());
		}
	else
	{
		Toast.makeText(getApplicationContext(), "No data", 3000).show();
	}
	}	
	obspntab.setAdapter(tabinfo);
	
	}
});
 
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_book_table, menu);
        return true;
    }
}
