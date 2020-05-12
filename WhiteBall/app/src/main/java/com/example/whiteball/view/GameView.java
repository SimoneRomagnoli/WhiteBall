package com.example.whiteball.view;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.SensorManager;
import android.view.SurfaceHolder;

import com.example.whiteball.controller.Controller;

public interface GameView extends SurfaceHolder.Callback {

    void launch(Controller controller);

    void render();

    SurfaceHolder getSurfaceHolder();

}
