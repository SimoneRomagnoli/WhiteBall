package com.example.whiteball.controller;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.example.whiteball.Constants;
import com.example.whiteball.model.CommandType;
import com.example.whiteball.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class InputManager implements SensorEventListener, InputObservable {

    private SensorManager manager;
    private Sensor sensor;
    private List<InputObserver> observers;

    private float input;

    public InputManager(Controller controller) {
        this.manager = (SensorManager) Constants.CURRENT_CONTEXT.getSystemService(Context.SENSOR_SERVICE);
        this.sensor =  manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        this.manager.registerListener(this, this.sensor, SensorManager.SENSOR_DELAY_GAME);
        this.observers = new ArrayList<>();

        Constants.GYROSCOPE_SENSITIVITY = 5;

        this.input = 0.0f;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        this.input += event.values[2];
        if (this.input > 1f) {
            this.notifyObservers(new Command(CommandType.MOVE_RIGHT, this.input));
        } else if (this.input < -1f) {
            this.notifyObservers(new Command(CommandType.MOVE_LEFT, this.input));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void addObserver(InputObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(InputObserver observer) {
        if (this.observers.contains(observer)) {
            this.observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(Command command) {
        // God please let me use lambdas.
        for (InputObserver observer: this.observers) {
            observer.updateObserver(command);
        }
    }
}
