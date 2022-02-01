package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myproject.databinding.ActivityNewOrderBinding;
import com.example.myproject.databinding.FragmentNewOrderBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ZamowienieActivity extends Fragment {
    private ActivityNewOrderBinding binding;
    private EditText editTextTextPersonName2;
    private EditText editTextTextPersonName3;
    private EditText editTextTextPersonName4;
    private Button button;
    private TextView textView3;
    private TextView textview_first;
    ListView produktywKoszyku;  //
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_new_order2, container, false);

        produktywKoszyku = (ListView) view.findViewById(R.id.lista_koszyk);
        produktywKoszyku.setAdapter(new ListaAdapter(this.getContext(), Koszyk.PobierzKoszyk()));

        editTextTextPersonName2 = (EditText) view.findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = (EditText) view.findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName4 = (EditText) view.findViewById(R.id.editTextTextPersonName4);
        button = (Button) view.findViewById(R.id.button87);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imie = editTextTextPersonName2.getText().toString();
                String nazwisko = editTextTextPersonName3.getText().toString();
                String numer = editTextTextPersonName4.getText().toString();

                Zamowienie zamowienie = new Builder().setImie(imie).setNazwisko(nazwisko).setNumer(numer).build();

                zamowienie.Produkty = new ArrayList<String>();
                zamowienie.Produkty.add(numer);

                Toast.makeText(view.getContext(), R.string.zamowiono, Toast.LENGTH_LONG).show();

            }
        });


        //Toast.makeText(view, R.string.zamowiono, view.Toast.LENGTH_LONG).show();
        return view;
    }
}