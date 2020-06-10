package com.example.whiteball.model.entities.components;

import android.graphics.Point;

import com.example.whiteball.model.GameMode;
import com.example.whiteball.model.entities.properties.Vector2D;
import com.example.whiteball.model.entities.properties.Vector2DImpl;
import com.example.whiteball.utility.Constants;

public class GravityComponent extends AbstractComponent {
    private static final Vector2D ACCELERATION = new Vector2DImpl(Constants.GAME_MODE == GameMode.X ? 0 : 0.05, Constants.GAME_MODE == GameMode.X ? 0.05 : 0);

    private Vector2D acceleration;

    public GravityComponent(Point start) {
        super(ComponentType.GRAVITY);
        this.acceleration = new Vector2DImpl(start.x < 0 ? 0.05 : start.x > Constants.SCREEN_WIDTH ? -0.05 : 0, start.y < 0 ? 0.05 : 0);
    }

    @Override
    public void update(long dt) {
        this.getParent().setVelocity(new Vector2DImpl(this.getParent().getVelocity().getX() + this.acceleration.getX(), this.getParent().getVelocity().getY() + this.acceleration.getY()));
    }
}
