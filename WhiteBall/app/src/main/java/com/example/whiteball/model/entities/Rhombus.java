package com.example.whiteball.model.entities;

import android.graphics.Point;

import com.example.whiteball.Constants;

public class Rhombus extends EntityImpl {
    private static final Integer EDGE = Constants.RHOMBUS_EDGE;

    public Rhombus(Point position, int radius) {
        super(position, radius);
        this.type = EntityType.RHOMBUS;
    }

    @Override
    public Integer getDimension() {
        return null;
    }
}
