package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import org.tensorflow.lite.examples.detection.Database.AppDatabase;
import org.tensorflow.lite.examples.detection.Database.Departamento;
import org.tensorflow.lite.examples.detection.Database.DepartamentoDAO;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoController {
    private static DepartamentoController sDepaC;

    private DepartamentoDAO mDepartamentoDAO;
    private static final String TAG = "MyActivity";

    private DepartamentoController(Context context) {
        Context appContext = context.getApplicationContext();
        AppDatabase database = Room.databaseBuilder(appContext, AppDatabase.class, "departamento")
                .allowMainThreadQueries().build();
        mDepartamentoDAO = database.departamentoDAO();
    }

    public static DepartamentoController get(Context context) {
        if (sDepaC == null) {
            sDepaC = new DepartamentoController(context);
        }
        return sDepaC;
    }

    public ArrayList<Departamento> getDepas() {
        return new ArrayList<Departamento>(mDepartamentoDAO.getAll());
    }

//    public Departamento getNota(String id) {
//        return mNotaDao.getNota(id);
//    }

    public void addDepartamento(Departamento depa) {
        Log.v(TAG, ""+depa.getDid());
        mDepartamentoDAO.insertDepa(depa);
    }

//    public void updateNota(Nota nota) {
//        mNotaDao.updateNota(nota);
//    }

    public void deleteDepa(Departamento depa) {
        mDepartamentoDAO.delete(depa);
    }
}

