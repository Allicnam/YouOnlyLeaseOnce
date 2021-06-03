package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.tensorflow.lite.examples.detection.Database.Departamento;

import java.util.ArrayList;

public class Detalles extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView titulo;
    ImageView image;
    EditText newItemInput;
    Button addItemButton;

    private DepartamentoController mDepaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        Intent intent = getIntent();

        Departamento myParcelableObject = intent.getParcelableExtra("departamento");
        ArrayList<String> detallesArrayList = (ArrayList<String>) intent.getSerializableExtra("objetosEncontrados");
        byte[] imageDepa = intent.getByteArrayExtra("image");

        mDepaController = DepartamentoController.get(this);

        recyclerView = findViewById(R.id.recyclerView);
        DetallesAdapter detallesAdapter = new DetallesAdapter(this, detallesArrayList, myParcelableObject.getDid(), mDepaController);
        recyclerView.setAdapter(detallesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        titulo = findViewById(R.id.nombreDepaText);
        titulo.setText(myParcelableObject.getNombre());

        image = findViewById(R.id.depaImagen);
        if(imageDepa != null)
            image.setImageBitmap(BitmapFactory.decodeByteArray(imageDepa, 0, imageDepa.length));

        newItemInput = findViewById(R.id.newItemInput);

        addItemButton = findViewById(R.id.addItemButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String newItem = newItemInput.getText().toString();

                detallesAdapter.addItem(newItem);
                //detallesArrayList.add(newItem);
            }
        });

    }
}