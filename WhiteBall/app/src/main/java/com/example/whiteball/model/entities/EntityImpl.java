package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Point;

public abstract class EntityImpl implements Entity {

    protected Point point;

    public EntityImpl(Point point) {
        this.point = point;
    }

    @Override
    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public Point getPoint() {
        return this.point;
    }
}
