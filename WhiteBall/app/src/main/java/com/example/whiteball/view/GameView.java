package com.example.whiteball.view;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.SensorManager;
import android.view.SurfaceHolder;

import com.example.whiteball.controller.Controller;

public interface GameView {

    void launch(Controller controller);

    void render();
}
