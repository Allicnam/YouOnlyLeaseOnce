package org.tensorflow.lite.examples.detection;

import android.os.Parcel;
import android.os.Parcelable;

public class Departamento implements Parcelable {

    private String nombre;

    public Departamento(String nombre) {
        this.nombre = nombre;
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

}
