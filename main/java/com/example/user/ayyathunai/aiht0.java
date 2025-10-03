package com.example.user.ayyathunai;


import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;

public class aiht0 extends Activity{

    Button b1,b2;
    Switch  s1;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aiht0);
        s1=findViewById(R.id.switch1);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent l=new Intent(aiht0.this,aiht1.class);
                startActivity(l);

            }

        });
        b2.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Log.i("clicks","You cancelled ");
                Intent m=new Intent(aiht0.this,aiht2.class);
                startActivity(m);
            }

        });

    }

    public void sendNotification(View view) {    NotificationCompat.Builder mBuilder =new NotificationCompat.Builder(this,"M_CH_ID");
        mBuilder.setSmallIcon(R.drawable.csy)
                .setContentTitle("MonthlyMark ")
                .setContentText("hasbeenupdated");


        // Gets an instance of the NotificationManager service//

        NotificationManager mNotificationManager =

                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);



        //NotificationManager.notify().

        if (mNotificationManager != null) {
            mNotificationManager.notify(1, mBuilder.build());
        }
    }
    }

