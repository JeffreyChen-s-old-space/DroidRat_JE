package com.je_chen.droidrat_je.service.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.je_chen.droidrat_je.service.command.ProcessCommandService;

public class ServiceLive extends BroadcastReceiver {

    static String TAG = "BroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Received: " + intent.getAction());

        if (isServiceRunning(context)) {
            Log.v(TAG, "Running");
        } else {
            Log.v(TAG, "Not running restart");
            Intent restart = new Intent(context, ProcessCommandService.class);
            context.startService(restart);
        }
    }

    private boolean isServiceRunning(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (ProcessCommandService.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }


}
