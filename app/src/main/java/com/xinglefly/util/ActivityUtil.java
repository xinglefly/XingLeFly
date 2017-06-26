package com.xinglefly.util;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.xinglefly.R;


@SuppressWarnings("unused")
public final class ActivityUtil {
    public static void startActivity(Activity activity, Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_in_right, R.anim.push_out_left);
    }

    public static void finishActivity(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.push_in_left, R.anim.push_out_right);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int flag) {
//        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        activity.startActivityForResult(intent, flag);
        activity.overridePendingTransition(R.anim.push_in_right, R.anim.push_out_left);
    }

    public static void startActivityForResult(Activity activity, Fragment fragment, Intent intent, int flag) {
//        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        fragment.startActivityForResult(intent, flag);
        activity.overridePendingTransition(R.anim.push_in_right, R.anim.push_out_left);
    }

    public static void startToLoginActivity(Activity activity) {
//        Intent intent = new Intent(activity, LoginActivity.class);
//        startActivity(activity, intent);
    }

    public static void startLoginActivityForResult(Activity activity, int flag) {
//        Intent intent = new Intent(activity, LoginActivity.class);
//        startActivityForResult(activity, intent, flag);
    }



}
