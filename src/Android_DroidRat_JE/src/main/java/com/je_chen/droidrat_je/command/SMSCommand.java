package com.je_chen.droidrat_je.command;


import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.rat.modules.appintent.sms.SMS;

public class SMSCommand extends CommandFather implements CommandProcessInterface {

    private SMS sms;

    public SMSCommand(){
        sms = new SMS();
    }

    @Override
    public void send(String value) {

    }

    @Override
    public void processCommand(String command) {

    }
}
