package com.moregood.moregood;

import android.app.Application;
import android.content.Context;

import com.moregood.moregood.time_monitor.TimeMonitorConfig;
import com.moregood.moregood.time_monitor.TimeMonitorMgr;

/**
 * Created by yexifeng on 2018/7/18.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mContext = this;
        TimeMonitorMgr.getInstance().resetTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START);
    }

    public static Context getContext() {
        return mContext;
    }
}
