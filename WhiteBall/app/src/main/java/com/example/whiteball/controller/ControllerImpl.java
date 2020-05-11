package com.example.whiteball.controller;

import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;
public class ControllerImpl implements Controller {

    private Model model;

    public ControllerImpl() {
        this.model = new ModelImpl();
    }

    @Override
    public Model getModel() {
        return this.model;
    }

}
