package com.example.whiteball.model;

import android.graphics.Point;

import com.example.whiteball.Constants;
import com.example.whiteball.controller.Command;
import com.example.whiteball.model.entities.Ball;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.EntityFactoryImpl;
import com.example.whiteball.model.entities.Rhombus;
import com.example.whiteball.model.entities.Square;
import com.example.whiteball.model.entities.Triangle;
import com.example.whiteball.model.entities.components.CollisionComponent;
import com.example.whiteball.model.entities.properties.Vector2DImpl;
import com.example.whiteball.model.entities.components.Component;
import com.example.whiteball.model.entities.components.ComponentType;
import com.example.whiteball.model.entities.components.InputComponent;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
    private final int Y_COORDINATE = Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 10;

    private List<Entity> entities;
    private Ball player;
    private long time;

    public ModelImpl() {
        this.time = 0;
        this.entities = new ArrayList<>();
        this.player = (Ball)EntityFactoryImpl.createBall(new Point(Constants.SCREEN_WIDTH / 2, Y_COORDINATE));
        this.player.declarePlayer();
        this.entities.add(this.player);

        Square square = (Square)EntityFactoryImpl.createSquare(new Point(200, 0));
        square.setVelocity(new Vector2DImpl(0, 1));
        this.entities.add(square);

        Triangle triangle = (Triangle)EntityFactoryImpl.createTriangle(new Point(500, 0));
        triangle.setVelocity(new Vector2DImpl(0, 1));
        this.entities.add(triangle);

        Rhombus rhombus = (Rhombus)EntityFactoryImpl.createRhombus(new Point(800, 200));
        rhombus.setVelocity(new Vector2DImpl(0, 2));
        this.entities.add(rhombus);
    }

    @Override
    public boolean isGameOver() {
        for(Component component: this.player.getComponents()) {
            if(component.getType().equals(ComponentType.COLLISION)) {
                return ((CollisionComponent)component).anyCollision();
            }
        }
        return false;
    }

    @Override
    public void update(final long dt) {
        this.time += dt;

        for (Entity entity: this.entities) {
            if (entity.isPlayer()) {
                for(Component component: entity.getComponents()) {
                    if(component.getType().equals(ComponentType.COLLISION)) {
                        ((CollisionComponent)component).updateEntities(this.entities);
                    }
                }
            }
            entity.update(dt);
        }
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
            for(Component component: entity.getComponents()) {
                if(component.getType().equals(ComponentType.INPUT)) {
                    ((InputComponent)component).collectInputs(inputs);
                }
            }
        }
    }

    @Override
    public long getElapsedTime() {
        return this.time;
    }
}
