package com.example.whiteball.model.entities;

import android.graphics.Point;


import com.example.whiteball.model.entities.components.ComponentType;
import com.example.whiteball.model.entities.properties.Area;
import com.example.whiteball.model.entities.properties.Velocity;

import com.example.whiteball.model.entities.components.Component;

import java.util.List;


public interface Entity {
    void setPosition(Point point);

    Point getPosition();

    EntityType getType();

    Velocity getVelocity();

    void setVelocity(Velocity velocity);

    int getRadius();

    Area getArea();

    Integer getDimension();

    void update(long dt);

    void addComponent(Component component);

    List<Component> getComponents();

    boolean isPlayer();

    void declarePlayer();
}
