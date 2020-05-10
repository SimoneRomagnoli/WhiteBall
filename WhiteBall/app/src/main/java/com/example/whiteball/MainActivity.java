package com.example.whiteball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.whiteball.controller.Controller;
import com.example.whiteball.controller.ControllerImpl;
import com.example.whiteball.gameview.GameView;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.EntityType;
import com.example.whiteball.model.entities.ViewEntity;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(new GameView(this));

    }
}
