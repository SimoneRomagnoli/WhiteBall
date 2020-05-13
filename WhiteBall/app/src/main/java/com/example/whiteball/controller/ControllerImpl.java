package com.example.whiteball.controller;

import android.widget.Toast;

import com.example.whiteball.Constants;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.EntityType;
import com.example.whiteball.view.GameView;
import com.example.whiteball.model.Model;

import java.util.List;

public class ControllerImpl implements Controller {

    private GameView gameView;
    private Model model;
    private GameLoop gameLoop;
    private InputManager inputManager;

    public ControllerImpl(Model model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        this.inputManager = new InputManager(this);
    }

    @Override
    public void startGameLoop() {
        this.gameLoop = new GameLoop(this.gameView, this);
        this.gameLoop.startGameLoop();
    }

    //@Override
    public void stopGameLoop() {
        this.gameLoop.stopGameLoop();
    }

    @Override
    public Double getAvgFPS() {
        return this.gameLoop.getAvgFPS();
    }

    @Override
    public List<Entity> getEntities() {
        return this.model.getEntities();
    }

    @Override
    public void update() {
        this.inputManager.execute(this.model);
        this.model.update();
        if(this.anyCollision()) {
            Toast.makeText(Constants.CURRENT_CONTEXT, "Collisione trovata", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean anyCollision() {
        boolean collisions = false;
        Entity player = this.model.getPlayer();
        List<Entity> entities = this.model.getEntities();

        for (Entity entity:entities) {
            if(entity.getType() != EntityType.BALL) {
                if(!player.getArea().getRegion().quickReject(entity.getArea().getRegion())) {
                    collisions = true;
                }
            }
        }
        return collisions;
    }

}
