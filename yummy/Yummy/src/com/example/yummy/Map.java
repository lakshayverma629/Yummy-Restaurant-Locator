package com.example.yummy;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

public class Map extends Activity {
GoogleMap gmap1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    gmap1=((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
    dbyummy obj=new dbyummy(getApplicationContext(), "yummy4", null,1);
        SQLiteDatabase db=obj.getWritableDatabase();
        
        Cursor cur=db.rawQuery("select * from latlong", null);
    if(cur.moveToNext())
    {
    	do{
    		Double lt=Double.parseDouble(cur.getString(1));
    		Double ln=Double.parseDouble(cur.getString(2));
   
    		gmap1.addMarker(new MarkerOptions().position(new LatLng(lt, ln)).title(cur.getString(0)));
    	}while(cur.moveToNext());
    }
        		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_map, menu);
        return true;
    }
}
