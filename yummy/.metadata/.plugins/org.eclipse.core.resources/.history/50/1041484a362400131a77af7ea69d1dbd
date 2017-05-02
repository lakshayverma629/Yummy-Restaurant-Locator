package com.example.yummy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class dbyummy extends SQLiteOpenHelper {

	public dbyummy(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	db.execSQL("create table user(user_name varchar(25),f_name varchar(20),l_name varchar(20),password varchar(20),gender varchar(10),email varchar(25),d_o_b varchar(20))");
	db.execSQL("create table latlong(place varchar(20),lat varchar(35),long varchar(35))");
	db.execSQL("create table chandigarh(table_no integer,status varchar(20),time_booked varchar(30))");	
	db.execSQL("create table kurukshetra(table_no integer,status varchar(20),time_booked varchar(30))");	
	db.execSQL("create table panipat(table_no integer,status varchar(20),time_booked varchar(30))");	
	db.execSQL("create table delhi(table_no integer,status varchar(20),time_booked varchar(30))");	
	db.execSQL("create table karnal(table_no integer,status varchar(20),time_booked varchar(30))");	
	db.execSQL("create table yamunanagar(table_no integer,status varchar(20),time_booked varchar(30))");	
	db.execSQL("create table radaur(table_no integer,status varchar(20),time_booked varchar(30))");	
	db.execSQL("create table ladwa(table_no integer,status varchar(20),time_booked varchar(30))");	
	db.execSQL("create table ambala(table_no integer,status varchar(20),time_booked varchar(30))");	
	
	
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
