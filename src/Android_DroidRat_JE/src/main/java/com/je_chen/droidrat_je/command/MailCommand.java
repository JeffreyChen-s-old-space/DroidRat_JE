package com.je_chen.droidrat_je.command;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.rat.modules.appintent.mail.SendMail;

public class MailCommand extends CommandFather implements CommandProcessInterface {

    private SendMail sendMail;

    public MailCommand(){
        sendMail = new SendMail();
    }

    @Override
    public void send(String value) {

    }

    @Override
    public void processCommand(String command) {

    }
}
