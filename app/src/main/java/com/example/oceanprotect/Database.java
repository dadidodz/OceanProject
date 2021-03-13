package com.example.oceanprotect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Ocean.db";
    public static final String TABLE_NAME = "ocean_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "INFORMATION";
    private SQLiteOpenHelper DBHelper;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, INFORMATION TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }


    private static final String SQL_CATEGORY_NAME =
            "SELECT " + COL_2 + "FROM " + TABLE_NAME;

    public String getCategoryName(int i)
    {
        Cursor cursor = null;
        try {
            SQLiteDatabase database = DBHelper.getWritableDatabase();
            cursor = database.rawQuery(SQL_CATEGORY_NAME , new String[] { Integer.toString(i) } );
            return (cursor.moveToFirst()) ? cursor.getString(0) : null;
        } finally {
            if (cursor != null) cursor.close();
        }
    }
}
