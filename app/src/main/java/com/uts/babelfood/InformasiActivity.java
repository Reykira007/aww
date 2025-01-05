package com.uts.babelfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformasiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);

        recyclerView = findViewById(R.id.recyclerViewInformation);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchInformation();

        findViewById(R.id.fabAddInformation).setOnClickListener(v -> {
            Intent intent = new Intent(InformasiActivity.this, AddInformationActivity.class);
            startActivity(intent);
        });
    }

    private void fetchInformation() {
        InformationApi api = RetrofitClient.getRetrofitInstance().create(InformationApi.class);
        Call<List<Information>> call = api.getInformation();

        call.enqueue(new Callback<List<Information>>() {
            @Override
            public void onResponse(Call<List<Information>> call, Response<List<Information>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Information> informationList = response.body();
                    InformationAdapter adapter = new InformationAdapter(InformasiActivity.this, informationList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(InformasiActivity.this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Information>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(InformasiActivity.this, "Terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
