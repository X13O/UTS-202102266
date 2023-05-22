package com.fadlizainuddin.uts_202102266;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private MyFragmentPagerAdapter _myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout namaVariabel_tabLayout = findViewById(R.id.tabLayout);
        namaVariabel_tabLayout.addTab(namaVariabel_tabLayout.newTab().setText("Web Resmi"));
        namaVariabel_tabLayout.addTab(namaVariabel_tabLayout.newTab().setText("Web Internal"));
        namaVariabel_tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager namaVariabel_viewPager = findViewById(R.id.viewPager);

        _myFragmentPagerAdapter = new MyFragmentPagerAdapter(this, getSupportFragmentManager(), namaVariabel_tabLayout.getTabCount());
        namaVariabel_viewPager.setAdapter(_myFragmentPagerAdapter);
        namaVariabel_viewPager.setOffscreenPageLimit(2);

        namaVariabel_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(namaVariabel_tabLayout));

        namaVariabel_tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                namaVariabel_viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}