package com.example.whiteball.scene;

import com.example.whiteball.controller.Controller;

public interface Scene {

    /**
     * Initialize the scene passing the controller
     */
    void launch(Controller controller);
}
