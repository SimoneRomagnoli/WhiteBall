package com.example.whiteball.model.entities;

import com.example.whiteball.utilities.Position;

public class Square extends EntityImpl {

    public Square(final Position position) {
        super(position);
        this.type = EntityType.SQUARE;
    }
}
