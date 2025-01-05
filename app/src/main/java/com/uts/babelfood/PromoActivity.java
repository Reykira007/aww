package com.uts.babelfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PromoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewPromo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchPromoData();
    }

    private void fetchPromoData() {
        PromoApi promoApi = RetrofitClient.getRetrofitInstance().create(PromoApi.class);
        Call<List<Promo>> call = promoApi.getPromoByKategori("Promo");

        call.enqueue(new Callback<List<Promo>>() {
            @Override
            public void onResponse(Call<List<Promo>> call, Response<List<Promo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Promo> promoList = response.body();
                    PromoAdapter adapter = new PromoAdapter(PromoActivity.this, promoList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Promo>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
