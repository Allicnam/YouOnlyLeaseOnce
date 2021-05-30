package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.detection.tflite.Classifier;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");


        departamentoArrayList.add(new Departamento("departamento 1", arrayList));

        recyclerView = findViewById(R.id.recyclerView);
        depaAdapter = new DepaAdapter(this, departamentoArrayList);
        recyclerView.setAdapter(depaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cameraButton = findViewById(R.id.button);
        cameraButton.setOnClickListener(v -> startActivity(new Intent(this, DetectorActivity.class)));
    }
}