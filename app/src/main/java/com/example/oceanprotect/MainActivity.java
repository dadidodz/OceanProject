package com.example.oceanprotect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    Database myDb;
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] nomsLieuxListe;
    ArrayList<NomsLieux> arraylist = new ArrayList<NomsLieux>();
    Button btnviewAll;
    private SQLiteOpenHelper DBHelper;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked){
                    this.nomsLieuxListe = new String[]{"Paris", "Brest", "Toulouse", "Bordeaux",
                            "Atlantique", "Lacanau", "Grau-Du-Roi", "Tours", "Lyon", "Grenoble",
                            "Ajaccio"};
                    this.arraylist.clear();
                    for (int i = 0; i < this.nomsLieuxListe.length; i++) {
                        NomsLieux nomsLieux = new NomsLieux(nomsLieuxListe[i]);
                        // Binds all strings into an array

                        this.arraylist.add(nomsLieux);
                    }
                    this.adapter.notifyDataSetChanged();
                }
                break;
            case R.id.radioButton2:
                if (checked) {
                    this.nomsLieuxListe = new String[]{"Paris", "Brest", "Toulouse", "Bordeaux",
                            "Atlantique", "Lacanau", "Grau-Du-Roi", "Nîmes"};
                    this.arraylist.clear();
                    for (int i = 0; i < this.nomsLieuxListe.length; i++) {
                        NomsLieux nomsLieux = new NomsLieux(nomsLieuxListe[i]);
                        // Binds all strings into an array

                        this.arraylist.add(nomsLieux);
                    }

                    this.adapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnviewAll = (Button) findViewById(R.id.buttonview);
        viewAll();
        // Generate sample data

        this.nomsLieuxListe = new String[]{"Paris", "Brest", "Toulouse", "Bordeaux",
                "Atlantique", "Lacanau", "Grau-Du-Roi", "Tours", "Lyon", "Grenoble",
                "Ajaccio"};
        /*
        int i = 0;
        while (res.movetonext()){
            this.nomsLieuxListe[i] = requete SQL "SELECT NAME FROM TABLE_NAME";
            i++;
        }

         */

    // Locate the ListView in listview_main.xml
        this.list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < nomsLieuxListe.length; i++) {
            NomsLieux nomsLieux = new NomsLieux(nomsLieuxListe[i]);
            // Binds all strings into an array
            arraylist.add(nomsLieux);
        }

        // Pass results to ListViewAdapter Class
        this.adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        this.list.setAdapter(this.adapter);

        // Locate the EditText in listview_main.xml
        this.editsearch = (SearchView) findViewById(R.id.search);
        this.editsearch.setOnQueryTextListener(this);

        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Map.class));

                onRadioButtonClicked(v);

            }
        });

        this.myDb = new Database(this);

    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // voir les messages
                            showMessage("Error", "Aucune data");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()) {
                            buffer.append("ID :" + res.getString(0) + "\n");
                            buffer.append("Name :" + res.getString(1) + "\n");
                            buffer.append("Description :" + res.getString(2) + "\n");
                            buffer.append("Information :" + res.getString(3) + "\n");
                        }

                        //Voir toutes les datas
                        showMessage("Data", buffer.toString());

                    }
                }
        );
    }

    public void showMessage (String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.favori:
                Intent intent = new Intent(MainActivity.this, Favoris.class);

                // Récupère la valeur de l'item à la position sur laquelle on a cliqué
                //String valeurItem = (String) parent.getItemAtPosition(position);

                // Fixe un paramètre sous la forme clé-valeur
                //intent.putExtra("letexte", valeurItem);

                //Toast.makeText(MainActivity.this, "bonjour", Toast.LENGTH_SHORT).show();

                startActivity(intent);
                break;
            case R.id.quitmenu:
                System.exit(0) ;
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }









}