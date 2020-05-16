package com.example.whiteball.model.entities.components;

import com.example.whiteball.model.entities.Entity;

/**
 * Adds a specific ability to his parent {@link Entity}.
 */
public interface Component {
    /**
     * Makes the {@link Component} update following the game time.
     * @param dt the game time.
     */
    void update(long dt);

    /**
     * Enables the {@link Component}.
     */
    void enable();

    /**
     * Disables the {@link Component}.
     */
    void disable();

    /**
     *
     * @return the {@link ComponentType}.
     */
    ComponentType getType();

    /**
     * Sets the {@link Component}'s parent.
     * @param entity the parent.
     */
    void setParent(Entity entity);

    /**
     *
     * @return the {@link Component}'s parent.
     */
    Entity getParent();
}
