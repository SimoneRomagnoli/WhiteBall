package com.example.whiteball.model.entities;

import android.graphics.Point;

public interface Entity {
    void setPosition(Point point);

    Point getPosition();

    EntityType getType();

    Velocity getVelocity();

    void setVelocity(Velocity velocity);

    Integer getDimension();
}
