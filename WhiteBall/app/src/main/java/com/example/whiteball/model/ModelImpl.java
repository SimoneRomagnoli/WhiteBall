package com.example.whiteball.model;

import android.graphics.Point;
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
    public void update() {
        Point oldPoint = player.getPoint();
        if(oldPoint.x > X_RANGE.second) {
            player.setPoint(new Point(X_RANGE.first, Y_COORDINATE));
        } else {
            Point newPoint = new Point(oldPoint.x+2, oldPoint.y);
            player.setPoint(newPoint);
        }

    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }
}
