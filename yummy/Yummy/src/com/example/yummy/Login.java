package com.example.yummy;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText oetuser=(EditText)findViewById(R.id.letuser);
        final EditText oetpass=(EditText)findViewById(R.id.letpasss);
        Button obtnlog=(Button)findViewById(R.id.lbtnlog);
        Button obtncancel=(Button)findViewById(R.id.lbtncancel);
        
        obtnlog.setOnClickListener(new OnClickListener() {
    		
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			
    		
    			String ur=oetuser.getText().toString();
    			String pw=oetpass.getText().toString();
    	        dbyummy obj=new dbyummy(getApplicationContext(), "yummy4", null,1);
    	        SQLiteDatabase db=obj.getWritableDatabase();
    	    
    	        if(ur.equals("")||pw.equals(""))
    	        {
    	        Toast.makeText(getApplicationContext(), "No user name or password entered", 2000);	
    	        }
    	        else
    	        {
    	        Cursor cs=db.rawQuery("select password from user where user_name='"+ur+"'",null);
    	        if(cs.moveToNext())
    	        {
    	        	if(pw.equals(cs.getString(0)))
    	        			{
    	        			Intent in=new Intent(getApplicationContext(), Goto.class);
    	        			startActivity(in);
    	        			finish();
    	        			}
    	        	else
    	        	{
    	        		Toast.makeText(getApplicationContext(), "Wrong password", 3000).show();
    	        	oetpass.setText("");
    	        	}
    	        }
    	        else
    	        {
    	        	Toast.makeText(getApplicationContext(), "Wrong username", 3000).show();
    	        }
    	        
    		}   			
    		}
    	});
        
        obtncancel.setOnClickListener(new OnClickListener() {
    		
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    		finish();
    		}
    	});


    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_login, menu);
        return true;
    }
}
