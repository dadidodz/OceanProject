package com.example.oceanprotect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfosPollution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infospollution_layout);

        // Recupere le parametre de l'intent via la cle utilisee
        String texte = getIntent().getStringExtra("letexte");

        // modifie le texte du label de l'activite avec cette valeur
        TextView textV = (TextView)findViewById(R.id.textView);
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
}
