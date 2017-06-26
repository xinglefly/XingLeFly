package com.xinglefly;

import android.app.Application;
import com.xinglefly.util.LogUtil;
import org.greenrobot.eventbus.EventBus;

public class XingLeApp extends Application{

    private static XingLeApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        LogUtil.init(true);
    }

    public static XingLeApp getInstance(){
        return mInstance;
    }


    public static void postEvent(Object event){
        EventBus.getDefault().post(event);
    }
}