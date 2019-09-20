package com.example.dataapp;

public class MyData {
	private  String name, mobnum, email;
    public MyData()
    {
        name="";
        mobnum="";
        email="";
    }
    public MyData(String n, String m, String e){
        name = n;
        mobnum = m;
        email = e;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setMobnum(String m)
    {
        mobnum = m;
    }
    public String getMobnum()
    {
        return mobnum;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public String getEmail() {
        return email;
    }

}
