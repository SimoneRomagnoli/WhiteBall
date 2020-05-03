package com.example.whiteball.controller;

import com.example.whiteball.MainActivity;
import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.ViewEntity;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    private Model model;
    private MainActivity main;

    public ControllerImpl(MainActivity main) {
        this.model = new ModelImpl();
        this.main = main;
    }


    @Override
    public List<ViewEntity> getSceneEntities() {
        return toSceneEntities(this.model.getEntities());
    }

    private List<ViewEntity> toSceneEntities(List<Entity> entities) {
        List<ViewEntity> list = new ArrayList<>();
        for (Entity entity:entities) {
            list.add(new ViewEntity(entity));
        }
        return list;
    }
}
