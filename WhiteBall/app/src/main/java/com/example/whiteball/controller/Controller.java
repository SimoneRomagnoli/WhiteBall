package com.example.whiteball.controller;

import com.example.whiteball.model.Model;
import com.example.whiteball.model.entities.Entity;

import java.util.List;

public interface Controller {

    void startGameLoop();

    void stopGameLoop();

    Double getAvgFPS();

    List<Entity> getEntities();

    void update();
}
