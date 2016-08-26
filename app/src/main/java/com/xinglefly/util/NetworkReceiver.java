package com.xinglefly.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.xinglefly.XingLeApp;
import com.xinglefly.event.NetWorkEvent;


public class NetworkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo activeInfo = manager.getActiveNetworkInfo();


        if (mobileInfo.isConnected()) {
            ToastUtil.showToast("温馨提示，手机网络会损失流量请连接附近wifi！");
            XingLeApp.postEvent(new NetWorkEvent(true));
        }else XingLeApp.postEvent(new NetWorkEvent(false));

        if (wifiInfo.isConnected()) XingLeApp.postEvent((new NetWorkEvent(true)));
        else XingLeApp.postEvent((new NetWorkEvent(false)));

    }
}