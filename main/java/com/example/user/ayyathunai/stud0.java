package com.example.user.ayyathunai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class stud0 extends Activity {
    Button b1,b2;
    SQLiteDatabase db;
    EditText e1;
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stud0);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        e1=findViewById(R.id.et1);
        db=openOrCreateDatabase("studentdb",Context.MODE_PRIVATE,null);
        b1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(e1.getText().toString().length()==0)
                {
                    showMessage("error","please enter regno.");

                }
                else
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

                    }
                    showMessage("Student detail",buf.toString());
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
                }
                else
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
                        buf.append("code").append(c.getString(3)).append("\t").append(c.getString(4)).append("\t").append(c.getString(5)).append("\t").append(c.getString(6)).append("\t").append(c.getString(7)).append("\t").append(c.getString(8)).append("\n");
                        buf.append("mark").append(c.getString(9)).append("\t").append(c.getString(10)).append("\t").append(c.getString(11)).append("\t").append(c.getString(12)).append("\t").append(c.getString(13)).append("\t").append(c.getString(14)).append("\n");
                        buf.append("att").append(c.getString(15)).append("\t");

                    }
                    showMessage("Student detail",buf.toString());
                }

            }
        });
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
