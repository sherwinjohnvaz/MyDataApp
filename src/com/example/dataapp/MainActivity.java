package com.example.dataapp;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button jbtnadd, jbtndelete, jbtnsearch, jbtnupdate, jbtndisplay, jbtnexit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jbtnadd = (Button)findViewById(R.id.btnadd);
        jbtndelete = (Button)findViewById(R.id.btndel);
        jbtnupdate = (Button)findViewById(R.id.btnupdate);
        jbtnsearch = (Button)findViewById(R.id.btnsearch);
        jbtndisplay = (Button)findViewById(R.id.btndisplay);
        jbtnexit = (Button)findViewById(R.id.btnexit);
        
        jbtnadd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
		   Intent intent = new Intent(MainActivity.this, AddData.class);
	        startActivity(intent);	
			
			}
		});
        jbtndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeleteData.class);
                startActivity(intent);
                

            }
        });

        jbtnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UpdateData.class);
                startActivity(intent);
            }
        });

        jbtnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SearchData.class);
                startActivity(intent);
            }
        });
        
        jbtndisplay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				try
				{
					MyHelper h=new MyHelper(MainActivity.this);
					List<MyData> ml=h.displaydata();
					String s="";
					for(MyData d:ml)
					{
						s=s+d.getMobnum()+" "+d.getName()+" "+d.getEmail()+"\n";
					}
					Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
				}
				catch(Exception e)
				{
					Toast.makeText(MainActivity.this,"No data to display"+e.toString(),Toast.LENGTH_LONG).show();
				}
				
			}
		});
    }

    
}
