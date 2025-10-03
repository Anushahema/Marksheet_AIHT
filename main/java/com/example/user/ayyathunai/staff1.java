package com.example.user.ayyathunai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Notification;
import android.content.Intent;
import android.app.PendingIntent;

public class staff1 extends Activity{
    Button b1,b2,b3;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16;
    SQLiteDatabase db;  private static final int NOTIFY_ME_ID=1337;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff1);
        e1=findViewById(R.id.et2);
        e2=findViewById(R.id.et4);
        e3=findViewById(R.id.et);
        e4=findViewById(R.id.et3);
        e5=findViewById(R.id.editText5);
        e6=findViewById(R.id.editText6);
        e7=findViewById(R.id.editText7);
        e8=findViewById(R.id.editText8);
        e9=findViewById(R.id.editText9);
        e10=findViewById(R.id.editText10);
        e11=findViewById(R.id.editText11);
        e12=findViewById(R.id.editText12);
        e13=findViewById(R.id.editText13);
        e14=findViewById(R.id.editText14);
        e15=findViewById(R.id.editText15);
        e16=findViewById(R.id.editText16);

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);

        db=openOrCreateDatabase("studentdb",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(regno VARCHAR,name VARCHAR,dept VARCHAR,code1 VARCHAR,code2 VARCHAR,code3 VARCHAR,code4 VARCHAR,code5 VARCHAR,code6 VARCHAR," +
                "mark1 VARCHAR,mark2 VARCHAR,mark3 VARCHAR,mark4 VARCHAR,mark5 VARCHAR,mark6 VARCHAR,att VARCHAR);");


        b1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(e1.getText().toString().length()==0||
                        e2.getText().toString().length()==0||
                        e3.getText().toString().length()==0||
                        e4.getText().toString().length()==0||
                        e5.getText().toString().length()==0||
                        e6.getText().toString().length()==0||
                        e7.getText().toString().length()==0||
                        e8.getText().toString().length()==0||
                        e9.getText().toString().length()==0||
                        e10.getText().toString().length()==0||
                        e11.getText().toString().length()==0||
                        e12.getText().toString().length()==0||
                        e13.getText().toString().length()==0||
                        e14.getText().toString().length()==0||
                        e15.getText().toString().length()==0||
                        e16.getText().toString().length()==0)
                {
                    showMessage("error","please enter all values");
                    return;
                }
                db.execSQL("INSERT INTO student VALUES('"+e1.getText()+"','"+e2.getText()+"','"+e3.getText()+"','"+e4.getText()+"','"+e5.getText()+"','"+e6.getText()+"'," +
                        "'"+e7.getText()+"','"+e8.getText()+"','"+e9.getText()+"','"+e10.getText()+"','"+e11.getText()+"','"+e12.getText()+"','"+e13.getText()+"','"+e14.getText()+"','"+e15.getText()+"','"+e16.getText()+"')");
                showMessage("success","record inserted");
                clearText();
            }
        });
        b3.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(e1.getText().toString().length()==0)
                {
                    @SuppressLint("Recycle") Cursor c=db.rawQuery("SELECT * FROM student",null);
                    if(c.getCount()==0)
                    {
                        showMessage("error","No record found");
                        return;
                    }
                    StringBuilder buf=new StringBuilder();
                    while(c.moveToNext())
                    {
                        buf.append("regno.").append(c.getString(0)).append("\n");
                        buf.append("name.").append(c.getString(1)).append("\n");
                        buf.append("dept").append(c.getString(2)).append("\n");
                        buf.append("code").append(c.getString(3)).append("\t").append(c.getString(4)).append("\t").append(c.getString(5)).append("\t").append(c.getString(6)).append("\t").append(c.getString(7)).append("\t").append(c.getString(8)).append("\n");
                        buf.append("mark").append(c.getString(9)).append("\t").append(c.getString(10)).append("\t").append(c.getString(11)).append("\t").append(c.getString(12)).append("\t").append(c.getString(13)).append("\t").append(c.getString(14)).append("\n");
                        buf.append("att").append(c.getString(15)).append("\t");

                    }
                    showMessage("Student detail",buf.toString());
                }
                else
                {
                    @SuppressLint("Recycle") Cursor c=db.rawQuery("SELECT * FROM student WHERE regno='"+e1.getText()+"'",null);
                    if(c.moveToFirst())
                    {
                        e1.setText(c.getString(0));
                        e2.setText(c.getString(1));
                        e3.setText(c.getString(2));
                        e4.setText(c.getString(3));
                        e10.setText(c.getString(4));
                        e5.setText(c.getString(5));
                        e11.setText(c.getString(6));
                        e6.setText(c.getString(7));
                        e12.setText(c.getString(8));
                        e7.setText(c.getString(9));
                        e13.setText(c.getString(10));
                        e8.setText(c.getString(11));
                        e14.setText(c.getString(12));
                        e9.setText(c.getString(13));
                        e15.setText(c.getString(14));
                        e16.setText(c.getString(15));
                    }
                }

            }
        });
        b2.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(e1.getText().toString().length()==0)
                {
                    showMessage("error","please enter regno.");
                    return;
                }
                @SuppressLint("Recycle") Cursor c=db.rawQuery("SELECT * FROM student WHERE regno='"+e1.getText()+"'",null);
                if(c.moveToFirst())
                {
                    db.execSQL("UPDATE student SET name='"+e2.getText()+"',dept='"+e3.getText()+"',code1='"+e4.getText()+"',code2='"+e5.getText()+"',code3='"+e6.getText()+
                            "',code4='"+e7.getText()+"',code5='"+e8.getText()+"',code6='"+e9.getText()+"',mark1='"+e10.getText()+"',mark2='"+e11.getText()+"',mark3='"+e12.getText()+"'" +
                            ",mark4='"+e13.getText()+"',mark5='"+e14.getText()+"',mark6='"+e15.getText()+"',att='"+e16.getText()+"'WHERE regno='"+e1.getText()+"'");
                    showMessage("error","modified");
                }
            }

        });


    }
    protected void clearText() {
        // TODO Auto-generated method stub
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
        e7.setText("");
        e8.setText("");
        e9.setText("");
        e10.setText("");
        e11.setText("");
        e12.setText("");
        e13.setText("");
        e14.setText("");
        e15.setText("");
        e16.setText("");

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
