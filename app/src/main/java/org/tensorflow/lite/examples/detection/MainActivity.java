package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DepaAdapter depaAdapter;
    Button cameraButton;

    private ArrayList<Departamento> departamentoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        departamentoArrayList = new ArrayList<>();

        departamentoArrayList.add(new Departamento("departamento 1"));
        departamentoArrayList.add(new Departamento("departamento 2"));
        departamentoArrayList.add(new Departamento("departamento 3"));

        recyclerView = findViewById(R.id.recyclerView);
        depaAdapter = new DepaAdapter(this, departamentoArrayList);
        recyclerView.setAdapter(depaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cameraButton = findViewById(R.id.button);
        cameraButton.setOnClickListener(v -> startActivity(new Intent(this, DetectorActivity.class)));
    }
}