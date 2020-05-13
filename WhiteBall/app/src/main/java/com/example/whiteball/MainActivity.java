package com.example.whiteball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.whiteball.controller.Controller;
import com.example.whiteball.controller.ControllerImpl;
import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;
import com.example.whiteball.view.GameView;
import com.example.whiteball.view.GameViewImpl;

public class MainActivity extends AppCompatActivity {
    public static Point DISPLAY_SIZE = new Point();

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Model model = new ModelImpl();
        final GameView gameView = new GameViewImpl(this);
        this.controller = new ControllerImpl(model, gameView);
        gameView.launch(this.controller);

        setContentView((View) gameView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.controller.stopGameLoop();
    }
}