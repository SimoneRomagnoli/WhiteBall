package com.example.whiteball;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.whiteball.controller.Controller;
import com.example.whiteball.controller.ControllerImpl;
import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;
import com.example.whiteball.view.GameView;
import com.example.whiteball.view.GameViewImpl;

public class MainActivity extends FragmentActivity {

    private Controller controller;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display display = getWindowManager().getDefaultDisplay();
        Point outSize = new Point();
        display.getSize(outSize);
        Constants.SCREEN_WIDTH = outSize.x;
        Constants.SCREEN_HEIGHT = outSize.y;
        */
        /*
        final Model model = new ModelImpl();
        final GameView gameView = new GameViewImpl(this);
        this.controller = new ControllerImpl(model, gameView);
        gameView.launch(this.controller);


        setContentView((View) gameView);
        */

        Constants.CURRENT_CONTEXT = this;

        setContentView(R.layout.activity_main);
        this.manager = getSupportFragmentManager();
        FragmentTransaction transaction = this.manager.beginTransaction();
        MenuFragment menuFragment = new MenuFragment(this.manager);
        transaction.add(R.id.fragment_container, menuFragment);
        transaction.commit();

    }

    @Override
    protected void onPause() {
        super.onPause();
        this.controller.stopGameLoop();
    }
}
