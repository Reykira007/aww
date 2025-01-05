package com.uts.babelfood;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddResepActivity extends AppCompatActivity {

    private EditText etNamaResep, etDeskripsi, etBahan, etLangkahPersiapan, etWaktuPersiapan, etTingkatKesulitan, etGambar;
    private Button btnTambahResep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resep);

        // Initialize views
        etNamaResep = findViewById(R.id.etNamaResep);
        etDeskripsi = findViewById(R.id.etDeskripsi);
        etBahan = findViewById(R.id.etBahan);
        etLangkahPersiapan = findViewById(R.id.etLangkahPersiapan);
        etWaktuPersiapan = findViewById(R.id.etWaktuPersiapan);
        etTingkatKesulitan = findViewById(R.id.etTingkatKesulitan);
        etGambar = findViewById(R.id.etGambar);
        btnTambahResep = findViewById(R.id.btnTambahResep);

        // Button click listener
        btnTambahResep.setOnClickListener(v -> tambahResep());
    }

    private void tambahResep() {
        String namaResep = etNamaResep.getText().toString().trim();
        String deskripsi = etDeskripsi.getText().toString().trim();
        String bahan = etBahan.getText().toString().trim();
        String langkahPersiapan = etLangkahPersiapan.getText().toString().trim();
        String waktuPersiapanStr = etWaktuPersiapan.getText().toString().trim();
        String tingkatKesulitan = etTingkatKesulitan.getText().toString().trim();
        String gambar = etGambar.getText().toString().trim();

        if (namaResep.isEmpty() || deskripsi.isEmpty() || bahan.isEmpty() || langkahPersiapan.isEmpty() || waktuPersiapanStr.isEmpty() || tingkatKesulitan.isEmpty()) {
            Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show();
            return;
        }

        int waktuPersiapan = Integer.parseInt(waktuPersiapanStr);

        // Call API
        ResepApi resepApi = RetrofitClient.getRetrofitInstance().create(ResepApi.class);
        Call<ResponseMessage> call = resepApi.addResep(namaResep, deskripsi, bahan, langkahPersiapan, waktuPersiapan, tingkatKesulitan, gambar);

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(AddResepActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    if (response.body().isSuccess()) {
                        finish(); // Close activity on success
                    }
                } else {
                    Toast.makeText(AddResepActivity.this, "Gagal menambahkan resep", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(AddResepActivity.this, "Terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
