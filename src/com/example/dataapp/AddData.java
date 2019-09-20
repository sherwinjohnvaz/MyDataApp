package com.example.dataapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddData extends Activity {
	EditText jetphone, jetname, jetemail;
    Button jbtninsert;
    String mobno, name, email,sphone,sname,semail;
    int pno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddata);

        jetphone = (EditText)findViewById(R.id.etphone);
        jetname  = (EditText)findViewById(R.id.etname);
        jetemail = (EditText)findViewById(R.id.etemail);

        jbtninsert = (Button)findViewById(R.id.btninsert);

        jbtninsert.setOnClickListener(new View.OnClickListener() {
			
            @Override
            public void onClick(View view) {
                boolean flag = false;
                flag = getData();
                if(flag){
                    MyData d = new MyData(); 
                    //MyData d = new MyData(mobno, name, email);
                        d.setMobnum(sphone);
                        d.setName(sname);
                        d.setEmail(semail);
                    MyHelper h = new MyHelper(AddData.this);
                    h.addData(d);

                    jetemail.setText("");
                    jetname.setText("");
                    jetphone.setText("");
                }
               
            }
        });
    }

    private boolean getData() {
        boolean flag = false;
        flag = getPhone();
        if(flag)
            flag = getName();
            if(flag)
                flag = getEmail();

        return flag;
    }
    private boolean getPhone(){
        boolean flag = false;
        try
        {
             sphone = jetphone.getText().toString();
            if(sphone.length() > 0)
            {
            	pno=Integer.parseInt(sphone);
                flag = true;
            }
            else
                Toast.makeText(AddData.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
                
        }
        catch (Exception e) {
               Toast.makeText(AddData.this, "Only numbers allowed.Enter Phone Number again!", Toast.LENGTH_SHORT).show();
        }
    return flag;
    }

    private boolean getName() {
       boolean flag = false;
       try
       {
           sname = jetname.getText().toString();
           if(sname.length() > 0)
            flag = true;
       
           else
               Toast.makeText(AddData.this,"Enter Name",Toast.LENGTH_SHORT).show();
       }
       catch(Exception e){
    	   Toast.makeText(AddData.this,"Only Alphabets allowed!Enter name"+e.toString(),Toast.LENGTH_LONG).show();
       }
       return flag;
    }

    private boolean getEmail() {
        boolean flag = false;
        try
        {
              semail = jetemail.getText().toString();
            if(semail.length() > 0)
                flag = true;
            else
                Toast.makeText(AddData.this,"Enter email",Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
        	Toast.makeText(AddData.this,"Enter Email id!"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        return flag;

    }


}


