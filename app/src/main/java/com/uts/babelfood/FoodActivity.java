package com.uts.babelfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewFood);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchFoodData();
    }

    private void fetchFoodData() {
        MakananApi makananApi = RetrofitClient.getRetrofitInstance().create(MakananApi.class);
        Call<List<Makanan>> call = makananApi.getMakananByKategori("Makanan");

        call.enqueue(new Callback<List<Makanan>>() {
            @Override
            public void onResponse(Call<List<Makanan>> call, Response<List<Makanan>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Makanan> makananList = response.body();
                    MakananAdapter adapter = new MakananAdapter(FoodActivity.this, makananList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Makanan>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}