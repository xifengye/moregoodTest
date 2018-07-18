package com.moregood.moregood.activity;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Printer;
import android.view.View;
import android.widget.Button;

import com.moregood.moregood.R;
import com.moregood.moregood.log_printer.LogPrinter;
import com.moregood.moregood.log_printer.LogPrinterListener;
import com.moregood.utils.DebugUtil;

public class LogPrinterActivity extends AppCompatActivity implements View.OnClickListener, LogPrinterListener {
    private Button btnStartMonitor;
    private Button btnStopMonitor;
    private Printer mLogPrinter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_printer);
        btnStartMonitor = findViewById(R.id.start_monitor);
        btnStopMonitor = findViewById(R.id.stop_monitor);
        btnStartMonitor.setOnClickListener(this);
        btnStopMonitor.setOnClickListener(this);
        mLogPrinter = new LogPrinter(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()  == R.id.start_monitor){
            startMonitor();
        }
        if(view.getId()  == R.id.stop_monitor){
            stopMonitor();
        }
    }

    private void startMonitor() {
        Looper.getMainLooper().setMessageLogging(mLogPrinter);
    }

    private void stopMonitor() {
        Looper.getMainLooper().setMessageLogging(null);
    }

    @Override
    public void onStartLoop() {
        DebugUtil.debug("onStartLoop");
    }

    @Override
    public void onEndLoop(String logInfo, int level) {
        DebugUtil.error("onEndLoop %s level=%d",logInfo,level);
    }
}
