package com.example.oceanprotect;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

        // Recupere le parametre de l'intent via la cle utilisee
        String nomlieu = getIntent().getStringExtra("nomlieu");

        // modifie le texte du label de l'activite avec cette valeur
        TextView textV = (TextView)findViewById(R.id.textView);
        //textV.setText(texte);

        this.db = new Database(this);

        textV.setText(viewData(nomlieu));

        TextView textV2 = (TextView)findViewById(R.id.textView2);
        textV2.setText(estFavori(nomlieu));

        CheckBox chk = (CheckBox) findViewById(R.id.chk1);

/*
        if(estFavori(texte)=="true"){
            chk.setChecked(true);
        }

 */


        // Mise en place du traitement sur le bouton ...
        Button boutonRetour = (Button)findViewById(R.id.buttonrtn);

        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //notifyAll();
                finish();
            }
        });


        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)  {
                    //Cursor cursor = db.viewData("select NAME, DESCRIPTION from ocean_table WHERE NAME='" + texte +"'");
                    db.ajouterFavori(nomlieu);
                    Toast.makeText(InfosPollution.this, nomlieu + " ajoutee aux favoris", Toast.LENGTH_SHORT).show();
                } else {
                    db.supprimerFavori(nomlieu);
                    Toast.makeText(InfosPollution.this, nomlieu + " supprimee des favoris", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

   private String viewData(String texte) {
        String retour="";
        Cursor cursor = db.viewData("select NAME, DESCRIPTION from ocean_table WHERE NAME='" + texte +"'");

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Aucune Donnees", Toast.LENGTH_SHORT).show();
            cursor.close();
        } else {
            while (cursor.moveToNext()) {
                retour = cursor.getString(0) + "\n" + cursor.getString(1);
            }

        }
       cursor.close();
       return retour;
    }

    private String estFavori(String texte) {
        String retour= "false";
        Cursor cursor = db.viewData("select FAVORIS from ocean_table WHERE NAME='" + texte +"'");

        if (cursor.getCount() == 0) {
            cursor.close();
            Toast.makeText(this, "Aucune Donnees", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                retour = cursor.getString(0);
            }
        }
        cursor.close();
        return retour;
    }





}
