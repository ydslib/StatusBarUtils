package com.crystallake.statusbarutil;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.Nullable;

public class StatusBarCapture {

    private static StatusBarCapture sInstance = null;

    private Bitmap mBitmap = null;
    private Canvas mCanvas = null;

    public static StatusBarCapture get() {
        if (sInstance == null) {
            synchronized (StatusBarCapture.class) {
                if (sInstance == null) {
                    sInstance = new StatusBarCapture();
                }
            }
        }
        return sInstance;
    }

    public void recycle() {
        if (mCanvas != null) {
            mCanvas.setBitmap(null);
            mCanvas = null;
        }
        if (mBitmap != null) {
            mBitmap.recycle();
            mBitmap = null;
        }
        sInstance = null;
    }

    private boolean refresh(View decor) {
        int w = decor.getMeasuredWidth();
        if (w <= 0) return false;
        boolean dart = false;
        if (mBitmap == null) {
            dart = true;
        } else {
            if (mBitmap.isRecycled()) {
                dart = true;
            } else {
                if (mBitmap.getWidth() != w) {
                    dart = true;
                    mBitmap.recycle();
                }
            }
        }
        if (dart) {
            int h = StatusBarUtils.getHeight(decor.getContext());
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
            mCanvas = new Canvas(mBitmap);
        }
        return true;
    }

    @Nullable
    public Bitmap capture(View decor) {
        if (!refresh(decor)) return null;
        decor.draw(mCanvas);
        return mBitmap;
    }

}
