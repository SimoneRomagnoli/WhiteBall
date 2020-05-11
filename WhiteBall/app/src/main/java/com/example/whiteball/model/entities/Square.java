package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Square extends EntityImpl implements Entity {

    private static final int EDGE = 40;
    private Rect rectangle;

    public Square(Point point) {
        super(point);
        this.rectangle = new Rect(this.point.x, this.point.y, this.point.x + EDGE, this.point.y + EDGE);
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(rectangle, paint);
    }
}
