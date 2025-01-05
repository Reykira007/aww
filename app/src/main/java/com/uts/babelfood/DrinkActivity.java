package com.uts.babelfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewDrink);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchDrinkData();
    }

    private void fetchDrinkData() {
        MinumanApi minumanApi = RetrofitClient.getRetrofitInstance().create(MinumanApi.class);
        Call<List<Minuman>> call = minumanApi.getMinumanByKategori("Minuman");

        call.enqueue(new Callback<List<Minuman>>() {
            @Override
            public void onResponse(Call<List<Minuman>> call, Response<List<Minuman>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Minuman> minumanList = response.body();
                    MinumanAdapter adapter = new MinumanAdapter(DrinkActivity.this, minumanList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Minuman>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
