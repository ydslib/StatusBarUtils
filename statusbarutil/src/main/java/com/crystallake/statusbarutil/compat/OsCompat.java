package com.crystallake.statusbarutil.compat;

import android.app.Activity;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public interface OsCompat {
    boolean isDarkIconMode(@NonNull Fragment fragment);
    boolean isDarkIconMode(@NonNull Activity activity);
    boolean isDarkIconMode(@NonNull Window window);
    void setDarkIconMode(@NonNull Fragment fragment, boolean darkIconMode);
    void setDarkIconMode(@NonNull Activity activity, boolean darkIconMode);
    void setDarkIconMode(@NonNull Window window, boolean darkIconMode);
}