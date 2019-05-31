package com.ljr.player;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Player implements SurfaceHolder.Callback {
    static {
        System.loadLibrary("ljrplayer");
    }
private SurfaceHolder mSurfaceHolder;

    public void setSurfaceView(SurfaceView surfaceView) {
        if (null != this.mSurfaceHolder) {
            this.mSurfaceHolder.removeCallback(this);
        }
        this.mSurfaceHolder = surfaceView.getHolder();
        this.mSurfaceHolder.addCallback(this);
    }
    public void start(String path) {
        native_start(path,mSurfaceHolder.getSurface());
    }

    public native void native_start(String path, Surface surface);

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.mSurfaceHolder = holder;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
