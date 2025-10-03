package com.example.user.ayyathunai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;


public class aiht1 extends Activity{
    Button b1,b2,b3,b4;
    EditText e1,e2,e3,e4;
    static SQLiteDatabase staff1;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aiht1);
        e1=findViewById(R.id.et);
        e2=findViewById(R.id.et2);
        e3=findViewById(R.id.et3);
        e4=findViewById(R.id.et4);


        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button5);

        staff1=openOrCreateDatabase("staffdb",Context.MODE_PRIVATE,null);
        staff1.execSQL("CREATE TABLE IF NOT EXISTS staff(name VARCHAR,loginid VARCHAR,dept VARCHAR,password VARCHAR);");


        b1.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub
                if(e1.getText().toString().length()==0||
                        e2.getText().toString().length()==0||
                        e3.getText().toString().length()==0||
                        e4.getText().toString().length()==0)
                {
                    showMessage("error","please enter all values");
                    return;
                }
                staff1.execSQL("INSERT INTO staff VALUES('"+e1.getText()+"','"+e2.getText()+"','"+e3.getText()+"','"+e4.getText()+"')");
                showMessage("success","record inserted");
                clearText();
            }
        });
        b4.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(e1.getText().toString().length()==0)
                {
                    @SuppressLint("Recycle") Cursor c=staff1.rawQuery("SELECT * FROM staff",null);
                    if(c.getCount()==0)
                    {
                        showMessage("error","No record found");
                        return;
                    }
                    StringBuilder buf=new StringBuilder();
                    while(c.moveToNext())
                    {
                        buf.append("name.").append(c.getString(0)).append("\n");
                        buf.append("loginid.").append(c.getString(1)).append("\n");
                        buf.append("dept").append(c.getString(2)).append("\n");
                        buf.append("password.").append(c.getString(3)).append("\n");

                    }
                    showMessage("Staff detail",buf.toString());
                }
                else
                {
                    @SuppressLint("Recycle") Cursor c=staff1.rawQuery("SELECT * FROM staff WHERE name='"+e1.getText()+"'",null);
                    if(c.moveToFirst())
                    {
                        e1.setText(c.getString(0));
                        e2.setText(c.getString(1));
                        e3.setText(c.getString(2));
                        e4.setText(c.getString(3));

                    }
                }

            }
        });
        b3.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(e1.getText().toString().length()==0)
                {
                    showMessage("error","please enter name.");
                    return;
                }
                @SuppressLint("Recycle") Cursor c=staff1.rawQuery("SELECT * FROM staff WHERE name='"+e1.getText()+"'",null);
                if(c.moveToFirst())
                {
                    staff1.execSQL("UPDATE staff SET loginid='"+e2.getText()+"',dept='"+e3.getText()+"',password='"+e4.getText()+"'");
                    showMessage("Success","modified");
                }
            }

        });
        b2.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(e1.getText().toString().length()==0)
                {
                    showMessage("error","please enter name.");
                    return;
                }
                @SuppressLint("Recycle") Cursor c=staff1.rawQuery("SELECT * FROM staff WHERE name='"+e1.getText()+"'",null);
                if(c.moveToFirst())
                {
                    staff1.execSQL("");
                    showMessage("sucess","Deleted");
                }

            }});


    }
    protected void clearText() {
        // TODO Auto-generated method stub
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");

    }
    protected void showMessage(String title, String msg) {
        // TODO Auto-generated method stub
        Builder br=new Builder(this);
        br.setCancelable(true);
        br.setTitle(title);
        br.setMessage(msg);
        br.show();
    }
}
