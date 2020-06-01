package com.example.whiteball.model.entities.components;

import android.graphics.Point;

import com.example.whiteball.utility.Constants;

/**
 * The {@link Component} that makes his parent live in a toroidal world.
 */
public class ToroidalComponent extends AbstractComponent {

    public ToroidalComponent() {
        super(ComponentType.TOROIDAL);
    }

    @Override
    public void update(long dt) {
        if (this.isEnabled()) {
            final Point position = this.getParent().getPosition();
            if (position.x < 0) {
                this.getParent().setPosition(new Point(Constants.SCREEN_WIDTH - this.getParent().getDimension(), position.y));
            } else if (position.x + this.getParent().getDimension() > Constants.SCREEN_WIDTH) {
                this.getParent().setPosition(new Point(0, position.y));
            }
            if (position.y < 0) {
                this.getParent().setPosition(new Point(position.x, Constants.SCREEN_HEIGHT - this.getParent().getDimension()));
            } else if (position.y + this.getParent().getDimension() > Constants.SCREEN_HEIGHT) {
                this.getParent().setPosition(new Point(position.x, 0));
            }
        }
    }
}
