package com.example.whiteball.controller;

import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.view.GameView;
import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;

import java.util.List;

public class ControllerImpl implements Controller {

    private GameView gameView;
    private Model model;
    private GameLoop gameLoop;

    public ControllerImpl(GameView gameView) {
        this.model = new ModelImpl();
        this.gameView = gameView;
        this.gameView.launch(this);
        this.gameLoop = new GameLoop(this.gameView.getSurfaceHolder(), this.gameView);
    }

    @Override
    public Model getModel() {
        return this.model;
    }

    @Override
    public void startGameLoop() {
        this.gameLoop.startGameLoop();
    }

    @Override
    public Double getAvgFPS() {
        return this.gameLoop.getAvgFPS();
    }

    @Override
    public List<Entity> getEntities() {
        return this.model.getEntities();
    }


}
