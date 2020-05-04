package com.example.whiteball.model.entities;

import com.example.whiteball.utilities.Position;

public abstract class EntityImpl implements Entity {

    private Position position;
    protected EntityType type;

    public EntityImpl(Position position) {
        this.position = position;
    }

    public EntityType getType() {
        return this.type;
    }

    public Position getPosition() { return this.position; }
}
