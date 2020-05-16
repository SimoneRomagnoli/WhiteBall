package com.example.whiteball.model;

import android.graphics.Point;

import com.example.whiteball.Constants;
import com.example.whiteball.model.entities.Ball;
import com.example.whiteball.model.entities.CollisionDetector;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.Square;
import com.example.whiteball.model.entities.properties.Velocity;
import com.example.whiteball.model.entities.properties.VelocityImpl;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private final int Y_COORDINATE = Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT / 10;
    private List<Entity> entities;
    private Ball player;
    private CollisionDetector collisionDetector;

    public ModelImpl() {
        this.entities = new ArrayList<>();
        this.collisionDetector = new CollisionDetector();

        this.player = new Ball(new Point(Constants.SCREEN_WIDTH / 2, Y_COORDINATE), Constants.PLAYER_RADIUS_INT);
        this.entities.add(this.player);

        Square square = new Square(new Point(Constants.SCREEN_WIDTH / 2, 0), Constants.SQUARE_EDGE / 2);
        square.setVelocity(new VelocityImpl(0, 6));
        this.entities.add(square);
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public void update() {
        for (Entity entity: this.entities) {
            Point old = entity.getPosition();
            if(old.x > Constants.SCREEN_WIDTH) {
                entity.setPosition(new Point(0, old.y));
            } else if(old.x < 0) {
                entity.setPosition(new Point(Constants.SCREEN_WIDTH, old.y));
            } else if(old.y > Constants.SCREEN_HEIGHT) {
                entity.setPosition(new Point(old.x, 0));
            } else if(old.y < 0) {
                entity.setPosition(new Point(old.x, Constants.SCREEN_HEIGHT));
            } else {
                Velocity velocity = entity.getVelocity();
                entity.setPosition(new Point(old.x + velocity.getX(), old.y + velocity.getY()));
            }
        }
        this.collisionDetector.anyCollision(this.player, this.entities);
    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override
    public Entity getPlayer() {
        return this.player;
    }

    @Override
    public void executeInput(float input) {
        if(input > -1f && input < 1f) {
            this.player.setVelocity(new VelocityImpl(0, 0));
        } else {
            this.player.setVelocity(new VelocityImpl(-(int)(input * Constants.GYROSCOPE_SENSITIVITY), 0));
        }
    }
}
