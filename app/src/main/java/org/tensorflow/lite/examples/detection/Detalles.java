package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.tensorflow.lite.examples.detection.Database.Departamento;

import java.util.ArrayList;

public class Detalles extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView titulo;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        Intent intent = getIntent();

        Departamento myParcelableObject = intent.getParcelableExtra("departamento");
        ArrayList<String> detallesArrayList = (ArrayList<String>) intent.getSerializableExtra("objetosEncontrados");
        byte[] imageDepa = intent.getByteArrayExtra("image");

        recyclerView = findViewById(R.id.recyclerView);
        DetallesAdapter detallesAdapter = new DetallesAdapter(this, detallesArrayList);
        recyclerView.setAdapter(detallesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        titulo = findViewById(R.id.nombreDepaText);
        titulo.setText(myParcelableObject.getNombre());

        image = findViewById(R.id.depaImagen);
        if(imageDepa != null)
            image.setImageBitmap(BitmapFactory.decodeByteArray(imageDepa, 0, imageDepa.length));
    }
}