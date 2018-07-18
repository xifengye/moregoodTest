package com.moregood.moregood.log_printer;

/**
 * Created by yexifeng on 2018/7/18.
 */

public interface LogPrinterListener {
    void onStartLoop();

    void onEndLoop(String logInfo, int level);
}
