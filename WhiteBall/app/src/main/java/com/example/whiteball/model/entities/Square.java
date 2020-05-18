package com.example.whiteball.model.entities;

import android.graphics.Point;

import com.example.whiteball.Constants;

public class Square extends EntityImpl implements Entity {
    private static final Integer EDGE = Constants.SQUARE_EDGE;

    public Square(Point position, int radius) {
        super(position, radius);
        this.type = EntityType.SQUARE;
    }

    @Override
    public Integer getDimension() {
        return this.EDGE;
    }
}
