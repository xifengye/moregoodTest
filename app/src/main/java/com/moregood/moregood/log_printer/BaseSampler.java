package com.moregood.moregood.log_printer;

import android.os.Handler;
import android.os.HandlerThread;

import com.moregood.utils.DebugUtil;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by yexifeng on 2018/7/18.
 * 定时采样
 */

public abstract class BaseSampler {
    public static final String TAG = "BaseSampler";
    private Handler mControlHandler = null;
    private static final int INTERVAL_TIME = 500;//ms采样间隔
    private AtomicBoolean mIsSampling = new AtomicBoolean(false);
    private java.lang.Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doSample();
            if(mIsSampling.get()){
                getControlHandler().postDelayed(this,INTERVAL_TIME);
            }
        }
    };

    public BaseSampler() {
        DebugUtil.debug("Init Base Sampler");
    }

    public void start() {
        if (!mIsSampling.get()) {
            DebugUtil.debug(TAG, "start Sampler");
            getControlHandler().removeCallbacks(mRunnable);
            getControlHandler().post(mRunnable);
            mIsSampling.set(true);
        }
    }

    public void stop(){
        if(mIsSampling.get()){
            DebugUtil.debug(TAG,"stop Sampler");
            getControlHandler().removeCallbacks(mRunnable);
            mIsSampling.set(false);
        }
    }

    public Handler getControlHandler() {
        if(mControlHandler == null){
            HandlerThread mht = new HandlerThread("samplerThread");
            mht.start();
            mControlHandler = new Handler(mht.getLooper());
        }
        return mControlHandler;
    }

    abstract void doSample();
}
