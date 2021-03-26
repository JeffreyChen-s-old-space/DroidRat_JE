package com.je_chen.droidrat_je.modules.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.je_chen.droidrat_je.modules.sensor.sensor_super.SensorInterface;

public class RotationVectorSensor  implements SensorInterface<Object>, SensorEventListener {
    private SensorManager sensorManager;
    private boolean canUse;

    public RotationVectorSensor(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
        canUse = sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR) != null;
    }
    @Override
    public Object returnValue() {
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
