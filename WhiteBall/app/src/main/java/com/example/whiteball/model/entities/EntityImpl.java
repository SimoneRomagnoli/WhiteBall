package com.example.whiteball.model.entities;

import android.graphics.Canvas;
import android.graphics.Point;

public abstract class EntityImpl implements Entity {

    protected Point position;
    protected Velocity velocity;
    protected EntityType type;

    public EntityImpl(Point position) {
        this.position = position;
        this.velocity = new VelocityImpl(0, 0);
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public EntityType getType() {
        return this.type;
    }

    @Override
    public Velocity getVelocity() { return this.velocity; }

    @Override
    public void setVelocity(Velocity velocity) { this.velocity = velocity; }
}
