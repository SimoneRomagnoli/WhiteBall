package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.example.whiteball.Constants;

public class Ball extends EntityImpl implements Entity {


    public Ball(Point position) {
        super(position);
        this.type = EntityType.BALL;
    }

}
