package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.example.whiteball.R;

public class Ball extends EntityImpl implements Entity {

    public static final float RADIUS = (float) 20.0;

    public Ball(Point position) {
        super(position);
        this.type = EntityType.BALL;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawCircle(this.getPosition().x, this.getPosition().y, RADIUS, paint);
    }

}
