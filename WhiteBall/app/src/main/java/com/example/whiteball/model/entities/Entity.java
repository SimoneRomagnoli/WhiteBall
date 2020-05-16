package com.example.whiteball.model.entities;

import android.graphics.Point;

import com.example.whiteball.model.entities.components.Component;

import java.util.List;

public interface Entity {
    void setPosition(Point point);

    Point getPosition();

    EntityType getType();

    Velocity getVelocity();

    void setVelocity(Velocity velocity);

    Integer getDimension();

    void update(long dt);

    void addComponent(Component component);

    List<Component> getComponents();
}
