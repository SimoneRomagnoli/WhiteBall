package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

import com.example.whiteball.R;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.EntityType;
import com.example.whiteball.utilities.Position;

public abstract class ViewEntity implements Entity {

    private EntityType type;
    private Position position;
    private Shape shape;
    private int color;

    public ViewEntity(final Entity entity, int color) {
        this.type = entity.getType();
        this.position = entity.getPosition();
        this.shape = entity.getShape();
        this.color = color;
    }


    @Override
    public EntityType getType() {
        return this.type;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position position) { this.position = position; }

    @Override
    public Shape getShape() { return this.shape; }

    public void draw(Canvas canvas) {

    }

}
