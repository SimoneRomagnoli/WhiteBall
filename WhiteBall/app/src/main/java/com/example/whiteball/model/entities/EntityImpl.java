package com.example.whiteball.model.entities;

import android.graphics.Point;

import com.example.whiteball.model.entities.properties.Area;
import com.example.whiteball.model.entities.properties.Vector2D;
import com.example.whiteball.model.entities.properties.Vector2DImpl;
import com.example.whiteball.model.entities.components.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class EntityImpl implements Entity {

    protected Point position;
    protected Vector2D velocity;
    protected EntityType type;
    protected int random;
    protected Area area;
    protected int radius;
    private final List<Component> components;
    private boolean isPlayer = false;

    public EntityImpl(Point position, int radius) {
        this.position = position;
        this.radius = radius;
        this.area = new Area(this.position, this.radius);
        this.velocity = new Vector2DImpl(0, 0);
        this.components = new ArrayList<>();
        Random r = new Random();
        random = r.nextInt(EntityType.values().length - 1);
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
    public Vector2D getVelocity() { return this.velocity; }

    @Override
    public void setVelocity(Vector2D velocity) { this.velocity = velocity; }

    @Override
    public int getRadius() { return this.radius; }

    @Override
    public Area getArea() { return this.area; }

    @Override
    public int getRandomNumber() {
        return this.random;
    }

    @Override
    public void update(final long dt) {
        // God let me use lambdas pt.3
        for (Component component: this.components) {
            component.update(dt);
        }
    }

    @Override
    public void addComponent(final Component component) {
        component.setParent(this);
        this.components.add(component);
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public boolean isPlayer() {
        return this.isPlayer;
    }

    @Override
    public void declarePlayer() {
        this.isPlayer = true;
        this.type = EntityType.PLAYER;
    }
}
