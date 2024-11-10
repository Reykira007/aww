package com.uts.babelfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText emailEditText, passwordEditText;
    private MaterialButton loginButton;
    private TextView registerLink, forgotPasswordLink;

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerLink = findViewById(R.id.registerLink);
        forgotPasswordLink = findViewById(R.id.forgotPasswordLink);

        loginButton.setOnClickListener(v -> {
            String username = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (validateLogin(username, password)) {
                Toast.makeText(LoginActivity.this, "Login Berhasil!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        registerLink.setOnClickListener(v -> {
            Toast.makeText(LoginActivity.this, "Fitur Register belum tersedia", Toast.LENGTH_SHORT).show();
        });

        forgotPasswordLink.setOnClickListener(v -> {
            Toast.makeText(LoginActivity.this, "Fitur Lupa Password belum tersedia", Toast.LENGTH_SHORT).show();
        });
    }

    private boolean validateLogin(String username, String password) {
        if (username.isEmpty()) {
            emailEditText.setError("Username tidak boleh kosong");
            return false;
        }

        if (password.isEmpty()) {
            passwordEditText.setError("Password tidak boleh kosong");
            return false;
        }

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            return true;
        } else {
            Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}