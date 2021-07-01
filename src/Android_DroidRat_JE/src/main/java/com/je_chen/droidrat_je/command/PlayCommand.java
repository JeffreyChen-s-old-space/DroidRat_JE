package com.je_chen.droidrat_je.command;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.rat.modules.appintent.play.Play;

public class PlayCommand extends CommandFather implements CommandProcessInterface {

    //TODO play sound
    private Play play;

    public PlayCommand(){
        play = new Play();
    }

    @Override
    public void send(String value) {

    }

    @Override
    public void processCommand(String command) {

    }
}
