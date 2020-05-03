package com.example.whiteball.model.entities;

import com.example.whiteball.utilities.Position;

public abstract class EntityImpl implements Entity {

    private Position position;
    protected EntityType type;

    public EntityImpl() {
        this.position = new Position(0.0, 0.0);
    }

    public EntityType getType() {
        return this.type;
    }

    public Position getPosition() { return this.position; }
}
