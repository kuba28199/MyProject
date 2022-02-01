package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListaAdapter extends ArrayAdapter<Produkt> {
    ArrayList<Produkt> lista;
    private final Context context;

    public ListaAdapter(@NonNull Context _context, ArrayList<Produkt> _lista) {
        super(_context, R.layout.produkt_w_koszyku, _lista);

        this.lista = _lista;
        this.context = _context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        convertView = new LinearLayout(getContext());
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(inflater);
        convertView = layoutInflater.inflate(R.layout.produkt_w_koszyku, parent, false);

        Produkt produkt = getItem(position);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
        nameTextView.setText(lista.get(position).getNazwa());

        TextView priceTextView = (TextView) convertView.findViewById(R.id.price);
        priceTextView.setText(Float.toString(produkt.getCena())+" zł.");

        return convertView;
    }
}
