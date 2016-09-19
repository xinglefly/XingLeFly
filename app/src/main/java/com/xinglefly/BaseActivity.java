package com.xinglefly;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xinglefly.event.NetWorkEvent;
import org.greenrobot.eventbus.Subscribe;

import rx.Subscription;

public  class  BaseActivity extends AppCompatActivity{

    protected Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XingLeApp.RegisterEventBus(this);
        mContext = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XingLeApp.unRegisterEventBus(this);
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

}