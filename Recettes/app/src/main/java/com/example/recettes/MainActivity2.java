package com.example.recettes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    TextView titre, desc;
    private static final String LOG_TAG = MainActivity2.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        titre = findViewById(R.id.titre);
        desc = findViewById(R.id.ingredi);
        Intent intent = getIntent();
        Recette recette = (Recette) intent.getSerializableExtra("data");
        String  t = recette.getTitle();
        titre.setText(t);
        desc.setText(recette.getDesc());
        Log.d(LOG_TAG, "you clicked " +t);
        if(t == "Couscous"){
            desc.setText("1Kg couscous + 2 tomates");
        }else if(t == "Crepe"){
            desc.setText("1Kg Farine + 1L lait");
        }


    }
}