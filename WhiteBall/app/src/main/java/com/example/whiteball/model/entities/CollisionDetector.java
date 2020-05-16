package com.example.whiteball.model.entities;

import java.util.List;

public class CollisionDetector {

    public boolean anyCollision(Entity player, List<Entity> entities) {
        boolean collisions = false;

        for (Entity entity:entities) {
            if(entity.getType() != EntityType.BALL) {
                if(!player.getArea().getRegion().quickReject(entity.getArea().getRegion())) {

                    collisions = true;
                }
            }
        }
        return collisions;
    }
}
