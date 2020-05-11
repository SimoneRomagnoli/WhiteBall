package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Square extends EntityImpl implements Entity {

    public static final int EDGE = 40;
    private Rect rectangle;

    public Square(Point position) {
        super(position);
        this.type = EntityType.SQUARE;
        //this.rectangle = new Rect(this.getPosition().x, this.getPosition().y, this.getPosition().x + EDGE, this.getPosition().y + EDGE);
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(rectangle, paint);
    }
}
