package com.example.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR , age INT(3))");

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");

            //myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Jawad', 26)");

            //myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rob', 34)");

            //myDatabase.execSQL("DELETE FROM users WHERE name = 'Rob' LIMIT 1");

            //myDatabase.execSQL("UPDATE users SET age = 25 WHERE name = 'Jawad'");

            //myDatabase.execSQL("DELETE FROM users WHERE name='Jawad'");


            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();
            while (c != null){
                System.out.println("Names " + c.getString(nameIndex));
                System.out.println("Age " + Integer.toString(c.getInt(ageIndex)));
                System.out.println("ID " + Integer.toString(c.getInt(idIndex)));
                c.moveToNext();
            }
        }catch (Exception e){

        }
    }
}
