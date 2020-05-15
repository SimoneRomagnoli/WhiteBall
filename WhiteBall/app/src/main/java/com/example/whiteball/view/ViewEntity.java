package com.example.whiteball.view;

import android.graphics.Point;

import com.example.whiteball.model.entities.EntityType;

class ViewEntity {
    private EntityType type;
    private Point position;
    private Integer dimension;

    public ViewEntity(EntityType type, Point position, Integer dimension) {
        this.type = type;
        this.position = position;
        this.dimension = dimension;
    }

    public EntityType getType() {
        return this.type;
    }

    public Point getPosition() {
        return this.position;
    }

    public Integer getDimension() {
        return this.dimension;
    }
}
