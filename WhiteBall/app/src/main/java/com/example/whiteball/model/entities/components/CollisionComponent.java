package com.example.whiteball.model.entities.components;

import com.example.whiteball.model.entities.Entity;

import java.util.List;

public class CollisionComponent extends AbstractComponent {

    private boolean collisions;
    private List<Entity> entities;

    public CollisionComponent() {
        super(ComponentType.COLLISION);
        this.collisions = false;
    }

    @Override
    public void update(long dt) {
        if(!this.entities.isEmpty()) {
            for (Entity entity: this.entities) {
                if(!entity.isPlayer()) {
                    this.collisions = !this.getParent().getArea().getRegion().quickReject(entity.getArea().getRegion());
                }
            }
        }
    }

    public boolean anyCollision() {
        return this.collisions;
    }

    public void updateEntities(List<Entity> entities) {
        this.entities = entities;
    }
}
