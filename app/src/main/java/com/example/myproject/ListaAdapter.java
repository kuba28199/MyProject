package com.example.myproject;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class ListaAdapter extends ArrayAdapter<Produkt> {
    List<Produkt> lista;
    private final Context context;

    public ListaAdapter(@NonNull Context _context, List<Produkt> _lista) {
        super(_context, R.layout.);
    }
}
