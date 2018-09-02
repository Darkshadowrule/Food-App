package com.example.prajjwal.myapplication.Database;

import android.content.ComponentCallbacks;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseCreation extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "loginsignup";

    public DatabaseCreation(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public SQLiteDatabase db;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(DbHelper.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

        db.execSQL("DROP TABLE IF EXISTS " + DbHelper.TABLE_NAME);

        onCreate(db);
    }

    public boolean insertData(String email, String password) {
         db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.COLUMN_EMAIL_ID, email);
        contentValues.put(DbHelper.COLUMN_PASSWORD, password);
        long result = db.insert(DbHelper.TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else
            return true;
    }

    public  String getSinlgeEntry(String userName)
    { db = this.getWritableDatabase();
        Cursor cursor=db.query("signup", null, "email_id=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            db.close();
            return "Not Exist";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        db.close();
        return password;
    }
/*
    public Cursor getRecords()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.get(DbHelper.COLUMN_EMAIL_ID);
        contentValues.get(DbHelper.COLUMN_PASSWORD);
        = db.rawQuery("SELECT * FROM "+DbHelper.TABLE_NAME,null);
        return res;
    }*/
}
