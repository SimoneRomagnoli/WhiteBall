package com.example.whiteball.model.entities;

import android.graphics.Point;

public class Ball extends EntityImpl implements Entity {
    private static final Integer RADIUS = 40;

    public Ball(Point position) {
        super(position);
        this.type = EntityType.BALL;
    }

    @Override
    public Integer getDimension() {
        return this.RADIUS;
    }
}
