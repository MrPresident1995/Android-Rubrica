package com.fabiohong.rubrica;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContattoDAO {
    @Insert
    void insertContatto(Contatto c);

    @Insert
    void insertContatto(Contatto... c);

    @Update
    void updateContatto(Contatto c);

    @Query("DELETE FROM Contatto")
    void deleteAll();

    @Delete
    void deleteContact(Contatto c);

    @Query("SELECT * FROM Contatto")
    List<Contatto> getContatto();
}
