package com.uts.babelfood.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uts.babelfood.Kategori;
import com.uts.babelfood.KategoriAdapter;
import com.uts.babelfood.KategoriApi;
import com.uts.babelfood.R;
import com.uts.babelfood.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView rvKategori;
    private KategoriAdapter kategoriAdapter;
    private List<Kategori> kategoriList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView
        rvKategori = view.findViewById(R.id.rvKategori);
        rvKategori.setLayoutManager(new GridLayoutManager(getContext(), 2)); // 2 columns

        // Initialize adapter and empty list
        kategoriList = new ArrayList<>();
        kategoriAdapter = new KategoriAdapter(getContext(), kategoriList);
        rvKategori.setAdapter(kategoriAdapter);

        // Fetch data from API
        fetchKategoriData();

        return view;
    }

    private void fetchKategoriData() {
        // Create Retrofit instance and call API
        KategoriApi kategoriApi = RetrofitClient.getRetrofitInstance().create(KategoriApi.class);
        Call<List<Kategori>> call = kategoriApi.getKategori();

        call.enqueue(new Callback<List<Kategori>>() {
            @Override
            public void onResponse(@NonNull Call<List<Kategori>> call, @NonNull Response<List<Kategori>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    kategoriList.clear(); // Clear old data
                    kategoriList.addAll(response.body()); // Add new data
                    kategoriAdapter.notifyDataSetChanged(); // Notify adapter
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Kategori>> call, @NonNull Throwable t) {
                // Handle error
                t.printStackTrace();
            }
        });
    }
}