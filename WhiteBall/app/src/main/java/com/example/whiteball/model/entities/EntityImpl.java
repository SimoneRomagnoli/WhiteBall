package com.example.whiteball.model.entities;

import android.graphics.Point;

import com.example.whiteball.model.entities.components.Component;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityImpl implements Entity {

    protected Point position;
    protected Velocity velocity;
    protected EntityType type;
    private final List<Component> components;

    public EntityImpl(Point position) {
        this.position = position;
        this.velocity = new VelocityImpl(0, 0);
        this.components = new ArrayList<>();
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
    public void setVelocity(final Velocity velocity) { this.velocity = velocity; }

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
}
