package com.moregood.moregood.time_monitor;

import com.moregood.utils.DebugUtil;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by yexifeng on 2018/7/18.
 * 打点器
 */

public class TimeMonitor {
    private final String TAG = "TimeMonitor";
    private int monitorId = -1;
    private HashMap<String,Long> mTimeTag = new HashMap<>();
    private long mStartTime = 0;

    public TimeMonitor(int monitorId) {
        this.monitorId = monitorId;
    }

    public void startMoniter(){
        if(mTimeTag.size()>0){
            mTimeTag.clear();
        }
        mStartTime = System.currentTimeMillis();
    }

    public void recodingTimeTag(String tag){
        if(mTimeTag.get(tag)!=null){
            mTimeTag.remove(tag);
        }
        long time = System.currentTimeMillis() - mStartTime;
        mTimeTag.put(tag,time);
    }

    public void end(String tag,boolean writeLog){
        recodingTimeTag(tag);
        end(writeLog);
    }

    private void end(boolean writeLog) {
        if(writeLog){
            //写入到本地文件
        }
        testShowData();
    }

    private void testShowData() {
        if(mTimeTag.size()<=0){
            return;
        }
        Iterator<String> iterator = mTimeTag.keySet().iterator();
        while (iterator!=null && iterator.hasNext()){
            String tag = iterator.next();
            DebugUtil.debug(TAG,tag);
        }
    }

    public HashMap<String, Long> getTimeTags() {
        return mTimeTag;
    }
}
