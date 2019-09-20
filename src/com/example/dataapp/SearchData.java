package com.example.dataapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchData extends Activity {

    EditText jetSearch;
    Button jbtnSearchData;
    TextView tvShowData;
    String psearch;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchdata);

        jetSearch = (EditText)findViewById(R.id.etphonesearch);
        
        jbtnSearchData =(Button)findViewById(R.id.btnsearch);
        
        tvShowData = (TextView)findViewById(R.id.tvsearch);
        jbtnSearchData.setOnClickListener(new View.OnClickListener() {
		 @Override
            public void onClick(View view) {
                boolean flag = false;
                flag = getPhone();
                if(flag)
                {
                	MyHelper h=new MyHelper(getApplicationContext());
                	MyData d=h.searchdata(psearch);
                	String s="";
                	s=s+d.getMobnum()+""+d.getName()+""+d.getEmail();
                }
                
		 }
          
        });
        
    }
    

	private boolean getPhone() {
        boolean flag = false;
        try {
            String sPhone = jetSearch.getText().toString();
            if (sPhone.length() > 0 )
                flag = true;
            else
                Toast.makeText(SearchData.this,"Enter Vaild Number ",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(SearchData.this,"Enter Number",Toast.LENGTH_SHORT).show();
        }
        return flag;
    }

}
   
