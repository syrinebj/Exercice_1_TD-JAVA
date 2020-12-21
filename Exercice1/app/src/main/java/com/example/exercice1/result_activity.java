package com.example.exercice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class result_activity extends AppCompatActivity {
    TextView textView1 , textView2, textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        Intent intent = getIntent();
        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);
        textView3 = findViewById(R.id.textView4);
        String nom = intent.getStringExtra(("nom"));
        String poids = intent.getStringExtra("poids");
        String taille = intent.getStringExtra("taille");
        String age = intent.getStringExtra("age");
        String indice = intent.getStringExtra("imc");
        String message = intent.getStringExtra("message");
        textView1.setText(nom + " a "+ age+ " ans. " +"Il/Elle pese " +poids+ " Kg pour une taille de " +taille+ "m");
        textView2.setText("Votre indice " +indice );
        textView3.setText(message);
    }
}