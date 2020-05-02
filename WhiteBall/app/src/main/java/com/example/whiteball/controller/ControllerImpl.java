package com.example.whiteball.controller;

import com.example.whiteball.model.Model;
import com.example.whiteball.scene.Scene;

public class ControllerImpl implements Controller {

    private Model model;
    private Scene scene;

    public ControllerImpl(Model model, Scene scene) {
        this.model = model;
        this.scene = scene;

        //Init scene
        this.scene.launch(this);
    }
}
