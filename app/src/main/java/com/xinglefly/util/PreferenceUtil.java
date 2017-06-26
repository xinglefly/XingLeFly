package com.xinglefly.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil {

    public static final String PREFERENCE_NAME = "xinglefly_pre";

    private static PreferenceUtil mPreferenceUtils = null;
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor editor;

    private PreferenceUtil(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public static PreferenceUtil getInstance(Context context) {
        if (mPreferenceUtils == null)
            mPreferenceUtils = new PreferenceUtil(context);
        return mPreferenceUtils;
    }


    public void setIsNetWork(boolean isNetwork){
        editor.putBoolean(Constants.NETWORK_STATUS,isNetwork).commit();
    }

    public boolean isNetwork(){
        return mSharedPreferences.getBoolean(Constants.NETWORK_STATUS,false);
    }


}
