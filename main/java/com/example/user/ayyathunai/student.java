package com.example.user.ayyathunai;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class student extends Activity {
    EditText e1, e2;
    Button b1, b2;
    //aiht2 a2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
        e1 = findViewById(R.id.et4);
        e2 =findViewById(R.id.et1);
        b1 =findViewById(R.id.button3);
        b2 =findViewById(R.id.button4);
       // a2 = new aiht2(this);
        //a2 = a2.open();
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String regno = e1.getText().toString();
                String dob = e2.getText().toString();
                String storedPassword = aiht2.getSinlgeEntry(regno);
                if (dob.equals(storedPassword)) {
                    Toast.makeText(student.this,"Congrats: Login Successfully", Toast.LENGTH_LONG).show();
                    showMessage("click", "login");
                    Log.i("clicks", "login ");
                    Intent l = new Intent(student.this, stud0.class);
                    startActivity(l);
                } else {
                    showMessage("error", "enter login and password");//a2.close();
                                    }
            }

        });
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Log.i("clicks", "You cancelled ");
                showMessage("click", "login cancelled");
                Intent m = new Intent(student.this, MainActivity.class);
                startActivity(m);
            }

        });
        //a2.close();
    }

    protected void showMessage(String title, String msg) {
        // TODO Auto-generated method stub
        Builder br = new Builder(this);
        br.setCancelable(true);
        br.setTitle(title);
        br.setMessage(msg);
        br.show();
    }
}
