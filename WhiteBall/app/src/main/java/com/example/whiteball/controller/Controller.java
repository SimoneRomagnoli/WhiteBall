package com.example.whiteball.controller;

import com.example.whiteball.model.Model;

public interface Controller {

    Model getModel();

    void startGameLoop();

    Double getAvgFPS();
}
