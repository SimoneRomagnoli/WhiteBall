package com.example.whiteball.model.entities.build;

import android.graphics.Point;

import com.example.whiteball.model.GameMode;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.utility.Constants;

import java.util.List;
import java.util.Random;

public class SpawnerImpl implements Spawner {
    private final long QUART_MINUTE = Constants.MINUTE_LONG / 4;

    private long spawningPeriod;
    private long lastSpawned;
    private int spawningVelocity;
    private boolean isSpawning;
    private Random random;
    private EntityFactory factory;

    public SpawnerImpl() {
        this.factory = new EntityFactoryImpl();
        this.random = new Random();
        this.isSpawning = false;
        this.lastSpawned = 0;
        this.spawningVelocity = 1;
        this.spawningPeriod = 2000;
    }

    @Override
    public void update(List<Entity> entities, long time) {
        if(this.isSpawning && time - this.lastSpawned > this.spawningPeriod) {
            Point position = Constants.GAME_MODE == GameMode.X ? new Point(random.nextInt(Constants.SCREEN_WIDTH), -50) :
                                Constants.GAME_MODE == GameMode.Y ? new Point(time % 2 == 0 ? -50 : Constants.SCREEN_WIDTH+50, random.nextInt(Constants.SCREEN_HEIGHT)) :
                                        time % 2 != 0 ? new Point(random.nextInt(Constants.SCREEN_WIDTH), -50) : new Point(time % 4 == 0 ? -50 : Constants.SCREEN_WIDTH+50, random.nextInt(Constants.SCREEN_HEIGHT));

            entities.add(this.factory.createEntity(position));
            this.lastSpawned = time;
        }
        if(this.spawningVelocity < 5 && time > QUART_MINUTE * this.spawningVelocity) {
            this.spawningVelocity++;
            this.spawningPeriod /= 2;
        }
    }

    @Override
    public void start() {
        this.isSpawning = true;
    }

    @Override
    public boolean isSpawning() {
        return this.isSpawning;
    }
}
