package com.example.whiteball.model;

import android.graphics.Point;

import com.example.whiteball.model.entities.Ball;
import com.example.whiteball.model.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    List<Entity> entities;

    public ModelImpl() {
        this.entities = new ArrayList<>();
        this.entities.add(new Ball(new Point(20, 200)));
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public void update(int elapsed) {

    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }
}
