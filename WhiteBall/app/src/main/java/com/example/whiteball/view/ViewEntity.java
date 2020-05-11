package com.example.whiteball.view;

import android.graphics.Point;

import com.example.whiteball.model.entities.EntityType;

class ViewEntity {
    private EntityType type;
    private Point position;

    public ViewEntity(EntityType type, Point position) {
        this.type = type;
        this.position = position;
    }

    public EntityType getType() {
        return this.type;
    }

    public Point getPosition() {
        return this.position;
    }
}
