package com.xinglefly;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.xinglefly.module.picture.PictureFragment;
import com.xinglefly.module.shoot.ShootFragment;
import com.xinglefly.module.skill.TechnologyFragment;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(android.R.id.tabs) TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setViewPagerData();
    }

    private void setViewPagerData() {
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:return new PictureFragment();
                    case 1:return new ShootFragment();
                    case 2:return new TechnologyFragment();
                    default:return new PictureFragment();
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

    /*@Subscribe
    public void receiverEvent(Object event) {
        super.receiverEvent(event);
    }*/

}
