package com.je_chen.droidrat_je.modules.vibrator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import android.util.Log;

public class VibratorSystem {

    final String TAG = "JE-TAG";
    private Vibrator vibrator;

    @SuppressLint("ServiceCast")
    public VibratorSystem(Context context) {
        this.vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void startVibrator(int millSec) {
        this.vibrator.vibrate(millSec);
        Log.e(TAG, "startVibrator");
    }
}
