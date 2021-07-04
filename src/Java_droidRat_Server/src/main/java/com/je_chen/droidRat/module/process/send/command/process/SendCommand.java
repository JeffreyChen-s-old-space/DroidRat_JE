package com.je_chen.droidRat.module.process.send.command.process;

import com.je_chen.droidRat.module.DroidRatWebSocketServer;
import com.je_chen.droidRat.module.process.send.command.process_super.CommandFather;

public class SendCommand extends CommandFather {

    private final DroidRatWebSocketServer droidRatWebSocketServer;

    public SendCommand(DroidRatWebSocketServer droidRatWebSocketServer) {
        this.droidRatWebSocketServer = droidRatWebSocketServer;
    }

    @Override
    public void processCommand(String command) {
        this.droidRatWebSocketServer.sendText(command);
    }
}
