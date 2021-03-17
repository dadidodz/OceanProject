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

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Peyriac-Minervois', 'Pollution élevée', 'Le Peyriac-Minervois se trouve à 135m d''altitude. Le climat de Peyriac-Minervois est dit tempéré chaud. Les précipitations en Peyriac-Minervois sont significatives, avec des précipitations même pendant le mois le plus sec. Cet emplacement est classé comme Cfa par Köppen et Geiger. La température moyenne annuelle à Peyriac-Minervois est de 13.3 °C. Sur l''année, la précipitation moyenne est de 802 mm.' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Bayonne', 'Pollution élevée','Le Bayonne se trouve à 1m d''altitude. La ville de Bayonne bénéficie d''un climat tempéré chaud. Les précipitations à Bayonne sont importantes. Même lors des mois les plus secs, les averses persistent encore. Selon la classification de Köppen-Geiger, le climat est de type Cfb. Sur l''année, la température moyenne à Bayonne est de 14.3 °C. Les précipitations annuelles moyennes sont de 1278 mm.', 0 ,'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('La Rochelle', 'Pollution normale', 'La Rochelle se trouve à 13m d''altitude. Le climat y est chaud et tempéré. La Rochelle est une ville avec des précipitations importantes. Même pendant le mois le plus sec il ya beaucoup de pluie. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. La température moyenne annuelle à La Rochelle est de 13.3 °C. Sur l''année, la précipitation moyenne est de 798 mm.' ,0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Lorient', 'Pollution basse', 'Le Lorient se trouve à 18m d''altitude. Le climat y est chaud et tempéré. Des précipitations importantes sont enregistrées toute l''année à Lorient, y compris lors des mois les plus secs. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. Lorient affiche 12.4 °C de température en moyenne sur toute l''année. Les précipitations annuelles moyennes sont de 864 mm.' ,1, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Biarritz', 'Pollution élevée', 'Le Biarritz se trouve à 63m d''altitude. Le climat de Biarritz est chaud et tempéré. Des précipitations importantes sont enregistrées toute l''année à Biarritz, y compris lors des mois les plus secs. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. La température moyenne annuelle est de 14.1 °C à Biarritz. Il tombe en moyenne 1278 mm de pluie par an.' , 0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Brest', 'Pollution normale', 'Le Brest se trouve à 45m d''altitude. Un climat tempéré chaud est présent à Brest. Les précipitations à Brest sont importantes. Même lors des mois les plus secs, les averses persistent encore. Cet emplacement est classé comme Cfb par Köppen et Geiger. En moyenne la température à Brest est de 12.1 °C. La moyenne des précipitations annuelles atteints 941 mm.' , 0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Anglet', 'Pollution basse', 'Le Anglet se trouve à 28m d''altitude. La ville de Anglet bénéficie d''un climat tempéré chaud. Anglet est une ville avec des précipitations importantes. Même pendant le mois le plus sec il ya beaucoup de pluie. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. La température moyenne annuelle est de 14.3 °C à Anglet. Il tombe en moyenne 1278 mm de pluie par an.' ,0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Saint-Nazaire', 'Pollution normale', 'Le Saint-Nazaire se trouve à 13m d''altitude. Le climat y est chaud et tempéré. Des précipitations importantes sont enregistrées toute l''année à Saint-Nazaire, y compris lors des mois les plus secs. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. La température moyenne annuelle à Saint-Nazaire est de 12.8 °C. Les précipitations annuelles moyennes sont de 743 mm.' ,1, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Vannes', 'Pollution basse', 'Le Vannes se trouve à 17m d''altitude. Un climat tempéré chaud est présent à Vannes. Les précipitations en Vannes sont significatives, avec des précipitations même pendant le mois le plus sec. D''après Köppen et Geiger, le climat y est classé Cfb. Vannes affiche 12.3 °C de température en moyenne sur toute l''année. Les précipitations annuelles moyennes sont de 767 mm.' ,0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Rochefort', 'Pollution basse', 'Le Rochefort se trouve à 12m d''altitude. Le climat y est chaud et tempéré. Les précipitations à Rochefort sont importantes. Même lors des mois les plus secs, les averses persistent encore. D''après Köppen et Geiger, le climat y est classé Cfb. Rochefort affiche 13.5 °C de température en moyenne sur toute l''année. Chaque année, les précipitations sont en moyenne de 768 mm', 0, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Lanester', 'Pollution normale', 'Le Lanester se trouve à 7m d''altitude. Un climat tempéré chaud est présent à Lanester. Les précipitations en Lanester sont significatives, avec des précipitations même pendant le mois le plus sec. D''après Köppen et Geiger, le climat y est classé Cfb. Lanester affiche 12.3 °C de température en moyenne sur toute l''année. Les précipitations annuelles moyennes sont de 891 mm.' ,1, 'false')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Cassis', 'Pollution normale', 'Le Cassis se trouve à 28m d''altitude. Le climat de Cassis est dit tempéré chaud. L''hiver à Cassis se caractérise par des précipitations bien plus importantes qu''en été. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Csa. Sur l''année, la température moyenne à Cassis est de 14.6 °C. La moyenne des précipitations annuelles atteints 663 mm.' ,1, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Honfleur', 'Pollution élevée', 'Le Honfleur se trouve à 5m d''altitude. Le climat y est chaud et tempéré. De fortes averses s''abattent toute l''année sur Honfleur. Même lors des mois les plus secs, les précipitations restent assez importantes. Cet emplacement est classé comme Cfb par Köppen et Geiger. En moyenne la température à Honfleur est de 11.4 °C. La moyenne des précipitations annuelles atteints 994 mm.' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Villefranche-sur-mer', 'Pollution élevée', 'Le Villefranche-sur-Mer se trouve à 53m d''altitude Le climat de Villefranche-sur-Mer est chaud et tempéré. L''été, à Villefranche-sur-Mer, les pluies sont moins importantes qu''elles ne le sont en hiver. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Csb. La température moyenne annuelle à Villefranche-sur-Mer est de 12.9 °C. Chaque année, les précipitations sont en moyenne de 894 mm' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Bonifacio', 'Pollution normale', 'Le Bonifacio se trouve à 63m d''altitude. Un climat tempéré chaud est présent à Bonifacio. La pluie dans Bonifacio tombe surtout en hiver, avec relativement peu de pluie en été. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Csa. Bonifacio affiche 16.7 °C de température en moyenne sur toute l''année. Les précipitations annuelles moyennes sont de 549 mm.' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Collioure', 'Pollution normale', 'Le Collioure se trouve à 1m d''altitude. Le climat y est chaud et tempéré. En hiver, les pluies sont bien plus importantes à Collioure qu''elles ne le sont en été. Selon la classification de Köppen-Geiger, le climat est de type Csa. La température moyenne annuelle à Collioure est de 14.5 °C. Chaque année, les précipitations sont en moyenne de 642 mm' ,1, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Camaret-sur-mer', 'Pollution normale', 'Le Camaret-sur-Mer se trouve à 4m d''altitude. Le climat y est chaud et tempéré. Les précipitations en Camaret-sur-Mer sont significatives, avec des précipitations même pendant le mois le plus sec. La classification de Köppen-Geiger est de type Cfb. En moyenne la température à Camaret-sur-Mer est de 12.2 °C. Il tombe en moyenne 1208 mm de pluie par an.' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Saint-Jean-de-Luz', 'Pollution normale', 'Le Saint-Jean-de-Luz se trouve à 5m d''altitude. Le climat de Saint-Jean-de-Luz est dit tempéré chaud. Saint-Jean-de-Luz est une ville avec des précipitations importantes. Même pendant le mois le plus sec il ya beaucoup de pluie. Cet emplacement est classé comme Cfb par Köppen et Geiger. La température moyenne annuelle est de 13.2 °C à Saint-Jean-de-Luz. La moyenne des précipitations annuelles atteints 1404 mm.' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Etretat', 'Pollution normale', 'Le Étretat se trouve à 8m d''altitude. La ville de Étretat bénéficie d''un climat tempéré chaud. Les précipitations à Étretat sont importantes. Même lors des mois les plus secs, les averses persistent encore. La carte climatique de Köppen-Geiger y classe le climat comme étant de type Cfb. En moyenne la température à Étretat est de 11.4 °C. Les précipitations annuelles moyennes sont de 1110 mm.' ,0, 'true')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(NAME, DESCRIPTION, INFORMATION , FAVORIS, MEROCEAN ) VALUES ('Saint-Malo', 'Pollution normale', 'Le Saint-Malo se trouve à 6m d''altitude. Un climat tempéré chaud est présent à Saint-Malo. De fortes averses s''abattent toute l''année sur Saint-Malo. Même lors des mois les plus secs, les précipitations restent assez importantes. Selon la classification de Köppen-Geiger, le climat est de type Cfb. Saint-Malo affiche une température annuelle moyenne de 12.1 °C. Il tombe en moyenne 984 mm de pluie par an.' ,0, 'true')");

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
