package com.example.myproject.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Koszyk;
import com.example.myproject.Produkt;
import com.example.myproject.ProduktViewModel;
import com.example.myproject.R;
import com.example.myproject.databinding.FragmentNewOrderBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentNewOrderBinding binding;
    private ProduktViewModel produktViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        //int index = 1;
        //if (getArguments() != null) {
          //  index = getArguments().getInt(ARG_SECTION_NUMBER);
        //}
        //pageViewModel.setIndex(index);
        produktViewModel = ViewModelProviders.of(this).get(ProduktViewModel.class);
       // koszyk = new Koszyk();

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentNewOrderBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.recycler_view);
        //recyclerView.findViewById(R.id.recycler_view);
        final ProductAdapter adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        produktViewModel.findAll().observe(getViewLifecycleOwner(), new Observer<List<Produkt>>() {
            @Override
            public void onChanged(List<Produkt> produkts) {
                adapter.setProdukty(produkts);
            }
        });
        return recyclerView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private class ProductHolder extends RecyclerView.ViewHolder{
        private TextView productNameTextView;
        private TextView productPriceTextView;
        final Button addButton;

        public ProductHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.product_list_item, parent, false));
            View view = inflater.inflate(R.layout.product_list_item, parent, false);
            productNameTextView = itemView.findViewById(R.id.product_name);
            productPriceTextView = itemView.findViewById(R.id.product_price);

           // productOpisTextView = itemView.findViewById(R.id.product_opis);
            //addButton = itemView.findViewById(R.id.buttonDoKoszyka);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(itemView.findViewById(R.id.card_view),getString(productNameTextView), Snackbar.LENGTH_LONG).show();
                }
            });*/
            /*addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //dodaj do koszyka
                }
            });*/
            addButton = itemView.findViewById(R.id.buttonDoKoszyka);
            addButton.setEnabled(true);

        }


        public void bind(Produkt produkt){
            productNameTextView.setText(produkt.getNazwa());
            productPriceTextView.setText(produkt.getCena()+"zł");
           // productOpisTextView.setText(produkt.getOpis());
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(itemView.findViewById(R.id.card_view),getText(produkt.getOpis()), Snackbar.LENGTH_LONG).show();
                }
            });*/

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Koszyk.Add(produkt);
                    addButton.setEnabled(false);
                }
            });
        }
    }

    private class ProductAdapter extends RecyclerView.Adapter<ProductHolder>{
        private List<Produkt> produkty;

        @NonNull
        @Override
        public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            return new ProductHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductHolder holder, int position){
            if(produkty != null){
                Produkt produkt = produkty.get(position);
                holder.bind(produkt);
            }
            else{
                Log.d("PlaceholderFragment", "no products");
            }
        }

        @Override
        public int getItemCount(){
            if(produkty != null){
                return produkty.size();
            }
            else{
                return 0;
            }
        }

        void setProdukty(List<Produkt> produkty){
            this.produkty = produkty;
            notifyDataSetChanged();
        }
    }
}