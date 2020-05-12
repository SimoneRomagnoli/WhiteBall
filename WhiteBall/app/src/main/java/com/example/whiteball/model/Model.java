package com.example.whiteball.model;

import com.example.whiteball.model.entities.Entity;

import java.util.List;

public interface Model {

    /**
     *
     * @return true if the game is over
     */
    boolean isGameOver();

    /**
     * Update the model.
     */
    void update(float input);

    /**
     *
     * @return all the entities in the model
     */
    List<Entity> getEntities();

    void executeInput(float input);
}
