package com.example.whiteball.model;

import com.example.whiteball.model.entities.Entity;

import java.util.List;

public interface Model {

    /**
     *
     * @return the model entities
     */
    List<Entity> getEntities();

    /**
     *
     * @return true if the game is over
     */
    boolean isGameOver();

    /**
     * Update the model.
     * @param elapsed the time elapsed from last update in milliseconds
     */
    void update(int elapsed);

}
