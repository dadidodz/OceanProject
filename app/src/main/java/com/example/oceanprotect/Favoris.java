package com.example.oceanprotect;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Favoris extends AppCompatActivity {

    ArrayList<String> ListItem;
    ArrayAdapter adapter;
    Database db;

    ListView FavorisList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoris_layout);

        // Récupère le paramètre de l'intent via la clé utilisée
        //String texte = getIntent().getStringExtra("letexte");

        // modifie le texte du label de l'activité avec cette valeur
        //TextView textV = (TextView)findViewById(R.id.textView);
        //textV.setText(texte);

        // Mise en place du traitement sur le bouton ...

        db = new Database(this);
        ListItem = new ArrayList<>();

        FavorisList = findViewById(R.id.lvFavoris);

        viewData();

        FavorisList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = FavorisList.getItemAtPosition(position).toString();
                Toast.makeText(Favoris.this, ""+text, Toast.LENGTH_SHORT).show();



                Intent intent = new Intent(Favoris.this, InfosPollution.class);

                // Récupère la valeur de l'item à la position sur laquelle on a cliqué
                String valeurItem = (String) parent.getItemAtPosition(position);

                //String msg = valeurItem.getNomsLieux();

                // Fixe un paramètre sous la forme clé-valeur
                intent.putExtra("letexte",valeurItem);

                //Toast.makeText(MainActivity.this, valeurItem, Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });

        Button boutonRetour = (Button)findViewById(R.id.buttonrtn);

        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void viewData() {
        Cursor cursor = db.viewData("Select * from ocean_table where FAVORIS = 'true'");

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Aucune Données", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                ListItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListItem);
            FavorisList.setAdapter(adapter);
        }
    }
}