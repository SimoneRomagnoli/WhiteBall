package com.example.whiteball.model.entities.components;

import com.example.whiteball.model.entities.properties.Vector2D;
import com.example.whiteball.model.entities.properties.Vector2DImpl;

public class GravityComponent extends AbstractComponent {
    private static final Vector2D ACCELERATION = new Vector2DImpl(0, 0.05);

    public GravityComponent() {
        super(ComponentType.GRAVITY);
    }

    @Override
    public void update(long dt) {
        this.getParent().setVelocity(new Vector2DImpl(this.getParent().getVelocity().getX() + this.ACCELERATION.getX(), this.getParent().getVelocity().getY() + this.ACCELERATION.getY()));
    }
}
