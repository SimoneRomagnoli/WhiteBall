package com.example.whiteball.model;

import android.graphics.Point;
import android.hardware.SensorManager;
import android.util.Pair;

import com.example.whiteball.model.entities.Ball;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.Square;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private final Pair<Integer, Integer> X_RANGE = new Pair<Integer, Integer>(20, 450);
    private final int Y_COORDINATE = 750;
    private List<Entity> entities;
    private Ball player;

    public ModelImpl() {
        this.entities = new ArrayList<>();
        this.player = new Ball(new Point(X_RANGE.first, Y_COORDINATE));

        this.entities.add(this.player);
        this.entities.add(new Square(new Point(200, 200)));
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public void update(float input) {
        Point oldPoint = player.getPosition();
        if(oldPoint.x > X_RANGE.second) {
            player.setPosition(new Point(X_RANGE.first, Y_COORDINATE));
        } else if(oldPoint.x < X_RANGE.first) {
            player.setPosition(new Point(X_RANGE.second, Y_COORDINATE));
        } else {
            float move = 0;
            if(input > 0.5f) {
                move = 4 * input;
            } else if(input < -0.5f) {
                move = 4 * input;
            }
            Point newPoint = new Point(oldPoint.x + (int)move, oldPoint.y);
            player.setPosition(newPoint);
        }
    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override
    public void executeInput(float input) {
        Point oldPoint = player.getPosition();
        if(oldPoint.x > X_RANGE.second) {
            player.setPosition(new Point(X_RANGE.first, Y_COORDINATE));
        } else if(oldPoint.x < X_RANGE.first) {
            player.setPosition(new Point(X_RANGE.second, Y_COORDINATE));
        } else {
            int move = 0;
            if(input > 0.5f) {
                move = 2;
            } else if(input < -0.5f) {
                move = -2;
            }
            Point newPoint = new Point(oldPoint.x + move, oldPoint.y);
            player.setPosition(newPoint);
        }
    }
}
