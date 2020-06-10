package com.example.whiteball.view;

import android.graphics.Paint;
import android.graphics.Point;

import com.example.whiteball.model.entities.EntityType;

import java.util.Random;

class ViewEntity {
    private EntityType type;
    private Point position;
    private Integer dimension;
    private Paint paint;

    public ViewEntity(EntityType type, Point position, Integer dimension, Integer color) {
        this.type = type;
        this.position = position;
        this.dimension = dimension;
        this.paint = new Paint();
        this.paint.setColor(color);
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

    public Paint getPaint() { return this.paint; }
}
