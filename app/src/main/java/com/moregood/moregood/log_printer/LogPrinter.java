package com.moregood.moregood.log_printer;

import android.util.Printer;

import com.moregood.utils.DebugUtil;

/**
 * Created by yexifeng on 2018/7/18.
 */

public class LogPrinter implements Printer,UiPerfMonitorConfig {
    public static final String TAG = "LogPrinter";
    private LogPrinterListener mLogPrinterListener = null;
    private long startTime = 0;

    public LogPrinter(LogPrinterListener listener) {
        this.mLogPrinterListener = listener;
    }

    @Override
    public void println(String logInfo) {
        if(startTime<=0){
            startTime = System.currentTimeMillis();
            mLogPrinterListener.onStartLoop();
        }else{
            long time = System.currentTimeMillis() - startTime;
            DebugUtil.debug(TAG,"dispatch handler time:%d",time);
            execuTime(logInfo,time);
            startTime = 0;
        }
    }

    private void execuTime(String logInfo,long time){
        int level = 0;
        if(time>TIME_WARNING_LEVEL_2){
            DebugUtil.error(TAG,"waring_Level_2:\r\nprintln:%s",logInfo);
            level = TIME_WARNING_LEVEL_2;
        }else if(time>TIME_WARNING_LEVEL_1){
            DebugUtil.error(TAG,"waring_Level_1:\r\nprintln:%s",logInfo);
            level = TIME_WARNING_LEVEL_1;
        }
        mLogPrinterListener.onEndLoop(logInfo,level);
    }


}
