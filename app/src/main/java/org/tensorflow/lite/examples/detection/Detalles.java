package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Detalles extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        Intent intent = getIntent();

        Departamento myParcelableObject = intent.getParcelableExtra("departamento");
        ArrayList<String> detallesArrayList = (ArrayList<String>) intent.getSerializableExtra("objetosEncontrados");

        recyclerView = findViewById(R.id.recyclerView);
        DetallesAdapter detallesAdapter = new DetallesAdapter(this, detallesArrayList);
        recyclerView.setAdapter(detallesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        titulo = findViewById(R.id.nombreDepaText);
        titulo.setText(myParcelableObject.getNombre());
    }
}