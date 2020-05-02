package com.example.whiteball.scene;

import com.example.whiteball.controller.Controller;
import com.example.whiteball.model.entities.EntityType;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class SceneImpl implements Scene {

    private static final Map<EntityType, Integer> LAYOUT_MAP;
    private Controller controller;

    static {
        LAYOUT_MAP = ImmutableMap.of(
                //EntityType.BALL, R.id.ball
        );
    }

    @Override
    public void launch(Controller controller) {
        this.controller = controller;
    }
}
