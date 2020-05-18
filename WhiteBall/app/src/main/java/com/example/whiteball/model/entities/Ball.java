package com.example.whiteball.model.entities;

import android.graphics.Point;

import com.example.whiteball.Constants;

public class Ball extends EntityImpl implements Entity {
    private static final Integer RADIUS = Constants.PLAYER_RADIUS_INT;

    public Ball(Point position, int radius) {
        super(position, radius);
        this.type = EntityType.BALL;
    }

    @Override
    public Integer getDimension() {
        return this.RADIUS;
    }
}
