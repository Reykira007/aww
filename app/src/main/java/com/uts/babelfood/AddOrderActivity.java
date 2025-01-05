package com.uts.babelfood;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddOrderActivity extends AppCompatActivity {

    private TextView tvNamaMakanan, tvHargaMakanan, tvTotalHarga;
    private EditText etJumlah;
    private Button btnPesan;

    private int idMakanan;
    private String namaMakanan;
    private double hargaMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        tvNamaMakanan = findViewById(R.id.tvNamaMakanan);
        tvHargaMakanan = findViewById(R.id.tvHargaMakanan);
        tvTotalHarga = findViewById(R.id.tvTotalHarga);
        etJumlah = findViewById(R.id.etJumlah);
        btnPesan = findViewById(R.id.btnPesan);

        idMakanan = getIntent().getIntExtra("id_makanan", -1);
        namaMakanan = getIntent().getStringExtra("nama_makanan");
        hargaMakanan = getIntent().getDoubleExtra("harga_makanan", 0.0);

        tvNamaMakanan.setText(namaMakanan);
        tvHargaMakanan.setText("Rp " + hargaMakanan);

        etJumlah.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateTotalPrice();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        btnPesan.setOnClickListener(v -> submitOrder());
    }

    private void calculateTotalPrice() {
        String jumlahStr = etJumlah.getText().toString().trim();
        if (!jumlahStr.isEmpty()) {
            int jumlah = Integer.parseInt(jumlahStr);
            double totalHarga = jumlah * hargaMakanan;
            tvTotalHarga.setText("Rp " + totalHarga);
        } else {
            tvTotalHarga.setText("Rp 0");
        }
    }

    private void submitOrder() {
        String jumlahStr = etJumlah.getText().toString().trim();

        if (jumlahStr.isEmpty()) {
            Toast.makeText(this, "Jumlah tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            return;
        }

        int jumlah = Integer.parseInt(jumlahStr);
        double totalHarga = jumlah * hargaMakanan;

        String email = "user1@gmail.com";

        OrderApi orderApi = RetrofitClient.getRetrofitInstance().create(OrderApi.class);
        Call<ResponseMessage> call = orderApi.addOrder(idMakanan, email, jumlah, totalHarga);

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().isSuccess()) {
                        Toast.makeText(AddOrderActivity.this, "Pesanan berhasil dibuat!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddOrderActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddOrderActivity.this, "Gagal membuat pesanan. Coba lagi.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(AddOrderActivity.this, "Terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
