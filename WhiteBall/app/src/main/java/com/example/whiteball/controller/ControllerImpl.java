package com.example.whiteball.controller;

import com.example.whiteball.GameView;
import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;
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


}
