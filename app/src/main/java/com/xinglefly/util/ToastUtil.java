package com.xinglefly.util;

import android.widget.Toast;
import com.xinglefly.XingLeApp;

public class ToastUtil {
    public static void showToast(String message, Object... args) {
        if(args != null) message = String.format(message, args);
        Toast.makeText(XingLeApp.getInstance(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(String message, Object... args) {
        if(args != null) message = String.format(message, args);
        Toast.makeText(XingLeApp.getInstance(), message, Toast.LENGTH_SHORT).show();
    }
}
