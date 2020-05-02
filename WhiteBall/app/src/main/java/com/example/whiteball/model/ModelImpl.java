package com.example.whiteball.model;

import com.example.whiteball.model.entities.BallImpl;
import com.example.whiteball.model.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private List<Entity> entities;

    public ModelImpl() {
        this.entities = new ArrayList<>();
        this.entities.add(new BallImpl());
    }

    public List<Entity> getEntities() {
        return this.entities;
    }
}
