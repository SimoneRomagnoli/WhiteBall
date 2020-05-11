package com.example.whiteball.model.entities;

import android.graphics.drawable.shapes.Shape;

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

    /**
     *
     * @return the shape to draw on the view canvas
     */
    Shape getShape();
}
