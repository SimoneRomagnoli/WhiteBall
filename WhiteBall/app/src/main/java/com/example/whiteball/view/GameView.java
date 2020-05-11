package com.example.whiteball.view;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.example.whiteball.controller.Controller;

public interface GameView extends SurfaceHolder.Callback {

    void launch(Controller controller);

    //void draw(Canvas canvas);

    void render();

    SurfaceHolder getSurfaceHolder();

}
