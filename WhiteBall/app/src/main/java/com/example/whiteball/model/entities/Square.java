package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Square extends EntityImpl implements Entity {

    public Square(Point position, int radius) {
        super(position, radius);
        this.type = EntityType.SQUARE;

    }

    @Override
    public void draw(Canvas canvas) {
    }
}
