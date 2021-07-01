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

public class Sensors {

    private final String TAG = "SwitchSensor ";

    private SensorManager sensorManager;

    private AccelerometerSensor accelerometerSensor;
    private AmbientTemperatureSensor ambientTemperatureSensor;
    private GravitySensor gravitySensor;
    private GyroscopeSensor gyroscopeSensor;
    private LightSensor lightSensor;
    private LinearAcceleRationSensor linearAcceleRationSensor;
    private MagneticFieldSensor magneticFieldSensor;
    private OrientationSensor orientationSensor;
    private PressureSensor pressureSensor;
    private ProximitySensor proximitySensor;
    private RelativeHumditySensor relativeHumditySensor;
    private RotationVectorSensor rotationVectorSensor;
    private TemperatureSensor temperatureSensor;

    public Sensors(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
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

    public void setAccelerometerSensor(AccelerometerSensor accelerometerSensor) {
        this.accelerometerSensor = accelerometerSensor;
    }

    public AmbientTemperatureSensor getAmbientTemperatureSensor() {
        return ambientTemperatureSensor;
    }

    public void setAmbientTemperatureSensor(AmbientTemperatureSensor ambientTemperatureSensor) {
        this.ambientTemperatureSensor = ambientTemperatureSensor;
    }

    public GravitySensor getGravitySensor() {
        return gravitySensor;
    }

    public void setGravitySensor(GravitySensor gravitySensor) {
        this.gravitySensor = gravitySensor;
    }

    public GyroscopeSensor getGyroscopeSensor() {
        return gyroscopeSensor;
    }

    public void setGyroscopeSensor(GyroscopeSensor gyroscopeSensor) {
        this.gyroscopeSensor = gyroscopeSensor;
    }

    public LightSensor getLightSensor() {
        return lightSensor;
    }

    public void setLightSensor(LightSensor lightSensor) {
        this.lightSensor = lightSensor;
    }

    public LinearAcceleRationSensor getLinearAcceleRationSensor() {
        return linearAcceleRationSensor;
    }

    public void setLinearAcceleRationSensor(LinearAcceleRationSensor linearAcceleRationSensor) {
        this.linearAcceleRationSensor = linearAcceleRationSensor;
    }

    public MagneticFieldSensor getMagneticFieldSensor() {
        return magneticFieldSensor;
    }

    public void setMagneticFieldSensor(MagneticFieldSensor magneticFieldSensor) {
        this.magneticFieldSensor = magneticFieldSensor;
    }

    public OrientationSensor getOrientationSensor() {
        return orientationSensor;
    }

    public void setOrientationSensor(OrientationSensor orientationSensor) {
        this.orientationSensor = orientationSensor;
    }

    public PressureSensor getPressureSensor() {
        return pressureSensor;
    }

    public void setPressureSensor(PressureSensor pressureSensor) {
        this.pressureSensor = pressureSensor;
    }

    public ProximitySensor getProximitySensor() {
        return proximitySensor;
    }

    public void setProximitySensor(ProximitySensor proximitySensor) {
        this.proximitySensor = proximitySensor;
    }

    public RelativeHumditySensor getRelativeHumditySensor() {
        return relativeHumditySensor;
    }

    public void setRelativeHumditySensor(RelativeHumditySensor relativeHumditySensor) {
        this.relativeHumditySensor = relativeHumditySensor;
    }

    public RotationVectorSensor getRotationVectorSensor() {
        return rotationVectorSensor;
    }

    public void setRotationVectorSensor(RotationVectorSensor rotationVectorSensor) {
        this.rotationVectorSensor = rotationVectorSensor;
    }

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }
}
