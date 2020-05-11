package com.example.whiteball.model;

import java.util.List;

public interface Model {

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
