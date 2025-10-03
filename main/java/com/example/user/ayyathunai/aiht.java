package com.example.user.ayyathunai;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class aiht extends Activity{
    EditText e1,e2;
    Button b1,b2;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aiht);
        e1=findViewById(R.id.et2);
        e2=findViewById(R.id.et4);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                if(e1.getText().toString().equals("admin")&&
                        e2.getText().toString().equals("01"))
                {
                    // TODO Auto-generated method stub
                    Log.i("clicks","login ");
                    Intent l=new Intent(aiht.this,aiht0.class);
                    startActivity(l);
                }
            }

        });
        b2.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Log.i("clicks","You cancelled ");
                Intent m=new Intent(aiht.this,MainActivity.class);
                startActivity(m);
            }

        });

    }


}
