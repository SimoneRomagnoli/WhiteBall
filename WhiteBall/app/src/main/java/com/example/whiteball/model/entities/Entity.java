package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Point;

public interface Entity {
    public void draw(Canvas canvas);

    public void setPoint(Point point);

    public Point getPoint();
}
