package com.example.recettes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.SelectedRecette{
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    List<Recette> recetteList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        Recette recette = new Recette();
        recette.setTitle("Omlette");
        recette.setDesc("3 Oeufs");
        recetteList.add(recette);

        recette = new Recette();
        recette.setTitle("Cake");
        recette.setDesc("3 Oeufs");
        recetteList.add(recette);

        recette = new Recette();
        recette.setTitle("Couscous");
        recette.setDesc("1Kg Semoule");
        recetteList.add(recette);

        recette = new Recette();
        recette.setTitle("Crepe");
        recette.setDesc("3 Oeufs");
        recetteList.add(recette);

        recette = new Recette();
        recette.setTitle("Cafe");
        recette.setDesc("Nescafe + Lait");
        recetteList.add(recette);

        recette = new Recette();
        recette.setTitle("Gauffre");
        recette.setDesc("Chocolat + fraise");
        recetteList.add(recette);

        recette = new Recette();
        recette.setTitle("Jus de fruit");
        recette.setDesc("Banane + Orange");
        recetteList.add(recette);

        recette = new Recette();
        recette.setTitle("Sbagetti");
        recette.setDesc("0,2Kg Tomate");
        recetteList.add(recette);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new MyRecyclerViewAdapter(recetteList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void selectedRecette(Recette recette) {
        startActivity(new Intent(MainActivity.this, MainActivity2.class).putExtra("data", recette));
    }
}

