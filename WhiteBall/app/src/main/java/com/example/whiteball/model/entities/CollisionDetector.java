package com.example.whiteball.model.entities;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetector {

    private int collisions;
    private List<Entity> entities;

    public CollisionDetector(List<Entity> entities) {
        this.collisions = 0;
        this.entities = entities;
    }

    public boolean anyCollision(Entity player) {
        boolean collisions = false;

        for (Entity entity:entities) {
            if(entity.getType() != EntityType.BALL) {
                if(!player.getArea().getRegion().quickReject(entity.getArea().getRegion())) {
                    this.collisions++;
                    collisions = true;
                    this.entities.remove(entity);
                }
            }
        }
        return collisions;
    }

    public int getCollisions() {
        return this.collisions;
    }
}
