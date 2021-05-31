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
        cameraButton.setOnClickListener(v -> startActivityForResult(new Intent(this, DetectorActivity.class), 1));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                ArrayList<String> lista = (ArrayList<String>) data.getSerializableExtra("recognition");
            }
        }
    }
}