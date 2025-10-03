package com.example.user.ayyathunai;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class staff extends Activity{
    EditText e1,e2;
    Button b1,b2;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff);
        e1=findViewById(R.id.et);
        e2=findViewById(R.id.et3);
        b1=findViewById(R.id.button5);
        b2=findViewById(R.id.button6);
        b1.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(e1.getText().toString().equals("anusha")&&
                        e2.getText().toString().equals("anu"))
                {
                    // TODO Auto-generated method stub
                    Log.i("clicks","login ");
                    Intent l=new Intent(staff.this,staff1.class);
                    startActivity(l);
                }
            }});
        b2.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Log.i("clicks","cancel ");
                Intent o=new Intent(staff.this,MainActivity.class);
                startActivity(o);
            }

        });

    }
    protected void showMessage(String title, String msg) {
        // TODO Auto-generated method stub
        AlertDialog.Builder br = new AlertDialog.Builder(this);
        br.setCancelable(true);
        br.setTitle(title);
        br.setMessage(msg);
        br.show();
    }
}
