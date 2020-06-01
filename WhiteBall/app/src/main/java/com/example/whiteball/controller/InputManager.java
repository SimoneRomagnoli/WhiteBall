package com.example.whiteball.controller;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.example.whiteball.model.GameMode;
import com.example.whiteball.utility.Constants;
import com.example.whiteball.model.CommandType;

import java.util.ArrayList;
import java.util.List;

public class InputManager implements SensorEventListener, InputObservable {
    public static final double GYROSCOPE_SENSITIVITY = 0.5;

    private SensorManager manager;
    private Sensor sensor;
    private List<InputObserver> observers;

    private float x_input;
    private float y_input;

    public InputManager(Controller controller) {
        this.manager = (SensorManager) Constants.CURRENT_CONTEXT.getSystemService(Context.SENSOR_SERVICE);
        this.sensor =  manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        this.manager.registerListener(this, this.sensor, SensorManager.SENSOR_DELAY_GAME);
        this.observers = new ArrayList<>();

        this.x_input = 0.0f;
        this.y_input = 0.0f;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(Constants.GAME_MODE == GameMode.X || Constants.GAME_MODE == GameMode.XY) {
            this.x_input += event.values[1];
            if (this.x_input > 0f) {
                this.notifyObservers(new Command(CommandType.MOVE_RIGHT, this.x_input));
            } else if (this.x_input < 0f) {
                this.notifyObservers(new Command(CommandType.MOVE_LEFT, this.x_input));
            }
        }
        if(Constants.GAME_MODE == GameMode.Y || Constants.GAME_MODE == GameMode.XY) {
            this.y_input += event.values[0];
            if (this.y_input > 0f) {
                this.notifyObservers(new Command(CommandType.MOVE_DOWN, this.y_input));
            } else if (this.y_input < 0f) {
                this.notifyObservers(new Command(CommandType.MOVE_UP, this.y_input));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

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
