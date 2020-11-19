package com.crystallake.statusbarutil.utils;

import android.os.Build;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;

public class DarkModeUtils {

    public static boolean isDarkIconMode(@NonNull Window window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int ui = window.getDecorView().getSystemUiVisibility();
            final int flag = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            return flag == (flag & ui);
        }
        return false;
    }

    public static void setDarkIconMode(@NonNull Window window, boolean darkIconMode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int ui = window.getDecorView().getSystemUiVisibility();
            if (darkIconMode) {
                window.getDecorView().setSystemUiVisibility(ui | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                window.getDecorView().setSystemUiVisibility(ui & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }
}