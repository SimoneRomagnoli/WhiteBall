package com.example.whiteball.controller;

import com.example.whiteball.model.Model;
import com.example.whiteball.model.entities.Entity;

import java.util.List;

public interface Controller {

    /**
     * Starts a new game.
     */
    void startGameLoop();

    /**
     * Stops the current game.
     */
    void stopGameLoop();

    /**
     *
     * @return the average FPS.
     */
    Double getAvgFPS();

    /**
     *
     * @return a list of {@link Entity} active in the game.
     */
    List<Entity> getEntities();
}
