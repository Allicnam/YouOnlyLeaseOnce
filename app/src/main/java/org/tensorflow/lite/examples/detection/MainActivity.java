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

    public static final String TITULO = "departamento ";
    int contador = 1;

    private ArrayList<Departamento> departamentoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        departamentoArrayList = new ArrayList<>();

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

                departamentoArrayList.add(new Departamento(TITULO + contador, lista));
                depaAdapter.notifyDataSetChanged();
                contador += 1;
            }
        }
    }
}