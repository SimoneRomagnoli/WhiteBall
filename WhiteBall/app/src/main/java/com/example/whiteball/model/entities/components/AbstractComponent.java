package com.example.whiteball.model.entities.components;

import com.example.whiteball.model.entities.Entity;

public abstract class AbstractComponent implements Component {
    private final ComponentType type;
    private Entity parent;
    private boolean isAvailable = true;

    public AbstractComponent(final ComponentType type) {
        this.type = type;
    }

    @Override
    public abstract void update(final long dt);

    @Override
    public void enable() {
        this.isAvailable = true;
    }

    @Override
    public void disable() {
        this.isAvailable = false;
    }

    @Override
    public ComponentType getType() {
        return this.type;
    }

    @Override
    public void setParent(final Entity entity) {
        this.parent = entity;
    }

    @Override
    public Entity getParent() {
        return this.parent;
    }

    protected boolean isEnabled() {
        return this.isAvailable;
    }
}
