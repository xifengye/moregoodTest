package com.moregood.moregood.log_printer;

import android.os.Environment;

/**
 * Created by yexifeng on 2018/7/18.
 */

public interface UiPerfMonitorConfig{
    int TIME_WARNING_LEVEL_1 = 100;
    int TIME_WARNING_LEVEL_2 = 300;
    String LOG_PATH = Environment.getExternalStorageDirectory().getPath()+"moregood/uiperf";
}
