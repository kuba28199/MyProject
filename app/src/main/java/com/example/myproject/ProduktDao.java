package com.example.myproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProduktDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Produkt produkt);

    @Update
    public void update(Produkt produkt);

    @Delete
    public void delete(Produkt produkt);

    @Query("DELETE FROM produkt")
    public void deleteAll();

    @Query("SELECT * FROM produkt ORDER BY nazwa")
    public LiveData<List<Produkt>> findAll();

    @Query("SELECT * FROM produkt WHERE id LIKE :id")
    public LiveData<Produkt> findProduktById(Integer id);


}
