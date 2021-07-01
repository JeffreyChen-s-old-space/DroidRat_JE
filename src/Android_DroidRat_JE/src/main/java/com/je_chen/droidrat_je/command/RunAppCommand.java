package com.je_chen.droidrat_je.command;

import android.content.pm.PackageManager;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.rat.modules.appintent.runapp.RunApp;

public class RunAppCommand extends CommandFather implements CommandProcessInterface {

    private RunApp runApp;

    public RunAppCommand(PackageManager packageManager){
        runApp = new RunApp(packageManager);
    }

    @Override
    public void send(String value) {

    }

    @Override
    public void processCommand(String command) {

    }
}
