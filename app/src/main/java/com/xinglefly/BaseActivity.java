package com.xinglefly;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xinglefly.event.NetWorkEvent;
import com.xinglefly.module.view.TopTitleView;
import com.xinglefly.util.ActivityController;
import com.xinglefly.util.ActivityUtil;
import org.greenrobot.eventbus.Subscribe;


public  class  BaseActivity extends AppCompatActivity{

    private ViewGroup mRootLayout;
    protected TopTitleView mTopTitleView;
    protected BaseActivity baseContext = BaseActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XingLeApp.RegisterEventBus(this);
        ActivityController.add(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (showTitleBar()) {
            mRootLayout = (ViewGroup) View.inflate(this, R.layout.activity_base, null);
            View child = View.inflate(this, layoutResID, null);
            if (mRootLayout == null) {
                super.setContentView(layoutResID);
                return;
            }
            mTopTitleView = (TopTitleView) mRootLayout.findViewById(R.id.title_view);
            mRootLayout.addView(child, new LinearLayout.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT));
            mTopTitleView.setOnBackClickLitener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onBack();
                }
            });
            super.setContentView(mRootLayout);
        } else {
            super.setContentView(layoutResID);
        }

    }

    protected void setTitle(String title) {
        if (mTopTitleView != null) {
            mTopTitleView.setTitle(title);
        }
    }

    protected void onBack() {
        ActivityUtil.finishActivity(baseContext);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        XingLeApp.unRegisterEventBus(this);
        ActivityController.remove(this);
    }


    @Subscribe
    public void showNetErr(NetWorkEvent event){
        try {
            if (event==null)
                throw new Exception("event is null");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean showTitleBar() {
        return false;
    }

}