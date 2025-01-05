package com.uts.babelfood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddInformationActivity extends AppCompatActivity {

    private TextInputEditText emailEditText, komentarEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_information);

        emailEditText = findViewById(R.id.emailEditText);
        komentarEditText = findViewById(R.id.komentarEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> submitInformation());
    }

    private void submitInformation() {
        String email = emailEditText.getText() != null ? emailEditText.getText().toString().trim() : "";
        String komentar = komentarEditText.getText() != null ? komentarEditText.getText().toString().trim() : "";

        if (email.isEmpty()) {
            emailEditText.setError("Email tidak boleh kosong");
            emailEditText.requestFocus();
            return;
        }

        if (komentar.isEmpty()) {
            komentarEditText.setError("Komentar tidak boleh kosong");
            komentarEditText.requestFocus();
            return;
        }

        InformationApi api = RetrofitClient.getRetrofitInstance().create(InformationApi.class);
        Call<ResponseMessage> call = api.addInformation(email, komentar);

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().isSuccess()) {
                        Toast.makeText(AddInformationActivity.this, "Informasi berhasil dikirim!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddInformationActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(AddInformationActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddInformationActivity.this, "Gagal mengirim informasi. Coba lagi nanti.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(AddInformationActivity.this, "Terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
