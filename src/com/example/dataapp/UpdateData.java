package com.example.dataapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends Activity {
    EditText jetPhone, jetEditName;
    Button jbtnUpdate;
    String sPhone,sName,pno,pname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatedata);

        jetPhone = (EditText)findViewById(R.id.etupdatephone);
        jetEditName = (EditText)findViewById(R.id.etupdatename);

        jbtnUpdate = (Button)findViewById(R.id.btnupdate);

        jbtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = false;
                flag = getData();
               if(flag)
               {
            	   MyHelper h=new MyHelper(getApplicationContext());
            	   h.updatedata(pno,pname);
               }
            }
        });

    }

    private boolean getData() {
        boolean flag = false;
        flag = getPhone();
        if(flag)
            flag = getName();
      return flag;
    }
    private boolean getPhone() {
        boolean flag = false;
        try{
           sPhone = jetPhone.getText().toString();
            if(sPhone.length() > 0)
                flag = true;
            else
                Toast.makeText(UpdateData.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(UpdateData.this,"Only Number allowed! Enter Phone Number agan!"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        return flag;
    }
    private boolean getName(){
    	  boolean flag = false;
          try
          {
              sName = jetEditName.getText().toString();
              if(sName.length() > 0)
               flag = true;
          
              else
                  Toast.makeText(UpdateData.this,"Enter Name",Toast.LENGTH_SHORT).show();
          }
          catch(Exception e){
       	   Toast.makeText(UpdateData.this,"Only Alphabets allowed!Enter name"+e.toString(),Toast.LENGTH_LONG).show();
          }
          return flag;
       }
    }

