package com.je_chen.droidrat_je.rat.modules.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

public class Toastmaker {

    private final Context context;

    public Toastmaker(Context context) {
        this.context = context;
    }

    public void makeToast(String message) {
        this.createToast(message);
    }

    public void makeToast(String message, String gravity) {
        createToast(message, gravity);
    }

    private void createToast(String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    @SuppressLint("RtlHardcoded")
    private void createToast(String message, String gravity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                @SuppressLint("ShowToast") Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
                switch (gravity) {
                    case "BOTTOM":
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        break;

                    case "END":
                        toast.setGravity(Gravity.END, 0, 0);
                        break;

                    case "START":
                        toast.setGravity(Gravity.START, 0, 0);
                        break;

                    case "FILL":
                        toast.setGravity(Gravity.FILL, 0, 0);
                        break;

                    case "LEFT":
                        toast.setGravity(Gravity.LEFT, 0, 0);
                        break;

                    case "RIGHT":
                        toast.setGravity(Gravity.RIGHT, 0, 0);
                        break;

                    case "CENTER":
                    default:
                        toast.setGravity(Gravity.CENTER, 0, 0);
                }
                toast.show();
            }
        });
    }
}
