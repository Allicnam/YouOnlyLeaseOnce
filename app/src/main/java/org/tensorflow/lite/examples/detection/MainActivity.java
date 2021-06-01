package org.tensorflow.lite.examples.detection;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import org.tensorflow.lite.examples.detection.Database.Departamento;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DepaAdapter depaAdapter;
    Button cameraButton;

    private DepartamentoController mDepaController;

    public static final String TITULO = "departamento ";
    int contador = 1;

    public String DEPATITULO = "";

    private ArrayList<Departamento> departamentoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDepaController = DepartamentoController.get(this);
        departamentoArrayList = mDepaController.getDepas();
        contador = departamentoArrayList.size()+1;
        recyclerView = findViewById(R.id.recyclerView);

        depaAdapter = new DepaAdapter(this, departamentoArrayList, mDepaController);
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
                byte[] image = data.getByteArrayExtra("image");
                onDepaAdded(recyclerView, lista, image);
            }
        }
    }

    public void onDepaAdded(View view, ArrayList<String> lista, byte[] image) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.name_popup, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        Button saveButton = popupView.findViewById(R.id.saveButton);
        TextInputEditText nameEdit = popupView.findViewById(R.id.editName);

        // show the popup window
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String textoDepa = nameEdit.getText().toString();
                if(textoDepa.length() < 1){
                    nameEdit.setError( "El nombre es requerido!" );
                }
                else{
                    DEPATITULO = textoDepa;
                    Departamento newDepa = new Departamento(DEPATITULO, lista, image);
                    mDepaController.addDepartamento(newDepa);
                    departamentoArrayList.add(newDepa);
                    depaAdapter.notifyDataSetChanged();
                    popupWindow.dismiss();
                }
            }
        });
    }
}