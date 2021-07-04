package com.je_chen.droidRat.module.process.send.command.process;

import com.je_chen.droidRat.module.DroidRatWebSocketServer;
import com.je_chen.droidRat.module.process.send.command.process_super.CommandFather;

public class InfoCommand extends CommandFather {

    private final DroidRatWebSocketServer droidRatWebSocketServer;

    public InfoCommand(DroidRatWebSocketServer droidRatWebSocketServer) {
        this.droidRatWebSocketServer = droidRatWebSocketServer;
    }

    @Override
    public void processCommand(String command) {
        switch (command) {
            case "userTable-Length":
                System.out.println(droidRatWebSocketServer.getUserTable().size());
                break;
        }
    }
}
