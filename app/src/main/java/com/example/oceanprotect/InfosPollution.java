package com.example.oceanprotect;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        String texte = getIntent().getStringExtra("letexte");

        // modifie le texte du label de l'activite avec cette valeur
        TextView textV = (TextView)findViewById(R.id.textView);
        //textV.setText(texte);

        this.db = new Database(this);

        textV.setText(viewData(texte));

        // Mise en place du traitement sur le bouton ...
        Button boutonRetour = (Button)findViewById(R.id.buttonrtn);

        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

   private String viewData(String texte) {
        String retour="";
        Cursor cursor = db.viewData("select NAME, DESCRIPTION from ocean_table WHERE NAME='" + texte +"'");

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Aucune Données", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                retour = cursor.getString(0) + "\n" + cursor.getString(1);
            }

        }
       return retour;
    }



}
