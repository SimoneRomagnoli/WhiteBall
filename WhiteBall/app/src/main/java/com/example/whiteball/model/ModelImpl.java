package com.example.whiteball.model;

import android.graphics.Point;
import android.hardware.SensorManager;
import android.renderscript.ScriptGroup;
import android.util.Pair;

import com.example.whiteball.Constants;
import com.example.whiteball.controller.Command;
import com.example.whiteball.controller.InputManager;
import com.example.whiteball.model.entities.Ball;
import com.example.whiteball.model.entities.CollisionDetector;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.EntityFactoryImpl;
import com.example.whiteball.model.entities.Square;
import com.example.whiteball.model.entities.properties.Velocity;
import com.example.whiteball.model.entities.properties.VelocityImpl;
import com.example.whiteball.model.entities.components.Component;
import com.example.whiteball.model.entities.components.ComponentType;
import com.example.whiteball.model.entities.components.InputComponent;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModelImpl implements Model {
    private final int Y_COORDINATE = Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 10;

    private List<Entity> entities;
    private Ball player;
    private CollisionDetector collisionDetector;

    public ModelImpl() {
        this.entities = new ArrayList<>();
        this.player = (Ball)EntityFactoryImpl.createBall(new Point(Constants.SCREEN_WIDTH / 2, Y_COORDINATE));
        this.entities.add(this.player);

        Square square = (Square)EntityFactoryImpl.createSquare(new Point(200, 0));
        square.setVelocity(new VelocityImpl(0, 1));
        this.entities.add(square);

        this.collisionDetector = new CollisionDetector(this.entities);
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public void update(final long dt) {
        for (Entity entity: this.entities) {
            entity.update(dt);
        }
        this.collisionDetector.anyCollision(this.player);
    }

    @Override
    public List<Entity> getEntities() {
        return ImmutableList.copyOf(this.entities);
    }

    @Override
    public Entity getPlayer() {
        return this.player;
    }

    @Override
    public void resolveInputs(List<Command> inputs) {
        // God let me use lambdas pt.2.
        for (Entity entity: this.entities) {
            for (Component component: entity.getComponents()) {
                if (component.getType().equals(ComponentType.INPUT)) {
                    ((InputComponent)component).collectInputs(inputs);
                }
            }
        }
    }

    @Override
    public int getCollisions() {
        return this.collisionDetector.getCollisions();
    }
}
