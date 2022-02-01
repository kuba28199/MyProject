package com.example.myproject.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import com.example.myproject.Produkt;
import com.example.myproject.Zamowienie;
import com.example.myproject.ProduktViewModel;
import com.example.myproject.R;
import com.example.myproject.databinding.FragmentNewOrderBinding;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class OrderPlaceholder extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentNewOrderBinding binding;
    private ProduktViewModel produktViewModel;

    public static OrderPlaceholder newInstance(int index) {
        OrderPlaceholder fragment = new OrderPlaceholder();
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


    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentNewOrderBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.recycler_view);
        //recyclerView.findViewById(R.id.recycler_view);
        final OrderAdapter adapter = new OrderAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        produktViewModel.findAll().observe(getViewLifecycleOwner(), new Observer<List<Zamowienie>>() {
            @Override
            public void onChanged(List<Zamowienie> zamowienia) {
                adapter.setOrder(zamowienia);
            }
        });
        return recyclerView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public class OrderHolder extends RecyclerView.ViewHolder{
        private TextView orderNameTextView;
        private TextView orderStatusTextView;

        public OrderHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.order_list_item, parent, false));
            orderNameTextView = itemView.findViewById(R.id.order_name);
            orderStatusTextView = itemView.findViewById(R.id.order_status);
        }

        public void bind(Zamowienie order){
            orderNameTextView.setText(order.getIdentifier());
            orderStatusTextView.setText(order.getStatus());
        }
    }

    private class OrderAdapter extends RecyclerView.Adapter<OrderHolder>{
        private List<Zamowienie> zamowienia;

        @NonNull
        @Override
        public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            return new OrderHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull OrderHolder holder, int position){
            if(zamowienia != null){
                Zamowienie zamowienie = zamowienia.get(position);
                holder.bind(zamowienie);
            }
            else{
                Log.d("OrderPlaceholder", "brak zamowien");
            }
        }

        @Override
        public int getItemCount(){
            if(zamowienia != null){
                return zamowienia.size();
            }
            else{
                return 0;
            }
        }

        void setOrder(List<Zamowienie> zmaowienia){
            this.zamowienia = zamowienia;
            notifyDataSetChanged();
        }
    }
}