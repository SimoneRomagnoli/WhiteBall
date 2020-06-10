package com.example.whiteball.model.entities.build;

import com.example.whiteball.model.entities.Entity;

import java.util.List;

import javax.annotation.Nullable;

public interface Spawner {

    /**
     * Updates the spawner with the elapsed time since last game loop iteration
     */
    void update(List<Entity> entities, long time);

    /**
     * The spawner can start his job
     */
    void start();

    /**
     *
     * @return true if the spawner is active
     */
    boolean isSpawning();

}
