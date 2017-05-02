package com.example.yummy;

import android.app.Activity;
import android.app.KeyguardManager.OnKeyguardExitResult;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Signup extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    
        
        	LinearLayout osll=(LinearLayout)findViewById(R.id.sll);
        final EditText oetfname=(EditText)findViewById(R.id.setfirst);
        final EditText oetlname=(EditText)findViewById(R.id.setlast);
        final EditText oetemail=(EditText)findViewById(R.id.setmail);
        final EditText oetuname=(EditText)findViewById(R.id.setuname);
        final EditText oetpass=(EditText)findViewById(R.id.setpass);
        final EditText oetrepass=(EditText)findViewById(R.id.setrepass);
        
        final RadioGroup org=(RadioGroup)findViewById(R.id.rgsex);
        Button obtnsub=(Button)findViewById(R.id.sbutsubmit);
        Button obtncanc=(Button)findViewById(R.id.sbutcancel);
        final DatePicker obj=(DatePicker)findViewById(R.id.datePicker);
        
        
        obtnsub.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			String fname=oetfname.getText().toString();	
			String lname=oetlname.getText().toString();
			String email=oetemail.getText().toString();
			String pass=oetpass.getText().toString();
			String repass=oetrepass.getText().toString();
			String uname=oetuname.getText().toString();
			int day=obj.getDayOfMonth();
	        int m=obj.getMonth();
	        int y=obj.getYear();	
			
	        if(uname.equals("")||fname.equals("")||lname.equals("")||email.equals("")||pass.equals("")||repass.equals(""))
	        {
	        Toast.makeText(getApplicationContext(), "Please fill all details", 2000).show();	
	        }
	        else
	        {
	        	if((repass.equals(pass))&&(org.getCheckedRadioButtonId()>0))
	        	{
	        		dbyummy obj=new dbyummy(getApplicationContext(), "yummy4", null,1);
	                SQLiteDatabase db=obj.getWritableDatabase();
	                RadioButton orbsex=(RadioButton)findViewById(org.getCheckedRadioButtonId());
	                String gender=orbsex.getText().toString();
	                String dob="day"+"/"+"m"+"/"+"y";
	                db.execSQL("insert into user values('"+uname+"','"+fname+"','"+lname+"','"+pass+"','"+gender+"','"+email+"','"+dob+"')");
	                Intent in=new Intent(getApplicationContext(), Login.class);
	                startActivity(in);
	        	finish();
	        	}
	        	else
	        	{
	        		Toast.makeText(getApplicationContext(), "Password do not match. Try again.", 2000).show();
	        	}
	        }
	        
			}
		});
        
        obtncanc.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();
			}
		});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_signup, menu);
        return true;
    }
}
