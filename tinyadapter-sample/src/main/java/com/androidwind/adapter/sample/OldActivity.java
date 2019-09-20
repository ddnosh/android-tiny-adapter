package com.androidwind.adapter.sample;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class OldActivity extends AppCompatActivity {

    private ViewPager vp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(1, getSupportFragmentManager());//实例化adapter，得到fragment
        vp = findViewById(R.id.viewpager);
        vp.setAdapter(fragmentAdapter);//建立连接
        final BottomNavigationView bottom = findViewById(R.id.bottom);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {//底部导航栏点击事件
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.tab2:
                        vp.setCurrentItem(1);
                        break;
                }
                return true;
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottom.getMenu().getItem(position).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}