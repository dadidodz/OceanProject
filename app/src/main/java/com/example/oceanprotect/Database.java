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
    public static final String COL_4 = "INFORMATION";
    public static final String COL_5 = "FAVORIS";
    public static final String COL_6 = "MEROCEAN";

    Context context;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, INFORMATION TEXT, FAVORIS INT, MEROCEAN BOOLEAN) ");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Peyriac', 'Pollution élevée', 'Le Anglet se trouve à 28m d''altitude La ville de Anglet bénéficie d'un climat tempéré chaud. Anglet est une ville avec des précipitations importantes. Même pendant le mois le plus sec il ya beaucoup de pluie. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. La température moyenne annuelle est de 14.3 °C °C à Anglet. Il tombe en moyenne 1278 mm de pluie par an.' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Bayonne', 'Pollution forte','Le Bayonne se trouve à 1m d'altitude La ville de Bayonne bénéficie d'un climat tempéré chaud. Les précipitations à Bayonne sont importantes. Même lors des mois les plus secs, les averses persistent encore. Selon la classification de Köppen-Geiger, le climat est de type Cfb. Sur l'année, la température moyenne à Bayonne est de 14.3 °C. Les précipitations annuelles moyennes sont de 1278 mm.', 0 ,'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('La Rochelle', 'Pollution normale', 'La Rochelle se trouve à 13m d'altitude Le climat y est chaud et tempéré. La Rochelle est une ville avec des précipitations importantes. Même pendant le mois le plus sec il ya beaucoup de pluie. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. La température moyenne annuelle à La Rochelle est de 13.3 °C. Sur l'année, la précipitation moyenne est de 798 mm.' ,0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Lorient', 'Pollution basse', 'Le Lorient se trouve à 18m d'altitude Le climat y est chaud et tempéré. Des précipitations importantes sont enregistrées toute l'année à Lorient, y compris lors des mois les plus secs. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. Lorient affiche 12.4 °C de température en moyenne sur toute l'année. Les précipitations annuelles moyennes sont de 864 mm.' ,1, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Biarritz', 'Pollution forte', 'Le Biarritz se trouve à 63m d'altitude Le climat de Biarritz est chaud et tempéré. Des précipitations importantes sont enregistrées toute l'année à Biarritz, y compris lors des mois les plus secs. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. La température moyenne annuelle est de 14.1 °C °C à Biarritz. Il tombe en moyenne 1278 mm de pluie par an.' , 0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Brest', 'Pollution normale', ' ' , 0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Anglet', 'Pollution basse', 'La ville de Anglet bénéficie d''un climat tempéré chaud. Anglet est une ville avec des précipitations importantes.\nLa température moyenne annuelle est de 14.3 °C. Il tombe en moyenne 1278 mm de pluie par an.' ,0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Saint-Nazaire', 'Pollution normale', '' ,1, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Vannes', 'Pollution basse', '' ,0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Rochefort', 'Pollution basse', '', 0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Lanester', 'Pollution normale', '' ,1, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Cassis', 'Pollution normale', '' ,1, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Honfleur', 'Pollution forte', '' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Villefranche-sur-mer', 'Pollution forte', '' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Bonifacio', 'Pollution normale', '' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Collioure', 'Pollution normale', '' ,1, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Camaret-sur-mer', 'Pollution normale', '' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Saint-Jean-de-Luz', 'Pollution normale', '' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Etretat', 'Pollution normale', '' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Saint-Malo', 'Pollution normale', '' ,0, 'true')");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor viewData(String query) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public void ajouterFavori(String nomlieu){
        SQLiteDatabase db = this.getWritableDatabase();
        String strSQL = "UPDATE ocean_table SET FAVORIS = 1 WHERE NAME='"+ nomlieu + "'";
        db.execSQL(strSQL);
    }

    public void supprimerFavori(String nomlieu){
        SQLiteDatabase db = this.getWritableDatabase();
        String strSQL = "UPDATE ocean_table SET FAVORIS = 0 WHERE NAME='"+ nomlieu + "'";
        db.execSQL(strSQL);
    }

    public int countFavori(){
        Cursor cursor = viewData("Select * from ocean_table where FAVORIS = 1 ORDER BY NAME ASC");
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

}
