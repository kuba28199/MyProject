package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;

import com.example.myproject.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.ui.main.SectionsPagerAdapter;
import com.example.myproject.databinding.ActivityNewOrderBinding;

import java.util.ArrayList;

public class NewOrder extends AppCompatActivity {

    private ActivityNewOrderBinding binding;
    private EditText editTextTextPersonName2;
    private EditText editTextTextPersonName3;
    private EditText editTextTextPersonName4;
    private Button button;
    private TextView textView3;
    private TextView textview_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* if (tabs.getSelectedTabPosition() == 2){
                    String imie = editTextTextPersonName2.getText().toString();
                    String nazwisko = editTextTextPersonName3.getText().toString();
                    String numer = editTextTextPersonName4.getText().toString();

                    Zamowienie zamowienie = new Builder().setImie(imie).setNazwisko(nazwisko).setNumer(numer).build();

                    zamowienie.Produkty = new ArrayList<String>();
                    zamowienie.Produkty.add(numer);

                    Intent i = new Intent();
                    i.putExtra("messege", "messege");
                    setResult(123, i);
                    finish();

                    Toast.makeText(NewOrder.this, R.string.zamowiono, Toast.LENGTH_LONG).show();
                }*/
                Intent i = new Intent();
                i.putExtra("messege", "messege");
                setResult(123, i);
                finish();
            }
        });

        //editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        //editTextTextPersonName3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        //editTextTextPersonName4 = (EditText) findViewById(R.id.editTextTextPersonName4);
        //button = (Button) findViewById(R.id.button);
        //textView3 = (TextView) findViewById(R.id.textView3);




        //button.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
            //    String imie = editTextTextPersonName2.getText().toString();
             //   String nazwisko = editTextTextPersonName3.getText().toString();
              //  String numer = editTextTextPersonName4.getText().toString();

             //   Zamowienie zamowienie = new Builder().setImie(imie).setNazwisko(nazwisko).setNumer(numer).build();

             //   textView3.setText("Imie: " + zamowienie.imie + "\nNazwisko: " + zamowienie.nazwisko + "\nNumer: " + numer);
          //  }
       // });
    }
}