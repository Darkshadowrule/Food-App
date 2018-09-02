package com.example.prajjwal.myapplication.Database;

public class DbHelper {

    public static final String COLUMN_EMAIL_ID = "email_id";

    public static final String COLUMN_PASSWORD = "password";

    public  static final String TABLE_NAME="signup";

    public static final  String COLUMN_ID="id";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_EMAIL_ID + " TEXT UNIQUE NOT NULL,"
                    + COLUMN_PASSWORD + " VARCHAR NOT NULL "
                    + ")";

}
