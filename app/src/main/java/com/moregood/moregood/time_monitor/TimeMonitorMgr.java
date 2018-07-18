package com.moregood.moregood.time_monitor;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by yexifeng on 2018/7/18.
 */

public class TimeMonitorMgr {
    private static TimeMonitorMgr mInstance = null;
    private static Context mContext = null;

    private HashMap<Integer,TimeMonitor> timeMonitorMap = null;

    public synchronized static TimeMonitorMgr getInstance() {
        if(mInstance==null){
            mInstance = new TimeMonitorMgr();
        }
        return mInstance;
    }

    public TimeMonitorMgr() {
        timeMonitorMap = new HashMap<>();
    }

    public void resetTimeMonitor(int id){
        if(timeMonitorMap.get(id)!=null){
            timeMonitorMap.remove(id);
        }
        TimeMonitor timeMonitor = getTimeMonitor(id);
        timeMonitor.startMoniter();
    }

    public TimeMonitor getTimeMonitor(int id) {
        TimeMonitor monitor = timeMonitorMap.get(id);
        if(monitor==null){
            monitor = new TimeMonitor(id);
            timeMonitorMap.put(id,monitor);
        }
        return monitor;
    }
}
