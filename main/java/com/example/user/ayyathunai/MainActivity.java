package com.example.user.ayyathunai;

import android.view.View;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);



            b1=findViewById(R.id.button2);
            b2=findViewById(R.id.button1);
            b3=findViewById(R.id.button3);
            b4=findViewById(R.id.button);
            b1.setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    Log.i("clicks","student login");
                    Intent i=new Intent(MainActivity.this,student.class);
                    startActivity(i);

                }
            });
            b2.setOnClickListener(new OnClickListener(){
                public void onClick(View arg1) {
                    // TODO Auto-generated method stub
                    Log.i("clicks","staff login");
                    Intent K=new Intent(MainActivity.this,staff.class);
                    startActivity(K);
                }
            });

            b3.setOnClickListener(new OnClickListener(){
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.i("clicks","aiht login");
                    Intent x=new Intent(MainActivity.this,aiht.class);
                    startActivity(x);
                }
            });
            b4.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Log.i("clicks","student login");
                Intent i=new Intent(MainActivity.this,rate.class);
                startActivity(i);

                }
        });
        }



}
