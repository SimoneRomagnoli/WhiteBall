package com.example.whiteball;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.whiteball.controller.Controller;
import com.example.whiteball.controller.ControllerImpl;
import com.example.whiteball.view.GameView;

public class MainActivity extends AppCompatActivity {
    public static Point DISPLAY_SIZE = new Point();

    private GameView gameView;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.gameView = new GameView(this);
        this.controller = new ControllerImpl(this.gameView);
        setContentView(gameView);

    }
}
