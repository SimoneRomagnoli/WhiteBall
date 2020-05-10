package com.example.whiteball.controller;

import com.example.whiteball.gameview.GameView;
import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.ViewEntity;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    private Model model;
    private GameView gameView;
    //private GameLoop gameLoop;

    public ControllerImpl(GameView gameView) {
        this.model = new ModelImpl();
        //this.gameLoop = new GameLoop(gameView.getHolder(), gameView);
        this.gameView = gameView;
    }

    @Override
    public List<ViewEntity> getSceneEntities() {
        return toSceneEntities(this.model.getEntities());
    }

    @Override
    public Model getModel() {
        return this.model;
    }

    private List<ViewEntity> toSceneEntities(List<Entity> entities) {
        List<ViewEntity> list = new ArrayList<>();
        for (Entity entity:entities) {
            list.add(new ViewEntity(entity));
        }
        return list;
    }

}
