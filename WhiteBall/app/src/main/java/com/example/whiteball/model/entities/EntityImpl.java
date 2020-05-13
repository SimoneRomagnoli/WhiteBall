package com.example.whiteball.model.entities;

import android.graphics.Point;

import com.example.whiteball.model.entities.properties.Area;
import com.example.whiteball.model.entities.properties.Velocity;
import com.example.whiteball.model.entities.properties.VelocityImpl;

public abstract class EntityImpl implements Entity {

    protected Point position;
    protected Velocity velocity;
    protected EntityType type;
    protected Area area;
    protected int radius;

    public EntityImpl(Point position, int radius) {
        this.position = position;
        this.radius = radius;
        this.area = new Area(this.position, this.radius);
        this.velocity = new VelocityImpl(0, 0);
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
        this.area.setRegion(this.position, this.radius);
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

    @Override
    public int getRadius() { return this.radius; }

    @Override
    public Area getArea() { return this.area; }
}
