package com.xinglefly;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xinglefly.event.NetWorkEvent;
import org.greenrobot.eventbus.Subscribe;

import rx.Subscription;

public  class  BaseActivity extends AppCompatActivity{

    protected Subscription subscription;
    protected Context mContext;

    public void unSubscrib(){
        if (subscription!=null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

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
        unSubscrib();
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