package com.example.user.ayyathunai;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;


public class aiht2 extends Activity {
    Button b1, b2, b3, b4;
    EditText e1, e2, e3, e4;
    static SQLiteDatabase stud1;
    private DataBaseHelper dbHelper;
    static final String DATABASE_NAME = "studentdb";
    static final int DATABASE_VERSION = 1;
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aiht2);
        e1 = findViewById(R.id.et2);
        e2 = findViewById(R.id.et4);
        e3 = findViewById(R.id.et);
        e4 = findViewById(R.id.et3);


        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);


            stud1 = openOrCreateDatabase("studentdb", Context.MODE_PRIVATE, null);
            stud1.execSQL("CREATE TABLE IF NOT EXISTS stud(name VARCHAR,dept VARCHAR,regno VARCHAR,dob VARCHAR);");


            b1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if (e1.getText().toString().length() == 0 ||
                            e2.getText().toString().length() == 0 ||
                            e3.getText().toString().length() == 0 ||
                            e4.getText().toString().length() == 0) {
                        showMessage("error", "please enter all values");
                        return;
                    }
                    stud1.execSQL("INSERT INTO stud VALUES('" + e1.getText() + "','" + e2.getText() + "','" + e3.getText() + "','" + e4.getText() + "')");
                    showMessage("success", "record inserted");
                    clearText();
                }
            });
            b4.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if (e1.getText().toString().length() == 0) {
                        @SuppressLint("Recycle") Cursor c = stud1.rawQuery("SELECT * FROM stud", null);
                        if (c.getCount() == 0) {
                            showMessage("error", "No record found");
                            return;
                        }
                        StringBuilder buf = new StringBuilder();
                        while (c.moveToNext()) {
                            buf.append("name").append(c.getString(0)).append("\n");
                            buf.append("dept.").append(c.getString(1)).append("\n");
                            buf.append("regno.").append(c.getString(2)).append("\n");
                            buf.append("dob.").append(c.getString(3)).append("\n");

                        }
                        showMessage("Student detail", buf.toString());
                    } else {
                        @SuppressLint("Recycle") Cursor c = stud1.rawQuery("SELECT * FROM stud WHERE regno='" + e3.getText() + "'", null);
                        if (c.moveToFirst()) {
                            e1.setText(c.getString(0));
                            e2.setText(c.getString(1));
                            e3.setText(c.getString(2));
                            e4.setText(c.getString(3));

                        }
                    }

                }
            });
            b3.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if (e1.getText().toString().length() == 0) {
                        showMessage("error", "please enter regno");
                        return;
                    }
                    @SuppressLint("Recycle") Cursor c = stud1.rawQuery("SELECT * FROM stud WHERE regno='" + e3.getText() + "'", null);
                    if (c.moveToFirst()) {
                        stud1.execSQL("UPDATE stud SET dept='" + e2.getText() + "',name='" + e1.getText() + "',dob='" + e4.getText() + "'WHERE regno='" + e3.getText() + "'");
                        showMessage("error", "modified");
                    }
                }

            });

            b2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if (e1.getText().toString().length() == 0) {
                        showMessage("error", "please enter name.");
                        return;
                    }
                    @SuppressLint("Recycle") Cursor c = stud1.rawQuery("SELECT * FROM stud WHERE regno='" + e3.getText() + "'", null);
                    if (c.moveToFirst()) {
                        stud1.execSQL("");
                        showMessage("error", "Deleted");
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


    }

    protected void showMessage(String title, String msg) {
        // TODO Auto-generated method stub
        Builder br = new Builder(this);
        br.setCancelable(true);
        br.setTitle(title);
        br.setMessage(msg);
        br.show();
    }

   /* public aiht2(Context _context) {
        dbHelper = new DataBaseHelper(_context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    public aiht2 open() throws SQLException {
        stud1 = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        stud1.close();
    }

    //public SQLiteDatabase getDatabaseInstance() {
    //  return stud1;
    //}
*/
    public static String getSinlgeEntry(String regno) {
        @SuppressLint("Recycle") Cursor cursor = stud1.rawQuery("SELECT * FROM stud WHERE regno='" +regno + "'", null);
       // Cursor cursor = stud1.query("LOGIN", null, " REGNO=?",new String[]{regno}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        //String dob = cursor.getString(cursor.getColumnIndex("DOB"));
        String dob = cursor.getString(3);
        cursor.close();
        return dob;
    }
}


