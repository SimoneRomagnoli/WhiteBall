package com.example.whiteball.model.entities;

import com.example.whiteball.utilities.Position;

public class Ball extends EntityImpl {

    public Ball(final Position position) {
        super(position);
        this.type = EntityType.BALL;
    }
}
