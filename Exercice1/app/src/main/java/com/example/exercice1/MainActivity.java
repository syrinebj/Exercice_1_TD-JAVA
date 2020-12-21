package com.example.exercice1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nom, poids, taille, age;
    Button button;
    Context context = this;
    String message="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = findViewById(R.id.nom);
        poids = findViewById(R.id.poids);
        taille = findViewById(R.id.taille);
        age = findViewById(R.id.age);
        button = findViewById(R.id.bCalculer);
    }

    public void Calculer(View view) {
        if (nom.getText().toString().length() != 0 && poids.getText().toString().length() != 0 && taille.getText().toString().length() != 0 && age.getText().toString().length() != 0) {
            float a = (float) Math.sqrt(Float.parseFloat(taille.getText().toString()));
            float b = Float.parseFloat(poids.getText().toString());
            float c = b/a;
            String imc = String.valueOf(c);
            if(c<18.5){
                message = "Maigreur";
            }
            else if(c>=18.5 && c<24.9){
                message = "Normal";
            }
            else if(c>=24.9 && c<29.9){
                message = "Surpoids";
            }
            else if(c>=29.9 && c<40){
                message = "Obesite";
            }
            else{
                message = "Obesite massive";
            }
            Intent intent = new Intent(this, result_activity.class);
            intent.putExtra("nom", nom.getText().toString());
            intent.putExtra("poids",poids.getText().toString());
            intent.putExtra("taille", taille.getText().toString());
            intent.putExtra("age", age.getText().toString());
            intent.putExtra("imc", imc);
            intent.putExtra("message", message);
            startActivity(intent);

        }
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Attention");
            alert.setMessage("Il faut remplir tous les champs");
            alert.setCancelable(false);
            alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = alert.create();
            dialog.show();
        };

    }

}

