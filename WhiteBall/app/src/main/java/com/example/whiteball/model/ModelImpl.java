package com.example.whiteball.model;

import android.graphics.Point;
import android.hardware.SensorManager;
import android.util.Pair;

import com.example.whiteball.Constants;
import com.example.whiteball.controller.Command;
import com.example.whiteball.controller.InputManager;
import com.example.whiteball.model.entities.Ball;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.Square;
import com.example.whiteball.model.entities.Velocity;
import com.example.whiteball.model.entities.VelocityImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModelImpl implements Model {
    private final int Y_COORDINATE = Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 10;

    private List<Entity> entities;
    private Ball player;

    public ModelImpl() {
        this.entities = new ArrayList<>();
        this.player = new Ball(new Point(Constants.SCREEN_WIDTH / 2, Y_COORDINATE));
        //this.player.setVelocity(new VelocityImpl(5, 0));

        this.entities.add(this.player);
        Square square = new Square(new Point(200, 0));
        square.setVelocity(new VelocityImpl(0, 1));
        this.entities.add(square);
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public void update(final long dt) {
        for (Entity entity: this.entities) {
            Point old = entity.getPosition();
            if(old.x + entity.getDimension() > Constants.SCREEN_WIDTH) {
                entity.setPosition(new Point(0, old.y));
            } else if(old.x < 0) {
                entity.setPosition(new Point(Constants.SCREEN_WIDTH - entity.getDimension(), old.y));
            } else if(old.y + entity.getDimension() > Constants.SCREEN_HEIGHT) {
                entity.setPosition(new Point(old.x, 0));
            } else if(old.y < 0) {
                entity.setPosition(new Point(old.x, Constants.SCREEN_HEIGHT));
            } else {
                entity.setPosition(new Point(
                        (int)(old.x + entity.getVelocity().getX() * dt),
                        (int)(old.y + entity.getVelocity().getY() * dt)));
            }
        }
    }

    @Override
    public List<Entity> getEntities() {
        return ImmutableList.copyOf(this.entities);
    }

    @Override
    public void resolveInputs(List<Command> inputs) {
        // God let me use lambdas pt.2.
        final Velocity velocity = new VelocityImpl(0, 0);
        for (Command command: inputs) {
            velocity.setX((int)(velocity.getX() + InputManager.GYROSCOPE_SENSITIVITY * (-(int)command.getValue())));
        }
        this.player.setVelocity(velocity);
    }
}
