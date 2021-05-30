package org.tensorflow.lite.examples.detection;

import android.os.Parcel;
import android.os.Parcelable;

import org.tensorflow.lite.examples.detection.tflite.Classifier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Departamento implements Parcelable, Serializable {

    private String nombre;

    private ArrayList<String> objetosEncontrados;

    public Departamento(String nombre, ArrayList<String> objetosEncontrados) {
        this.nombre = nombre;
        this.objetosEncontrados = objetosEncontrados;
    }

    protected Departamento(Parcel in) {
        nombre = in.readString();
    }

    public static final Creator<Departamento> CREATOR = new Creator<Departamento>() {
        @Override
        public Departamento createFromParcel(Parcel in) {
            return new Departamento(in);
        }

        @Override
        public Departamento[] newArray(int size) {
            return new Departamento[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String>  getObjetosEncontrados() {
        return objetosEncontrados;
    }

}
