package com.example.oceanprotect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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