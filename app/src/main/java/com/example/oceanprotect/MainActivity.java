package com.example.oceanprotect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables

    public static final int NB_FAV = 0;
    private Database myDb;
    private ListView list;
    private ListViewAdapter adapter;
    private SearchView editsearch;
    private ArrayList<NomsLieux> nomsLieuxlist = new ArrayList<NomsLieux>();
    private Button btnviewAll;
    private ArrayList<String> ListItem;
    private TextView textV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.myDb = new Database(this);
        this.textV = (TextView)findViewById(R.id.textnbfavoris);
        this.textV.setText(String.valueOf(myDb.countFavori()) + " favoris");
        this.ListItem = new ArrayList<>();

        Cursor cursor = myDb.viewData("select NAME from ocean_table order by NAME ASC");
        while (cursor.moveToNext()) {
            this.ListItem.add(cursor.getString(0));
        }
        this.nomsLieuxlist.clear();
        for (int i = 0; i < this.ListItem.size(); i++) {
            NomsLieux nomsLieux = new NomsLieux(this.ListItem.get(i));
            // Binds all strings into an array
            this.nomsLieuxlist.add(nomsLieux);
        }

        // Locate the ListView in listview_main.xml
        this.list = (ListView) findViewById(R.id.listview);

        // Pass results to ListViewAdapter Class
        this.adapter = new ListViewAdapter(this, this.nomsLieuxlist);

        // Binds the Adapter to the ListView
        this.list.setAdapter(this.adapter);

        // Locate the EditText in listview_main.xml
        this.editsearch = (SearchView) findViewById(R.id.search);
        this.editsearch.setOnQueryTextListener(this);

        Button btn = (Button)findViewById(R.id.buttongmap);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Map.class));
            }
        });

        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, InfosPollution.class);

                // Récupère la valeur de l'item à la position sur laquelle on a cliqué
                NomsLieux valeurItem = (NomsLieux) parent.getItemAtPosition(position);

                String msg = valeurItem.getNomsLieux();

                // Fixe un paramètre sous la forme clé-valeur
                intent.putExtra("nomlieu", msg);

                startActivityForResult(intent, 1);
            }
        });



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
        this.adapter.filter(text);
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

                startActivityForResult(intent, 1);
                break;
            case R.id.quitmenu:
                System.exit(0) ;
                break;
            case R.id.infos:
                showMessage(getString(R.string.titremsginfos), getString(R.string.msginfos));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int resultat = data.getIntExtra("result", 0);
                this.textV.setText(resultat + " favoris");
            }
            if (resultCode == RESULT_CANCELED) {

                this.textV.setText("Erreur");
            }
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonTout:
                if (checked){
                    viewDataFactoriser("select NAME from ocean_table order by NAME ASC");
                }
                break;
            case R.id.radioButtonMer:
                if (checked) {
                    viewDataFactoriser("select NAME from ocean_table where MEROCEAN='true' order by NAME ASC");
                }
                break;
            case R.id.radioButtonOcean:
                if (checked) {
                    viewDataFactoriser("select NAME from ocean_table where MEROCEAN='false' order by NAME ASC");
                }
                break;
        }
    }

    private void viewDataFactoriser(String query) {
        Cursor cursor = this.myDb.viewData(query);

        this.ListItem.clear();
        this.nomsLieuxlist.clear();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, R.string.toastfavorinodata, Toast.LENGTH_SHORT).show();
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
}
