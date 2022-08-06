package com.example.projeklab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailItem extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvToolbar;

    void init() {
        toolbar = findViewById(R.id.toolbar);
        tvToolbar = findViewById(R.id.toolbar_text);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24);
        tvToolbar.setText("Item Detail");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        init();
    }
}