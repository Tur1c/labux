package com.example.projeklab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projeklab.adapter.ViewPagerAdapter;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvUsername;
    Bundle extras;

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    ViewPager viewPager;
    LinearLayout sliderDots;
    ViewPagerAdapter adapter;
    private int dotsCount;
    private ImageView[] dots;

    void init() {
        extras = getIntent().getExtras();
        tvUsername = findViewById(R.id.tv_username);
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);


        adapter = new ViewPagerAdapter(this);
        viewPager = findViewById(R.id.vp_image);
        viewPager.setAdapter(adapter);

        sliderDots = findViewById(R.id.slider_dots);
        dotsCount = adapter.getCount();
        dots = new ImageView[dotsCount];

        for(int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    void setUpDrawer() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
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