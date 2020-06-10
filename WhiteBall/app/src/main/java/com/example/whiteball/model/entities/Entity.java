package com.example.whiteball.model.entities;

import android.graphics.Point;


import com.example.whiteball.model.entities.properties.Area;
import com.example.whiteball.model.entities.properties.Vector2D;

import com.example.whiteball.model.entities.components.Component;

import java.util.List;


public interface Entity {
    void setPosition(Point point);

    Point getPosition();

    EntityType getType();

    Vector2D getVelocity();

    void setVelocity(Vector2D velocity);

    int getRadius();

    Area getArea();

    Integer getDimension();

    void update(long dt);

    void addComponent(Component component);

    List<Component> getComponents();

    boolean isPlayer();

    int getRandomNumber();

    void declarePlayer();
}
