package com.example.oceanprotect;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InfosPollution extends AppCompatActivity  {

    private Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infospollution_layout);

        this.db = new Database(this);

        // Recupere le parametre de l'intent via la cle utilisee
        String nomlieu = getIntent().getStringExtra("nomlieu");

        // modifie le texte du label de l'activite avec cette valeur
        TextView nomville = (TextView)findViewById(R.id.nomlieu);
        nomville.setText(viewDataName(nomlieu));

        TextView info = (TextView) findViewById(R.id.information);
        info.setText(viewDataInformation(nomlieu));

        TextView pollution = (TextView) findViewById(R.id.pollution);
        pollution.setText(viewDataDescription(nomlieu));

        CheckBox chk = (CheckBox) findViewById(R.id.chk1);

        if(estFavori(nomlieu) == 1){
            chk.setChecked(true);
        }
        // Mise en place du traitement sur le bouton ...
        Button boutonRetour = (Button)findViewById(R.id.buttonrtn);

        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult = new Intent();
                intentResult.putExtra("result", db.countFavori());
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)  {
                    db.ajouterFavori(nomlieu);
                    Toast.makeText(InfosPollution.this, R.string.toastajoutfav, Toast.LENGTH_SHORT).show();
                } else {
                    db.supprimerFavori(nomlieu);
                    Toast.makeText(InfosPollution.this, R.string.toastsuppfav, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

   private String viewDataName(String texte) {
        String retour="";
        Cursor cursor = db.viewData("select NAME from ocean_table WHERE NAME='" + texte +"'");

        if (cursor.getCount() == 0) {
            Toast.makeText(this, R.string.toastfavorinodata, Toast.LENGTH_SHORT).show();
            cursor.close();
        } else {
            while (cursor.moveToNext()) {
                retour = cursor.getString(0);
            }

        }
       cursor.close();
       return retour;
    }

    private String viewDataInformation(String texte) {
        String retour="";
        Cursor cursor = db.viewData("select INFORMATION from ocean_table WHERE NAME='" + texte +"'");

        if (cursor.getCount() == 0) {
            Toast.makeText(this, R.string.toastfavorinodata, Toast.LENGTH_SHORT).show();
            cursor.close();
        } else {
            while (cursor.moveToNext()) {
                retour = cursor.getString(0);
            }
        }
        cursor.close();
        return retour;
    }

    private String viewDataDescription(String texte) {
        String retour="";
        Cursor cursor = db.viewData("select DESCRIPTION from ocean_table WHERE NAME='" + texte +"'");

        if (cursor.getCount() == 0) {
            Toast.makeText(this, R.string.toastfavorinodata, Toast.LENGTH_SHORT).show();
            cursor.close();
        } else {
            while (cursor.moveToNext()) {
                retour = cursor.getString(0);
            }

        }
        cursor.close();
        return retour;
    }


    private int estFavori(String texte) {
        int retour= 0;
        Cursor cursor = db.viewData("select FAVORIS from ocean_table WHERE NAME='" + texte +"'");

        if (cursor.getCount() == 0) {
            cursor.close();
            Toast.makeText(this, R.string.toastfavorinodata, Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                retour = cursor.getInt(0);
            }

        }
        cursor.close();
        return retour;
    }

}
