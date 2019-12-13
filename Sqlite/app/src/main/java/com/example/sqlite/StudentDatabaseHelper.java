package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDatabaseHelper extends SQLiteOpenHelper {
    //Variables
    public static String DATABASENAME="student.db";
    public static int DATABASEVERSION=1;
    public static String cerateTableQuery="CREATE TABLE student(id INTEGER PRIMARY KEY, name TEXT)";

    public StudentDatabaseHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cerateTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
