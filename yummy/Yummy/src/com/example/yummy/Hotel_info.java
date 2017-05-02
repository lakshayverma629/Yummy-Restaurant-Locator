package com.example.yummy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

public class Hotel_info extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_info);
   
        Button ohbtnshow=(Button)findViewById(R.id.hbtnshow);

        Button ohbtnback=(Button)findViewById(R.id.hbtnback);
        
        final Spinner ohspnres=(Spinner)findViewById(R.id.hspnres);
        
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
      
        ohspnres.setAdapter(a);
        
     final ArrayAdapter rs=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1);  
        
    
        final GridView ohgridView=(GridView)findViewById(R.id.hgridView);
        	ohgridView.setNumColumns(1);
        dbyummy obj=new dbyummy(getApplicationContext(), "yummy4", null,1);
    
        final SQLiteDatabase db=obj.getWritableDatabase();
    
        
ohbtnshow.setOnClickListener(new OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub

		String city=ohspnres.getSelectedItem().toString();
		rs.clear();
		
		if(city.equals("none"))
		{
		Toast.makeText(getApplicationContext(), "Select one city", 3000).show();	
		}
		else
		{
			Cursor c=db.rawQuery("select * from '"+city+"'", null);
			if(c.moveToNext())
			{
				do
				{
					String stat=(Integer.toString(c.getInt(0)))+"    "+c.getString(1);
					rs.add(stat);
					
				}while(c.moveToNext());
					c.close();		
				ohgridView.setAdapter(rs);
			}
			else {
				Toast.makeText(getApplicationContext(), "No data", 3000).show();
			}
		}	
	
	}
});
        
        ohbtnback.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent in=new Intent(getApplicationContext(), Goto.class);
				startActivity(in);
				finish();
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hotel_info, menu);
        return true;
    }
}
