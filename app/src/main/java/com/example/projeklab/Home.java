package com.example.projeklab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvUsername;
    Bundle extras;

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;

    void init() {
        extras = getIntent().getExtras();
        tvUsername = findViewById(R.id.tv_username);
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
    }

    void setUpDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }

    void changeName() {
        tvUsername.setText(extras.getString("username").toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        changeName();
        setUpDrawer();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                finish();
//                Intent intentHome = new Intent(this, Home.class);
                startActivity(getIntent());
                break;

            case R.id.nav_log_out:
                Intent intentLogout = new Intent(this, MainActivity.class);
                startActivity(intentLogout);
                finish();
        }
        return false;
    }
}