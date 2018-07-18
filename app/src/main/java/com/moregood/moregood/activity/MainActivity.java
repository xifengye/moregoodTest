package com.moregood.moregood.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.moregood.moregood.R;
import com.moregood.moregood.time_monitor.TimeMonitorConfig;
import com.moregood.moregood.time_monitor.TimeMonitorMgr;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimeMonitorMgr.getInstance().getTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START).recodingTimeTag("MainActivity->onCreate");
        // Example of a call to a native method
        ListView tv = (ListView) findViewById(R.id.sample_text);
        TimeMonitorMgr.getInstance().getTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START).recodingTimeTag("MainActivity->onCreate-Over");

    }

    @Override
    protected void onStart() {
        super.onStart();
        TimeMonitorMgr.getInstance().getTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START).end("MainActivity->onStart",false);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
