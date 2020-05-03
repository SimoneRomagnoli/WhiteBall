package com.example.whiteball.model.entities;

import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.EntityType;
import com.example.whiteball.utilities.Position;

public class ViewEntity implements Entity {

    private EntityType type;
    private Position position;

    public ViewEntity(final Entity entity) {
        this.type = entity.getType();
        this.position = entity.getPosition();
    }


    @Override
    public EntityType getType() {
        return this.type;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }
}
