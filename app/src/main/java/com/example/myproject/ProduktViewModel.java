package com.example.myproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProduktViewModel extends AndroidViewModel {
    private ProduktRepository produktRepository;
    private LiveData<List<Produkt>> produkty;
    public ProduktViewModel(@NonNull Application application){
        super(application);
        produktRepository = new ProduktRepository((application));
        produkty = produktRepository.findAllBooks();
    }

    public LiveData<List<Produkt>> findAll(){
        return produkty;
    }

    public void insert(Produkt produkt){
        produktRepository.insert(produkt);
    }

    public void update(Produkt produkt){
        produktRepository.update(produkt);
    }

    public void delete(Produkt produkt){
        produktRepository.delete(produkt);
    }
}
