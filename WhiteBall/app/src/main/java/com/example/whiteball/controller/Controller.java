package com.example.whiteball.controller;


import com.example.whiteball.model.Model;
import com.example.whiteball.model.entities.ViewEntity;

import java.util.List;

public interface Controller {

    List<ViewEntity> getSceneEntities();

    Model getModel();
}
