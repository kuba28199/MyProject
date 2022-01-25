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
    TextView zestaw;
    String nazwa = "Własny zestaw";
    String opis = "opis";
    float cena = 5;

    private FragmentNewOrderBinding binding;;
    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    //private FragmentNewOrderBinding binding;
    private ProduktViewModel produktViewModel;

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

        return inflater.inflate(R.layout.activity_jedzenie, container,false);
    }

}

