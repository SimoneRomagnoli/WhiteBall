package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.example.whiteball.R;

public class Ball extends EntityImpl implements Entity {

    private static final float RADIUS = (float) 20.0;

    public Ball(Point point) {
        super(point);
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawCircle(this.point.x, this.point.y, RADIUS, paint);
    }

}
