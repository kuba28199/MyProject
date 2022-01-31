package com.example.myproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.databinding.FragmentNewOrderBinding;
import com.example.myproject.databinding.FragmentSecondBinding;
import com.example.myproject.ui.main.PageViewModel;
import com.example.myproject.ui.main.PlaceholderFragment;

import java.util.List;

public class JedzenieActivity extends Fragment {

    Spinner rodzajJedzenia, rodzajFrytek, rodzajNapoju;
    Button stworz, DodajDoKoszyka, ZobaczKoszyk;
    TextView nowyzestaw;
    String nazwa = "Własny zestaw";
    String opis = "opis";
    float cena = 5;
    View view;
    private FragmentNewOrderBinding binding;;
    private static final String ARG_SECTION_NUMBER = "section_number";


    public static JedzenieActivity newInstance(int index) {
        JedzenieActivity fragment = new JedzenieActivity();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        view = inflater.inflate(R.layout.activity_jedzenie, container,false);
        addListenerOnButtonStworz();
        return view;
    }

    public void addListenerOnButtonStworz(){

        rodzajJedzenia = (Spinner) view.findViewById(R.id.rodzaj_jedzenia);
        rodzajFrytek = (Spinner) view.findViewById(R.id.rodzaj_frytek);
        rodzajNapoju = (Spinner) view.findViewById(R.id.rodzaj_napoju);

        stworz = (Button) view.findViewById(R.id.stworz);
        nowyzestaw = (TextView) view.findViewById(R.id.zestaw);

        stworz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stworz = (Button) view.findViewById(R.id.stworz);
                String jedzenie = String.valueOf(rodzajJedzenia.getSelectedItem());
                String frytki = String.valueOf(rodzajFrytek.getSelectedItem());
                String napój = String.valueOf(rodzajNapoju.getSelectedItem());

                //Z burgerem
                Jedzenie zestaw = new Burger();
                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Brak")==0 && napój.compareTo("Brak")==0){
                    zestaw = new Burger(); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Małe")==0 && napój.compareTo("Brak")==0){
                    zestaw = new MałeFrytki(new Burger()); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Średnie")==0 && napój.compareTo("Brak")==0){
                    zestaw = new ŚrednieFrytki(new Burger()); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Duże")==0 && napój.compareTo("Brak")==0){
                    zestaw = new DużeFrytki(new Burger()); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Brak")==0 && napój.compareTo("Woda")==0){
                    zestaw = new Woda(new Burger()); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Brak")==0 && napój.compareTo("Napój gazowany")==0){
                    zestaw = new NapójGazowany(new Burger()); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Brak")==0 && napój.compareTo("Sok")==0){
                    zestaw = new Sok(new Burger()); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Małe")==0 && napój.compareTo("Woda")==0){
                    zestaw = new Woda(new MałeFrytki(new Burger())); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Małe")==0 && napój.compareTo("Napój gazowany")==0){
                    zestaw = new NapójGazowany(new MałeFrytki(new Burger())); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Małe")==0 && napój.compareTo("Sok")==0){
                    zestaw = new Sok(new MałeFrytki(new Burger())); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Średnie")==0 && napój.compareTo("Woda")==0){
                    zestaw = new Woda(new ŚrednieFrytki(new Burger())); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Średnie")==0 && napój.compareTo("Napój gazowany")==0){
                    zestaw = new NapójGazowany(new ŚrednieFrytki(new Burger())); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Średnie")==0 && napój.compareTo("Sok")==0){
                    zestaw = new Sok(new ŚrednieFrytki(new Burger())); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Duże")==0 && napój.compareTo("Woda")==0){
                    zestaw = new Woda(new DużeFrytki(new Burger())); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Duże")==0 && napój.compareTo("Napój gazowany")==0){
                    zestaw = new NapójGazowany(new DużeFrytki(new Burger())); }

                if(jedzenie.compareTo("Burger")==0 && frytki.compareTo("Duże")==0 && napój.compareTo("Sok")==0){
                    zestaw = new Sok(new DużeFrytki(new Burger())); }



                //Z kanapką
                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Brak")==0 && napój.compareTo("Brak")==0){
                    zestaw = new Kanapka(); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Małe")==0 && napój.compareTo("Brak")==0){
                    zestaw = new MałeFrytki(new Kanapka()); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Średnie")==0 && napój.compareTo("Brak")==0){
                    zestaw = new ŚrednieFrytki(new Kanapka()); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Duże")==0 && napój.compareTo("Brak")==0){
                    zestaw = new DużeFrytki(new Kanapka()); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Brak")==0 && napój.compareTo("Woda")==0){
                    zestaw = new Woda(new Kanapka()); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Brak")==0 && napój.compareTo("Napój gazowany")==0){
                    zestaw = new NapójGazowany(new Kanapka()); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Brak")==0 && napój.compareTo("Sok")==0){
                    zestaw = new Sok(new Kanapka()); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Małe")==0 && napój.compareTo("Woda")==0){
                    zestaw = new Woda(new MałeFrytki(new Kanapka())); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Małe")==0 && napój.compareTo("Napój gazowany")==0){
                    zestaw = new NapójGazowany(new MałeFrytki(new Kanapka())); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Małe")==0 && napój.compareTo("Sok")==0){
                    zestaw = new Sok(new MałeFrytki(new Kanapka())); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Średnie")==0 && napój.compareTo("Woda")==0){
                    zestaw = new Woda(new ŚrednieFrytki(new Kanapka())); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Średnie")==0 && napój.compareTo("Napój gazowany")==0){
                    zestaw = new NapójGazowany(new ŚrednieFrytki(new Kanapka())); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Średnie")==0 && napój.compareTo("Sok")==0){
                    zestaw = new Sok(new ŚrednieFrytki(new Kanapka())); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Duże")==0 && napój.compareTo("Woda")==0){
                    zestaw = new Woda(new DużeFrytki(new Kanapka())); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Duże")==0 && napój.compareTo("Napój gazowany")==0){
                    zestaw = new NapójGazowany(new DużeFrytki(new Kanapka())); }

                if(jedzenie.compareTo("Kanapka")==0 && frytki.compareTo("Duże")==0 && napój.compareTo("Sok")==0){
                    zestaw = new Sok(new DużeFrytki(new Kanapka())); }

                nowyzestaw.setText("Twój zestaw" + "\nSklad: " + zestaw.Opis() + "\nCena: " + zestaw.Cena() + "zł");
            }
        });
    }
}

