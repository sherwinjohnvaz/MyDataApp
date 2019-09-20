package com.example.dataapp;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "mydatabase2";
    public static final String TABLE_NAME = "mytable2";
    public static final int DATABASE_VERSION = 1;
    public static final String KEY_NAME = "name";
    public static final String KEY_MOBNO = "mobono";
    public static final String KEY_EMAIL = "email";

    Context ctx;

    public MyHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);

        ctx = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try
        {
            String sql = "create table "+TABLE_NAME+ " ("+KEY_MOBNO+" text primary key, "+KEY_NAME+" text, "+KEY_EMAIL+" text)";
            db.execSQL(sql);
            Toast.makeText(ctx,"Table Created",Toast.LENGTH_SHORT);

        }
        catch (Exception e)
        {
            Toast.makeText(ctx,"Error in Creating",Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try
        {
            String sql = "Drop table if exists "+TABLE_NAME;
            db.execSQL(sql);
            onCreate(db);
        }
        catch (Exception e)
        {
            Toast.makeText(ctx,"Error in Upgrade"+e.toString(),Toast.LENGTH_SHORT);
        }
    }

    public void addData(MyData d) {
    	 try
         {
         	SQLiteDatabase db=this.getWritableDatabase();
         	ContentValues values=new ContentValues();
         	values.put(KEY_MOBNO, d.getMobnum());
         	values.put(KEY_NAME, d.getName());
         	values.put(KEY_EMAIL, d.getEmail());
         	long lg =db.insert(TABLE_NAME, null,values);
         	if(lg>0)
         	Toast.makeText(ctx,"Records Inserted",Toast.LENGTH_LONG).show();
         	else
         		Toast.makeText(ctx, "Records does not exist",Toast.LENGTH_LONG).show();
         	db.close();
         }
         catch(Exception e)
         {
         	Toast.makeText(ctx,"Error in adding data"+e.toString(),Toast.LENGTH_LONG).show();
         }
    } 

	public List<MyData> displaydata() {
		List<MyData> lst=new ArrayList<MyData>();
		
		try
		{
			SQLiteDatabase db=this.getReadableDatabase();
			String sql="Select * from "+TABLE_NAME;
			Cursor cr=db.rawQuery(sql, null);
			
			if(cr.moveToFirst())
			{
				do
				{
					MyData d=new MyData();
					d.setMobnum(cr.getString(0));
					d.setName(cr.getString(1));
					d.setEmail(cr.getString(2));
					lst.add(d);
				}
				while(cr.moveToNext());
					
			}
			else
			{
				MyData d=new MyData("No ","Records ","found");
				lst.add(d);
			}
		}
		catch(Exception e)
		{
			MyData d=new MyData("Error","In","Display"+e.toString());
			lst.add(d);
		}
		return lst;
	}

	public void deleteData(String data) {
		try
		{
			SQLiteDatabase db=this.getWritableDatabase();
			long lg=db.delete(TABLE_NAME, KEY_MOBNO+"=?",new String[]{data});
			if(lg>0)
	         	Toast.makeText(ctx,"Records Deleted",Toast.LENGTH_LONG).show();
	         	else
	         		Toast.makeText(ctx, "Records not deleted",Toast.LENGTH_LONG).show();
			db.close();
		}
		catch(Exception e)
		{
	Toast.makeText(ctx,"Error In Deleting"+e.toString(),Toast.LENGTH_LONG).show();
		}
	}

	public void updatedata(String pno, String pname) {
		try
		{
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values=new ContentValues();
             values.put(KEY_NAME,pname);
			long lg=db.update(TABLE_NAME,values,KEY_MOBNO+"=?",new String[]{pno});
			if(lg>0)
	         	Toast.makeText(ctx,"Records Updated",Toast.LENGTH_LONG).show();
	         	else
	         		Toast.makeText(ctx, "Records  not updated",Toast.LENGTH_LONG).show();
			db.close();
	      
		}
		catch(Exception e)
		{
	Toast.makeText(ctx,"Error In Updating"+e.toString(),Toast.LENGTH_LONG).show();
		}
	}

	public MyData searchdata(String psearch) {
		MyData d=new MyData();
		try
		{
			SQLiteDatabase db=this.getReadableDatabase();
			String[] fields={KEY_MOBNO,KEY_NAME,KEY_EMAIL};
			String[] args={psearch};
			Cursor cr=db.query(TABLE_NAME,fields, KEY_MOBNO+"=?", args, null, null, null);
			if(cr.moveToFirst())
			{
				d.setMobnum(cr.getString(0));
				d.setName(cr.getString(1));
				d.setEmail(cr.getString(2));
			}
			else
			{
				d.setMobnum("Record");
				d.setName("Not");
				d.setEmail("Found");
			}
			db.close();
		}
		catch(Exception e)
		{
			d.setMobnum("Error");
			d.setName("In");
			d.setEmail("search");
		}
		return d;
	}
}
