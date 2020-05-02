package com.example.whiteball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.whiteball.controller.Controller;
import com.example.whiteball.controller.ControllerImpl;
import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;
import com.example.whiteball.scene.Scene;
import com.example.whiteball.scene.SceneImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Model model = new ModelImpl();
        final Scene scene = new SceneImpl();
        final Controller controller = new ControllerImpl(model, scene);
    }
}
