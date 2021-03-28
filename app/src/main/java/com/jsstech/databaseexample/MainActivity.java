package com.jsstech.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText user,password;
private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.userName);
        password=findViewById(R.id.pass);



    }

    public void sendData(View view) {


        String u=user.getText().toString().trim();
        String p=password.getText().toString().trim();

        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase sqLiteDatabase= dbHelper.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("username",u);
        contentValues.put("password",p);

        long rowid=sqLiteDatabase.insert("user_login",null,contentValues);

        Log.e("Row ID","sendData:-.... " + rowid);
        Toast.makeText(this,"data inserted sucessfully"+ u +" "+ p,Toast.LENGTH_LONG).show();
    }
}