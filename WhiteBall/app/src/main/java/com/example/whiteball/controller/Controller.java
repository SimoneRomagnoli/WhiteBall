package com.example.whiteball.controller;


import com.example.whiteball.model.Model;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.ViewEntity;

import java.util.List;

public interface Controller {

    List<Entity> getEntities();

    Model getModel();
}
