package com.je_chen.droidrat_je.rat.modules.sensor.sensor_super;

import android.hardware.SensorManager;

import com.je_chen.droidrat_je.rat.modules.sensor.AccelerometerSensor;
import com.je_chen.droidrat_je.rat.modules.sensor.AmbientTemperatureSensor;
import com.je_chen.droidrat_je.rat.modules.sensor.GravitySensor;
import com.je_chen.droidrat_je.rat.modules.sensor.GyroscopeSensor;
import com.je_chen.droidrat_je.rat.modules.sensor.LightSensor;
import com.je_chen.droidrat_je.rat.modules.sensor.LinearAcceleRationSensor;
import com.je_chen.droidrat_je.rat.modules.sensor.MagneticFieldSensor;
import com.je_chen.droidrat_je.rat.modules.sensor.OrientationSensor;
import com.je_chen.droidrat_je.rat.modules.sensor.PressureSensor;
import com.je_chen.droidrat_je.rat.modules.sensor.ProximitySensor;
import com.je_chen.droidrat_je.rat.modules.sensor.RelativeHumditySensor;
import com.je_chen.droidrat_je.rat.modules.sensor.RotationVectorSensor;
import com.je_chen.droidrat_je.rat.modules.sensor.TemperatureSensor;

/**
 * TODO Sensors
 */
public class Sensors {

    private final String TAG = "SwitchSensor ";

    private final AccelerometerSensor accelerometerSensor;
    private final AmbientTemperatureSensor ambientTemperatureSensor;
    private final GravitySensor gravitySensor;
    private final GyroscopeSensor gyroscopeSensor;
    private final LightSensor lightSensor;
    private final LinearAcceleRationSensor linearAcceleRationSensor;
    private final MagneticFieldSensor magneticFieldSensor;
    private final OrientationSensor orientationSensor;
    private final PressureSensor pressureSensor;
    private final ProximitySensor proximitySensor;
    private final RelativeHumditySensor relativeHumditySensor;
    private final RotationVectorSensor rotationVectorSensor;
    private final TemperatureSensor temperatureSensor;

    public Sensors(SensorManager sensorManager) {
        this.accelerometerSensor = new AccelerometerSensor(sensorManager);
        this.ambientTemperatureSensor = new AmbientTemperatureSensor(sensorManager);
        this.gravitySensor = new GravitySensor(sensorManager);
        this.gyroscopeSensor = new GyroscopeSensor(sensorManager);
        this.lightSensor = new LightSensor(sensorManager);
        this.linearAcceleRationSensor = new LinearAcceleRationSensor(sensorManager);
        this.magneticFieldSensor = new MagneticFieldSensor(sensorManager);
        this.orientationSensor = new OrientationSensor(sensorManager);
        this.pressureSensor = new PressureSensor(sensorManager);
        this.proximitySensor = new ProximitySensor(sensorManager);
        this.relativeHumditySensor = new RelativeHumditySensor(sensorManager);
        this.rotationVectorSensor = new RotationVectorSensor(sensorManager);
        this.temperatureSensor = new TemperatureSensor(sensorManager);
    }


    public AccelerometerSensor getAccelerometerSensor() {
        return accelerometerSensor;
    }

    public AmbientTemperatureSensor getAmbientTemperatureSensor() {
        return ambientTemperatureSensor;
    }

    public GravitySensor getGravitySensor() {
        return gravitySensor;
    }

    public GyroscopeSensor getGyroscopeSensor() {
        return gyroscopeSensor;
    }

    public LightSensor getLightSensor() {
        return lightSensor;
    }

    public LinearAcceleRationSensor getLinearAcceleRationSensor() {
        return linearAcceleRationSensor;
    }


    public MagneticFieldSensor getMagneticFieldSensor() {
        return magneticFieldSensor;
    }


    public OrientationSensor getOrientationSensor() {
        return orientationSensor;
    }

    public PressureSensor getPressureSensor() {
        return pressureSensor;
    }

    public ProximitySensor getProximitySensor() {
        return proximitySensor;
    }

    public RelativeHumditySensor getRelativeHumditySensor() {
        return relativeHumditySensor;
    }

    public RotationVectorSensor getRotationVectorSensor() {
        return rotationVectorSensor;
    }

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }
}
