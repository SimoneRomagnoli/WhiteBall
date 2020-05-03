package com.example.whiteball.model;

import com.example.whiteball.model.entities.Ball;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.Square;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private List<Entity> entities;

    public ModelImpl() {
        this.entities = new ArrayList<>();
        this.entities.add(new Ball());
        this.entities.add(new Square());
    }

    public List<Entity> getEntities() {
        return this.entities;
    }
}
