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

public class AboutUs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    TextView toolBarTv;

    void init() {
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        toolBarTv = findViewById(R.id.toolbar_text);
        toolBarTv.setText("About Us");
    }

    void setUpDrawer() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        navView.setNavigationItemSelectedListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        init();
        setUpDrawer();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intentHome = new Intent(this, Home.class);
                startActivity(intentHome);
                finish();
                break;

            case R.id.nav_about_us:
                finish();
                startActivity(getIntent());
                break;

            case R.id.nav_log_out:
                Intent intentLogout = new Intent(this, MainActivity.class);
                startActivity(intentLogout);
                finish();
                break;
        }
        return false;
    }
}