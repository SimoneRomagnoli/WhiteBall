package com.example.whiteball.controller;

import com.example.whiteball.model.Model;
import com.example.whiteball.model.entities.Entity;

import java.util.List;

public interface Controller {

    Model getModel();

    void startGameLoop();

    Double getAvgFPS();

    List<Entity> getEntities();

    void update();
}
