package com.example.oceanprotect;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InfosPollution extends AppCompatActivity  {

    private Database myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infospollution_layout);

        // Recupere le parametre de l'intent via la cle utilisee
        String texte = getIntent().getStringExtra("letexte");

        // modifie le texte du label de l'activite avec cette valeur
        TextView textV = (TextView)findViewById(R.id.textView);
        //textV.setText(texte);

        //this.myDb = new Database(this);
        //Cursor cursor = myDb.viewData("select NAME, DESCRIPTION from ocean_table WHERE NAME = '" + texte +"'");
        //viewDataFactoriser("select NAME from ocean_table order by NAME ASC");

        //String tmp = cursor.getString(-1);
        textV.setText(texte);

        // Mise en place du traitement sur le bouton ...
        Button boutonRetour = (Button)findViewById(R.id.buttonrtn);

        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /*
    private void viewDataFactoriser(String query) {
        Cursor cursor = myDb.viewData(query);

        this.ListItem.clear();
        this.nomsLieuxlist.clear();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Aucune Données", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                this.ListItem.add(cursor.getString(0));
            }
            for (int i = 0; i < this.ListItem.size(); i++) {
                NomsLieux nomsLieux = new NomsLieux(this.ListItem.get(i));
                // Binds all strings into an array
                this.nomsLieuxlist.add(nomsLieux);
            }
            this.adapter.notifyDataSetChanged();
        }
    }

     */

}
