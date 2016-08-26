package com.xinglefly;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewStub;

import com.xinglefly.event.NetWorkEvent;
import com.xinglefly.module.picture.PictureFragment;
import com.xinglefly.module.shoot.ShootFragment;
import com.xinglefly.module.skill.TechnologyFragment;
import com.xinglefly.module.test.TestFragment;
import com.xinglefly.util.PreferenceUtil;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.net_err) ViewStub netErr;
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
                    case 3:return new TestFragment();
                    default:return new PictureFragment();
                }
            }

            @Override
            public int getCount() {return 4;}

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:return getString(R.string.picture);
                    case 1:return getString(R.string.shoot);
                    case 2:return getString(R.string.skill);
                    case 3:return getString(R.string.shoot);
                    default:return getString(R.string.picture);
                }
            }
        });
        tabs.setupWithViewPager(viewPager);
    }


    @Subscribe
    public void showNetErr(NetWorkEvent event){
        if (event.isNetwork()){
            netErr.setVisibility(View.GONE);
            PreferenceUtil.getInstance(mContext).setIsNetWork(false);
        } else{
            netErr.setVisibility(View.VISIBLE);
            PreferenceUtil.getInstance(mContext).setIsNetWork(true);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (PreferenceUtil.getInstance(mContext).isNetwork()) netErr.setVisibility(View.VISIBLE);
        else netErr.setVisibility(View.GONE);
    }

}
