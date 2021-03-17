package com.example.oceanprotect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Ocean.db";
    public static final String TABLE_NAME = "ocean_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "FAVORIS";
    public static final String COL_5 = "MEROCEAN";

    private SQLiteOpenHelper DBHelper;
    Context context;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, FAVORIS BOOLEAN, MEROCEAN BOOLEAN) ");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Peyriac', 'Pollution extrême','true', 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Bayonne', 'Pollution forte','true', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('La Rochelle', 'Pollution normale','false', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Lorient', 'Pollution basse','true', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Biarritz', 'Pollution forte','false', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Brest', 'Pollution normale','false', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Anglet', 'Pollution basse','false', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Saint-Nazaire', 'Pollution normale','false', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Vannes', 'Pollution basse','false', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Rochefort', 'Pollution basse','false', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Lanester', 'Pollution normale','false', 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Cassis', 'Pollution normale','false', 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Honfleur', 'Pollution forte','false', 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Villefranche-sur-mer', 'Pollution forte','true', 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Bonifacio', 'Pollution normale','false', 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Collioure', 'Pollution normale','true', 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Camaret-sur-mer', 'Pollution normale','false', 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Saint-Jean-de-Luz', 'Pollution normale','false', 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Etretat', 'Pollution normale','true', 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, FAVORIS, MEROCEAN ) VALUES ('Saint-Malo', 'Pollution normale','true', 'true')");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        /*ContentValues values = new ContentValues();
        values.put(COL_1, "3");
        values.put(COL_2, "Peyriac");
        values.put(COL_3, "Pollution extrême");
        values.put(COL_4, "true");
        values.put(COL_5, "true");
        long newRowId = db.insert(TABLE_NAME, null, values);

         */
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    public Cursor viewData(String query) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }




}
