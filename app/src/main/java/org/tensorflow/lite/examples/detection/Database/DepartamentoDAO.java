package org.tensorflow.lite.examples.detection.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface  DepartamentoDAO {
    @Query("SELECT * FROM Departamento")
    List<Departamento> getAll();

    @Query("SELECT * FROM Departamento WHERE did IN (:depaIds)")
    List<Departamento> loadAllByIds(String[] depaIds);

    @Insert
    void insertDepa(Departamento departamento);

    @Delete
    void delete(Departamento departamento);

}
