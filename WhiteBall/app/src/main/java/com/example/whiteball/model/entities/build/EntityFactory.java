package com.example.whiteball.model.entities.build;

import android.graphics.Point;

import com.example.whiteball.model.entities.Entity;

/**
 * Factory to create an {@link Entity} following the Factory Method Pattern.
 */
public interface EntityFactory {
    /**
     * Creates a new {@link Entity}.
     * @param position
     * @return a new {@link Entity}.
     */
    Entity createEntity(Point position);
}
