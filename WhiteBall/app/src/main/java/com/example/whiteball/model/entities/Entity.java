package com.example.whiteball.model.entities;

import com.example.whiteball.utilities.Position;

public interface Entity {

    /**
     *
     * @return the entity type
     */
    EntityType getType();

    /**
     *
     * @return the entity position
     */
    Position getPosition();

    /**
     * Set the position of the entity
     * @param position the new entity's position
     */
    void setPosition(Position position);
}
