package com.je_chen.droidrat_je.rat.modules.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.je_chen.droidrat_je.rat.modules.sensor.sensor_super.SensorInterface;

import java.util.ArrayList;
import java.util.List;

public class AmbientTemperatureSensor implements SensorInterface<List<Float>>, SensorEventListener {

    private final SensorManager sensorManager;
    private final boolean canUse;
    private Sensor sensor;
    private final List<Float> valueList = new ArrayList<>();

    public AmbientTemperatureSensor(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
        canUse = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null;
        if (canUse)
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public List<Float> returnValue() {
        return valueList;
    }

    @Override
    public boolean canUse() {
        return canUse;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            for (int value = 0; value < sensorEvent.values.length; value++)
                valueList.add(sensorEvent.values[value]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (canUse)
            sensorManager.unregisterListener(this);
    }

}
