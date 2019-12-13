package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentDatabaseHelper studentDatabaseHelper=new StudentDatabaseHelper(this.getApplicationContext());
        SQLiteDatabase db = studentDatabaseHelper.getWritableDatabase();

        //Insertion

        ContentValues contentValues=new ContentValues();
        contentValues.put("1", "Ismael");
        contentValues.put("2", "Nicole");
        long newItem = db.insert("student", null, contentValues);

        //Retrouver des donnees

        Cursor cur;
        String[] idArray={"id"};
        cur=db.query("student",  idArray, String.valueOf(new String[]{"name='Ismael'"}), null, null, null, null);
        cur.moveToFirst();
        while (!cur.isAfterLast()){
            Log.i("AndroidSqliteDemo",
            cur.getString(0));
        }
        cur.close();
    }
}
