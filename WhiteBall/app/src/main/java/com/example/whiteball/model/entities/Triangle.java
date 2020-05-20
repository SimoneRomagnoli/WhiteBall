package com.example.whiteball.model.entities;

import android.graphics.Point;

import com.example.whiteball.Constants;

public class Triangle extends EntityImpl {
    private static final Integer EDGE = Constants.TRIANGLE_EDGE;

    public Triangle(Point position, int radius) {
        super(position, radius);
        this.type = EntityType.TRIANGLE;
    }

    @Override
    public Integer getDimension() {
        return this.EDGE;
    }
}
