package com.uts.babelfood;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestMenuActivity extends AppCompatActivity {

    private EditText etNamaMenu, etDeskripsiMenu, etEmail, etPerkiraanHarga, etAlasanRequest;
    private Spinner spinnerJenisMenu;
    private Button btnSubmitRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_menu);

        // Initialize views
        etNamaMenu = findViewById(R.id.etNamaMenu);
        etDeskripsiMenu = findViewById(R.id.etDeskripsiMenu);
        spinnerJenisMenu = findViewById(R.id.spinnerJenisMenu);
        etEmail = findViewById(R.id.etEmail);
        etPerkiraanHarga = findViewById(R.id.etPerkiraanHarga);
        etAlasanRequest = findViewById(R.id.etAlasanRequest);
        btnSubmitRequest = findViewById(R.id.btnSubmitRequest);

        btnSubmitRequest.setOnClickListener(v -> {
            String namaMenu = etNamaMenu.getText().toString().trim();
            String deskripsiMenu = etDeskripsiMenu.getText().toString().trim();
            String jenisMenu = spinnerJenisMenu.getSelectedItem().toString();
            String email = etEmail.getText().toString().trim();
            String perkiraanHarga = etPerkiraanHarga.getText().toString().trim();
            String alasanRequest = etAlasanRequest.getText().toString().trim();

            if (namaMenu.isEmpty() || deskripsiMenu.isEmpty() || email.isEmpty() || perkiraanHarga.isEmpty() || alasanRequest.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show();
                return;
            }

            submitRequestMenu(namaMenu, deskripsiMenu, jenisMenu, email, perkiraanHarga, alasanRequest);
        });
    }

    private void submitRequestMenu(String namaMenu, String deskripsiMenu, String jenisMenu, String email, String perkiraanHarga, String alasanRequest) {
        RequestMenuApi api = RetrofitClient.getRetrofitInstance().create(RequestMenuApi.class);
        Call<ResponseMessage> call = api.addRequestMenu(namaMenu, deskripsiMenu, jenisMenu, email, Double.parseDouble(perkiraanHarga), alasanRequest, null);

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(RequestMenuActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    finish(); // Close activity
                } else {
                    Toast.makeText(RequestMenuActivity.this, "Gagal mengirim request", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(RequestMenuActivity.this, "Terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
