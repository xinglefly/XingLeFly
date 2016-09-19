package com.xinglefly;

import android.app.Fragment;
import android.os.Bundle;

import com.xinglefly.event.NetWorkEvent;
import com.xinglefly.util.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import rx.Subscription;

public class BaseFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XingLeApp.RegisterEventBus(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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