package com.example.myproject;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProduktRepository {
    private ProduktDao produktDao;
    private LiveData<List<Produkt>> produkty;

    ProduktRepository(Application application) {
        ProduktDatabase database = ProduktDatabase.getDatabase(application);
        produktDao = database.produktDao();
        produkty = produktDao.findAll();
    }

    LiveData<List<Produkt>> findAllBooks(){
        return produkty;
    }

    void insert(Produkt produkt){
        ProduktDatabase.databaseWriteExecutor.execute(() -> {
            produktDao.insert(produkt);
        });
    }

    void update(Produkt produkt){
        ProduktDatabase.databaseWriteExecutor.execute(() -> {
            produktDao.update(produkt);
        });
    }

    void delete(Produkt produkt){
        ProduktDatabase.databaseWriteExecutor.execute(() -> {
            produktDao.delete(produkt);
        });
    }

    public LiveData<Produkt> findProduktById(Integer id){
        return produktDao.findProduktById(id);
    }
}
