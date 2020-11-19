package com.crystallake.statusbarutil.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

import androidx.annotation.Nullable;

public class ContextUtils {

    @Nullable
    public static Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }
}