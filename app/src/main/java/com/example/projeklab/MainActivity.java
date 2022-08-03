package com.example.projeklab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    TextView tvError;
    Button btnSubmit;

    void init() {
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        tvError = findViewById(R.id.tv_error);
        btnSubmit = findViewById(R.id.btn_submit);
    }

    boolean validateEmail(String email) {
        if(!email.endsWith("com")) return false;
        else if(!email.contains("@")) return false;
        //email yg sebelahnya @ sama . blom
//        else if(!email.)
        return true;
    }

    boolean validatePassword(String password) {
        if(!password.matches("^[a-zA-Z0-9]*$")) return false;
        return true;
    }

    void submit() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etEmail.getText().length() == 0) {
                    tvError.setText("Email field must not blank");
                    tvError.setBackgroundResource(R.color.error_bg);
                    tvError.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvError.setText("");
                            tvError.setBackgroundResource(R.color.bg);
                        }
                    }, 5000);
                } else if(etPassword.getText().length() == 0) {
                    tvError.setText("Password field must not blank");
                    tvError.setBackgroundResource(R.color.error_bg);
                    tvError.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvError.setText("");
                            tvError.setBackgroundResource(R.color.bg);
                        }
                    }, 5000);
                } else if(!validateEmail(etEmail.getText().toString())) {
                    tvError.setText("Must be a validate email address");
                    tvError.setBackgroundResource(R.color.error_bg);
                    tvError.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvError.setText("");
                            tvError.setBackgroundResource(R.color.bg);
                        }
                    }, 5000);
                } else if(!validatePassword(etPassword.getText().toString())) {
                    tvError.setText("Password must be alphanumeric");
                    tvError.setBackgroundResource(R.color.error_bg);
                    tvError.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvError.setText("");
                            tvError.setBackgroundResource(R.color.bg);
                        }
                    }, 5000);
                } else {
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    String substring = etEmail.getText().toString().substring(0, etEmail.getText().toString().indexOf("@"));
                    intent.putExtra("username", substring);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        submit();
    }
}