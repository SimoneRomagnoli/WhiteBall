package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class ViewBall extends ViewEntity {
    public ViewBall(Entity entity, int color) {
        super(entity, color);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawCircle((float)this.getPosition().getX(), (float)this.getPosition().getY(), 10, paint);
    }
}
