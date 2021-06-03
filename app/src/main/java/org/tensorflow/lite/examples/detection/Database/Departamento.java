package org.tensorflow.lite.examples.detection.Database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

@Entity
public class Departamento implements Parcelable, Serializable {

    @PrimaryKey
    @NonNull
    private String did;

    @ColumnInfo(name="nombre")
    private String nombre;

    @ColumnInfo(name="objetos")
    private ArrayList<String> objetosEncontrados;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;


    public Departamento(String nombre, ArrayList<String> objetosEncontrados, byte[] image) {
        this.nombre = nombre;
        this.image = image;
        this.did = UUID.randomUUID().toString();
        this.objetosEncontrados = objetosEncontrados;
    }

    protected Departamento(Parcel in) {
        nombre = in.readString();
        did = in.readString();
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
        dest.writeString(did);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDid() {
        return did;
    }

    public ArrayList<String>  getObjetosEncontrados() {
        return objetosEncontrados;
    }

    public void setDid(@NonNull String id) {
        did = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
