package com.example.whiteball.model.entities;

import android.graphics.Rect;
import android.graphics.drawable.shapes.Shape;

import com.example.whiteball.utilities.Position;

public abstract class EntityImpl implements Entity {

    private Position position;
    protected EntityType type;
    protected Shape shape;

    public EntityImpl(Position position) {
        this.position = position;
    }

    public EntityType getType() {
        return this.type;
    }

    public Position getPosition() { return this.position; }

    public void setPosition(Position position)  { this.position = position; }

    public Shape getShape() { return this.shape; }
}
