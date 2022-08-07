package com.example.projeklab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    TextView tvError;
    Button btnSubmit;
    int x,y;

    void init() {
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        tvError = findViewById(R.id.tv_error);
        btnSubmit = findViewById(R.id.btn_submit);
    }

    boolean validateEmail(String email) {
        if(!email.endsWith("com")) return false;
        else if(!email.contains("@")) return false;
        else{
            x = email.lastIndexOf("@");
            y = email.lastIndexOf(".");
//            Log.d("DEBUG", "index @: " + x + "index .: " + y);
            if(y - x == 1) return false;
        }
        return true;
    }

    boolean validatePassword(String password) {
        if(password.matches(".*[0-9].*") &&
                password.matches(".*[A-z].*")) return true;
        return false;
    }

    void submit() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etEmail.getText().length() == 0) {
                    tvError.setText("Email field must not blank");
                    tvError.setAlpha(1);
                    tvError.setVisibility(View.VISIBLE);
                    tvError.animate().alpha(0.0f).setDuration(5000);
//                    tvError.setBackgroundResource(R.color.error_bg);
                    tvError.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvError.setText("");
                            tvError.setVisibility(View.INVISIBLE);
                            tvError.setVisibility(View.GONE);
//                            tvError.setBackgroundResource(R.color.bg);
                        }
                    }, 5000);
                } else if(etPassword.getText().length() == 0) {
                    tvError.setText("Password field must not blank");
                    tvError.setAlpha(1);
                    tvError.setVisibility(View.VISIBLE);
                    tvError.animate().alpha(0.0f).setDuration(5000);
//                    tvError.setBackgroundResource(R.color.error_bg);
                    tvError.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvError.setText("");
                            tvError.setVisibility(View.INVISIBLE);
                            tvError.setVisibility(View.GONE);
//                            tvError.setBackgroundResource(R.color.bg);
                        }
                    }, 5000);
                } else if(!validateEmail(etEmail.getText().toString())) {
                    if(y - x == 1){
                        tvError.setText("@ and . should not adjacent each other");
                    }
                    else{
                        tvError.setText("Must be a validate email address");
                    }
                    tvError.setAlpha(1);
                    tvError.setVisibility(View.VISIBLE);
                    tvError.animate().alpha(0.0f).setDuration(5000);
//                    tvError.setBackgroundResource(R.color.error_bg);
                    tvError.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvError.setText("");
                            tvError.setVisibility(View.INVISIBLE);
                            tvError.setVisibility(View.GONE);
//                            tvError.setBackgroundResource(R.color.bg);
                        }
                    }, 5000);
                } else if(!validatePassword(etPassword.getText().toString())) {
                    tvError.setText("Password must be alphanumeric");
                    tvError.setAlpha(1);
                    tvError.setVisibility(View.VISIBLE);
                    tvError.animate().alpha(0.0f).setDuration(5000);
//                    tvError.setBackgroundResource(R.color.error_bg);
                    tvError.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvError.setText("");
                            tvError.setVisibility(View.INVISIBLE);
                            tvError.setVisibility(View.GONE);
//                            tvError.setBackgroundResource(R.color.bg);
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