package com.example.whiteball.model;

import com.example.whiteball.MainActivity;
import com.example.whiteball.model.entities.Ball;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.Square;
import com.example.whiteball.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private List<Entity> entities;

    public ModelImpl() {
        this.entities = new ArrayList<>();
        this.entities.add(new Ball(new Position(MainActivity.DISPLAY_SIZE.x - 100, 700.0)));
        this.entities.add(new Square(new Position(400.0, 300.0)));
    }

    public List<Entity> getEntities() {
        return this.entities;
    }
}
