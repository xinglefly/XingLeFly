package com.xinglefly;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.xinglefly.module.map.MapFragment;
import com.xinglefly.module.shoot.ShootFragment;
import com.xinglefly.module.skill.TechnologyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolBar) Toolbar toolbar;
    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(android.R.id.tabs) TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        setSupportActionBar(toolbar);
        setViewPagerData();
    }

    private void setViewPagerData() {
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:return new MapFragment();
                    case 1:return new ShootFragment();
                    case 2:return new TechnologyFragment();
                    default:return new MapFragment();
                }
            }

            @Override
            public int getCount() {return 3;}

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:return getString(R.string.picture);
                    case 1:return getString(R.string.shoot);
                    case 2:return getString(R.string.skill);
                    default:return getString(R.string.picture);
                }
            }
        });
        tabs.setupWithViewPager(viewPager);
    }

}
