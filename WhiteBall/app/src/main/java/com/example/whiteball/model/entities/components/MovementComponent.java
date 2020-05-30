package com.example.whiteball.model.entities.components;

import android.graphics.Point;

import com.example.whiteball.utility.Constants;
import com.example.whiteball.model.entities.Entity;

/**
 * The {@link Component} that makes his parent able to move.
 */
public class MovementComponent extends AbstractComponent {

    public MovementComponent() {
        super(ComponentType.MOVEMENT);
    }

    @Override
    public void update(final long dt) {
        if (this.isEnabled()) {
            this.updatePosition(dt);
        }
    }

    private void updatePosition(final long dt) {
        final Entity parent = this.getParent();
        Point old = parent.getPosition();
        parent.setPosition(new Point(
                (int)(old.x + parent.getVelocity().getX() * dt * Constants.VELOCITY_FACTOR),
                (int)(old.y + parent.getVelocity().getY() * dt * Constants.VELOCITY_FACTOR)));
    }
}
