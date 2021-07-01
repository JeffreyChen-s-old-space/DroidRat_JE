package com.je_chen.droidrat_je.rat.modules.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.je_chen.droidrat_je.rat.modules.sensor.sensor_super.SensorInterface;

import java.util.List;

public class AmbientTemperatureSensor implements SensorInterface<List<Float>>, SensorEventListener{

    private SensorManager sensorManager;
    private boolean canUse;

    public AmbientTemperatureSensor(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
        canUse = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null;
    }

    @Override
    public List<Float> returnValue() {
        return null;
    }

    @Override
    public boolean canUse() {
        return canUse;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
