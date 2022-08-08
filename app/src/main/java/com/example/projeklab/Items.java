package com.example.projeklab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.projeklab.adapter.FragmentAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Items extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    TextView toolBarTv;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;

    void init() {
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);
        navView.setCheckedItem(R.id.nav_items);
        toolbar = findViewById(R.id.toolbar);
        toolBarTv = findViewById(R.id.toolbar_text);
        toolBarTv.setText("Merchandise");
        toolBarTv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);

        viewPager2 = findViewById(R.id.vp_merchandise);
        tabLayout = findViewById(R.id.tabLayout);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Cloth"));
        tabLayout.addTab(tabLayout.newTab().setText("Album"));
        tabLayout.addTab(tabLayout.newTab().setText("Other"));
    }

    void setUpDrawer() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        navView.setNavigationItemSelectedListener(this);
    }

    void setUpTab() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        init();
        setUpDrawer();
        setUpTab();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intentHome = new Intent(Items.this, Home.class);
                startActivity(intentHome);
                finish();
                break;

            case R.id.nav_about_us:
                Intent intentAbout = new Intent(Items.this, AboutUs.class);
                startActivity(intentAbout);
                finish();
                break;

            case R.id.nav_items:
                finish();
                startActivity(getIntent());
                break;

            case R.id.nav_log_out:
                Intent intentLogout = new Intent(Items.this, MainActivity.class);
                startActivity(intentLogout);
                finish();
                break;
        }
        return false;
    }
}