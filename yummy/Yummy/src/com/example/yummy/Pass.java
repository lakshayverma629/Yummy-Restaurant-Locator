package com.example.yummy;

import android.os.Bundle;
import android.provider.Settings.System;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class Pass extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
   
        
        dbyummy obj=new dbyummy(getApplicationContext(), "yummy4", null,1);
        SQLiteDatabase db=obj.getWritableDatabase();
        
        Cursor c=db.rawQuery("select * from latlong",null);
        if(c.moveToNext())
        {
        	
        }
        else
        {

        	android.util.Log.i("Data present", "latlon");
        db.execSQL("insert into latlong values('Chandigarh','30.7500','76.7800')");
    	db.execSQL("insert into latlong values('Kurukshetra','29.9657','76.8370')");
    	db.execSQL("insert into latlong values('Radaur','30.0300','77.0500')");
    	db.execSQL("insert into latlong values('Yamuna Nagar','30.1000','77.2800')");
    	db.execSQL("insert into latlong values('Ladwa','30.0000','77.0500')");
    	db.execSQL("insert into latlong values('Delhi','28.6100','77.2300')");
    	db.execSQL("insert into latlong values('Panipat','29.3900','76.9700')");
    	db.execSQL("insert into latlong values('Karnal','29.6900','76.9800')");
    	db.execSQL("insert into latlong values('Ambala','30.3800','76.7800')");
        }
        c.close();
        
        Cursor c1=db.rawQuery("select * from chandigarh", null);
        if(c1.moveToNext())
        {
        	android.util.Log.i("Data present", "Chandigarh");
        }
        else
        {

        	android.util.Log.i("Data present", "");
        	String st=Long.toString(java.lang.System.currentTimeMillis());
        	
        db.execSQL("insert into chandigarh values(1,'booked','"+st+"')");
        db.execSQL("insert into chandigarh values(2,'booked','"+st+"')");
        db.execSQL("insert into chandigarh values(3,'booked','"+st+"')");
        db.execSQL("insert into chandigarh values(4,'vacant','0')");
        db.execSQL("insert into chandigarh values(5,'vacant','0')");
        }
        c1.close();
        
        Cursor c2=db.rawQuery("select * from ambala", null);
        if(c2.moveToNext())
        {
        	android.util.Log.i("Data present", "ambala");
        }
        else
        {

        db.execSQL("insert into ambala values(1,'vacant','0')");
        db.execSQL("insert into ambala values(2,'vacant','0')");
        db.execSQL("insert into ambala values(3,'vacant','0')");
        db.execSQL("insert into ambala values(4,'vacant','0')");
        db.execSQL("insert into ambala values(5,'vacant','0')");
        }
        c2.close();
        
        Cursor c3=db.rawQuery("select * from karnal", null);
        if(c3.moveToNext())
        {
        	android.util.Log.i("Data present", "karnal");
        }
        else
        {

        db.execSQL("insert into karnal values(1,'vacant','0')");
        db.execSQL("insert into karnal values(2,'vacant','0')");
        db.execSQL("insert into karnal values(3,'vacant','0')");
        db.execSQL("insert into karnal values(4,'vacant','0')");
        db.execSQL("insert into karnal values(5,'vacant','0')");
        }
        c3.close();
        
        Cursor c4=db.rawQuery("select * from panipat", null);
        if(c4.moveToNext())
        {
        	android.util.Log.i("Data present", "panipat");
        }
        else
        {

        db.execSQL("insert into panipat values(1,'vacant','0')");
        db.execSQL("insert into panipat values(2,'vacant','0')");
        db.execSQL("insert into panipat values(3,'vacant','0')");
        db.execSQL("insert into panipat values(4,'vacant','0')");
        db.execSQL("insert into panipat values(5,'vacant','0')");
        }
        c4.close();
        
        Cursor c5=db.rawQuery("select * from yamunanagar", null);
        if(c5.moveToNext())
        {
        	android.util.Log.i("Data present", "yamunanagar");
        }
        else
        {

        db.execSQL("insert into yamunanagar values(1,'vacant','0')");
        db.execSQL("insert into yamunanagar values(2,'vacant','0')");
        db.execSQL("insert into yamunanagar values(3,'vacant','0')");
        db.execSQL("insert into yamunanagar values(4,'vacant','0')");
        db.execSQL("insert into yamunanagar values(5,'vacant','0')");
        }
        c5.close();
        
        Cursor c6=db.rawQuery("select * from radaur", null);
        if(c6.moveToNext())
        {
        	android.util.Log.i("Data present", "Chandigarh");
        }
        else
        {

        db.execSQL("insert into radaur values(1,'vacant','0')");
        db.execSQL("insert into radaur values(2,'vacant','0')");
        db.execSQL("insert into radaur values(3,'vacant','0')");
        db.execSQL("insert into radaur values(4,'vacant','0')");
        db.execSQL("insert into radaur values(5,'vacant','0')");
        }
        c6.close();
        
        Cursor c7=db.rawQuery("select * from kurukshetra", null);
        if(c7.moveToNext())
        {
        	android.util.Log.i("Data present", "Chandigarh");
        }
        else
        {

        db.execSQL("insert into kurukshetra values(1,'vacant','0')");
        db.execSQL("insert into kurukshetra values(2,'vacant','0')");
        db.execSQL("insert into kurukshetra values(3,'vacant','0')");
        db.execSQL("insert into kurukshetra values(4,'vacant','0')");
        db.execSQL("insert into kurukshetra values(5,'vacant','0')");
        }
        c7.close();
        
        Cursor c8=db.rawQuery("select * from delhi", null);
        if(c8.moveToNext())
        {
        	android.util.Log.i("Data present", "Chandigarh");
        }
        else
        {

        db.execSQL("insert into delhi values(1,'vacant','0')");
        db.execSQL("insert into delhi values(2,'vacant','0')");
        db.execSQL("insert into delhi values(3,'vacant','0')");
        db.execSQL("insert into delhi values(4,'vacant','0')");
        db.execSQL("insert into delhi values(5,'vacant','0')");
        }
        c8.close();
        Cursor c9=db.rawQuery("select * from ladwa", null);
        if(c9.moveToNext())
        {
        	android.util.Log.i("Data present", "Chandigarh");
        }
        else
        {

        db.execSQL("insert into ladwa values(1,'vacant','0')");
        db.execSQL("insert into ladwa values(2,'vacant','0')");
        db.execSQL("insert into ladwa values(3,'vacant','0')");
        db.execSQL("insert into ladwa values(4,'vacant','0')");
        db.execSQL("insert into ladwa values(5,'vacant','0')");
        }        
        
        c.close();
  
        Cursor pc=db.rawQuery("select * from user",null);
        
        if(pc.moveToNext())
        {
        Intent in=new Intent(getApplicationContext(), Login.class);
        startActivity(in);
        finish();
        }
        else
        {
        	Intent in=new Intent(getApplicationContext(), Signup.class);
            startActivity(in);
        
        finish();
        }

c.close();        

    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pass, menu);
        return true;
    }
}
