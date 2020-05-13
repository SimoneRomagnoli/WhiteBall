package com.example.whiteball.controller;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.example.whiteball.Constants;
import com.example.whiteball.model.Model;

public class InputManager implements SensorEventListener {

    private Controller controller;
    private SensorManager manager;
    private Sensor sensor;

    private float input;

    public InputManager(Controller controller) {
        this.manager = (SensorManager) Constants.CURRENT_CONTEXT.getSystemService(Context.SENSOR_SERVICE);
        this.sensor =  manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        this.manager.registerListener(this, this.sensor, SensorManager.SENSOR_DELAY_GAME);

        Constants.GYROSCOPE_SENSITIVITY = 5;

        this.input = 0.0f;
        this.controller = controller;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        this.input += event.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void execute(final Model model) {
        model.executeInput(this.input);
    }
}
