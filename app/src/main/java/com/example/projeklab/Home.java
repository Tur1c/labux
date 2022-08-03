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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projeklab.adapter.ViewPagerAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

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
    ImageView iv_btn_1, iv_btn_2, iv_btn_3;
    Button btnNext, btnPrev;
    int currentPageCounter = 0;

    void init() {
        extras = getIntent().getExtras();
        tvUsername = findViewById(R.id.tv_username);
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);

        iv_btn_1 = findViewById(R.id.btn_img_1);
        iv_btn_2 = findViewById(R.id.btn_img_2);
        iv_btn_3 = findViewById(R.id.btn_img_3);

        btnNext = findViewById(R.id.btn_next_image);
        btnPrev = findViewById(R.id.btn_prev_image);


        adapter = new ViewPagerAdapter(this);
        viewPager = findViewById(R.id.vp_image);
        viewPager.setAdapter(adapter);

        sliderDots = findViewById(R.id.slider_dots);
        dotsCount = adapter.getCount();
        dots = new ImageView[dotsCount];
        dots[0] = iv_btn_1;
        dots[1] = iv_btn_2;
        dots[2] = iv_btn_3;
    }

    void setUpDrawer() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        navView.setNavigationItemSelectedListener(this);
    }

    void changeName() {
        tvUsername.setText(extras.getString("username").toString());
    }

    void imageSlider() {
        for(int i = 0; i < dotsCount; i++) {
            dots[i].setBackgroundResource(R.drawable.non_active_dot);
        }
        dots[0].setBackgroundResource(R.drawable.active_dot);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i < dotsCount; i++) {
                    dots[i].setBackgroundResource(R.drawable.non_active_dot);
                }
                dots[position].setBackgroundResource(R.drawable.active_dot);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    void buttonClick() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getItem(+1), true);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getItem(-1), true);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        changeName();
        setUpDrawer();
        imageSlider();
        buttonClick();
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