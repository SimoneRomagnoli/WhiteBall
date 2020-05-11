package com.example.whiteball.model.entities;

import android.graphics.drawable.shapes.RectShape;

import com.example.whiteball.utilities.Position;

public class Square extends EntityImpl {

    public Square(final Position position) {
        super(position);
        this.type = EntityType.SQUARE;
        this.shape = new RectShape();
    }
}
