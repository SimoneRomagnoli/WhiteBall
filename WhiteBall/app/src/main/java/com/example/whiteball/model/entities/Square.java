package com.example.whiteball.model.entities;

import android.graphics.Point;

public class Square extends EntityImpl implements Entity {
    private static final Integer EDGE = 50;

    public Square(Point position, int radius) {
        super(position, radius);
        this.type = EntityType.SQUARE;
    }

    @Override
    public Integer getDimension() {
        return this.EDGE;
    }
}
