package com.example.oceanprotect;

import android.content.Intent;
import android.content.SharedPreferences;
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

    private ArrayList<String> ListItem;
    private ArrayAdapter adapter;
    private Database db;
    private ListView FavorisList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoris_layout);

        this.db = new Database(this);
        this.ListItem = new ArrayList<>();

        this.FavorisList = findViewById(R.id.lvFavoris);

        viewData();

        this.FavorisList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = FavorisList.getItemAtPosition(position).toString();

                Intent intent = new Intent(Favoris.this, InfosPollution.class);

                // Récupère la valeur de l'item à la position sur laquelle on a cliqué
                String valeurItem = (String) parent.getItemAtPosition(position);

                //String msg = valeurItem.getNomsLieux();

                // Fixe un paramètre sous la forme clé-valeur
                intent.putExtra("nomlieu",valeurItem);

                startActivity(intent);
            }
        });

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
    }

    private void viewData() {
        Cursor cursor = this.db.viewData("Select * from ocean_table where FAVORIS = 1 ORDER BY NAME ASC");

        if (cursor.getCount() == 0) {
            Toast.makeText(this, R.string.toastfavorinodata, Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                this.ListItem.add(cursor.getString(1));
            }

            this.adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListItem);
            this.FavorisList.setAdapter(adapter);
        }
    }
}