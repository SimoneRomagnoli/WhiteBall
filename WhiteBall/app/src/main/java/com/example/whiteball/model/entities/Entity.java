package com.example.whiteball.model.entities;

import android.graphics.Canvas;

public interface Entity {
    public void draw(Canvas canvas);

    public void update();
}
