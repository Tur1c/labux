package com.example.projeklab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projeklab.adapter.SliderAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static String username = "";

    TextView tvUsername;
    Bundle extras;
    Intent intent;

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    ViewPager viewPager;
    int images[] = {R.drawable.carousel1, R.drawable.carousel2, R.drawable.carousel3};
    LinearLayout sliderDots;
    private int dotsCount;
    private ImageView[] dots;
    ImageView iv_btn_1, iv_btn_2, iv_btn_3;
    ImageButton btnNext, btnPrev;
    int currentPageCounter = 0;

    void init() {
        extras = getIntent().getExtras();
        tvUsername = findViewById(R.id.tv_username);
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);
        Log.d("DEBUG", "init: " + navView.getCheckedItem());
        navView.setCheckedItem(R.id.nav_home);
        toolbar = findViewById(R.id.toolbar);

        iv_btn_1 = findViewById(R.id.btn_img_1);
        iv_btn_2 = findViewById(R.id.btn_img_2);
        iv_btn_3 = findViewById(R.id.btn_img_3);

        btnNext = findViewById(R.id.btn_next_image);
        btnPrev = findViewById(R.id.btn_prev_image);


        sliderDots = findViewById(R.id.slider_dots);
        dotsCount = images.length;
        dots = new ImageView[dotsCount];
        dots[0] = iv_btn_1;
        dots[1] = iv_btn_2;
        dots[2] = iv_btn_3;

        viewPager = findViewById(R.id.vp_image);
        viewPager.setAdapter(new SliderAdapter(images, Home.this));
    }

    void setUpDrawer() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        navView.setNavigationItemSelectedListener(this);
    }

    void changeName() {
        System.out.println(username);
        intent = getIntent();
        if(!intent.hasExtra("username")) tvUsername.setText(username);
        else {
            tvUsername.setText(extras.getString("username").toString());
            username = extras.getString("username").toString();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
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
                if(getItem(+1) >= dotsCount) viewPager.setCurrentItem(0, true);
                else viewPager.setCurrentItem(getItem(+1), true);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getItem(-1) < 0) viewPager.setCurrentItem(images.length, true);
                else viewPager.setCurrentItem(getItem(-1), true);
            }
        });
    }

    void changeImage() {
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPageCounter == images.length) currentPageCounter = 0;

                viewPager.setCurrentItem(currentPageCounter++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 1000, 5000);
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
        changeImage();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                finish();
//                Intent intentHome = new Intent(this, Home.class);
                startActivity(getIntent());
                break;

            case R.id.nav_about_us:
                Intent intentAbout = new Intent(Home.this, AboutUs.class);
                startActivity(intentAbout);
                finish();
                break;

            case R.id.nav_items:
                Intent intentItems = new Intent(Home.this, Items.class);
                startActivity(intentItems);
                finish();
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