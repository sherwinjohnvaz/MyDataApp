package com.example.dataapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends Activity{
	   EditText jetPhoneDel;
	    Button jbtnDeleteData;
 String sPhone,data;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.deletedata);

	        jetPhoneDel = (EditText) findViewById(R.id.etphonedel);

	        jbtnDeleteData = (Button)findViewById(R.id.btndel);

	        jbtnDeleteData.setOnClickListener(new View.OnClickListener() {
			 @Override
	            public void onClick(View view) {
	               
	                boolean flag=getdata();
	                if(flag)
	                {
	                MyHelper h=new MyHelper(getApplicationContext());
	                h.deleteData(data);
	                }
	            }

			private boolean getdata() {
				 boolean flag = false;
			        flag = getPhone();
			       
			        return flag;
			}
	        });


	}

	    private boolean getPhone() {
	        boolean flag = false;
	        try
	        {
	           sPhone = jetPhoneDel.getText().toString();
	            if(sPhone.length() > 0)
	                flag = true;
	            else
	                Toast.makeText(DeleteData.this,"Enter Phone Number",Toast.LENGTH_SHORT);
	        }
	        catch (Exception e){
	            Toast.makeText(DeleteData.this,"Enter Phone Number",Toast.LENGTH_SHORT);
	        }

	        return flag;

	    }
	    }


