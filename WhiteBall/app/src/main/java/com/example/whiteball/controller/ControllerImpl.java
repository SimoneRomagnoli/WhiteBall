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
    //private GameLoop gameLoop;

    public ControllerImpl() {
        this.model = new ModelImpl();
        //this.gameLoop = new GameLoop(gameView.getHolder(), gameView);
    }

    @Override
    public List<Entity> getEntities() {
        return this.model.getEntities();
    }

    @Override
    public Model getModel() {
        return this.model;
    }

}
