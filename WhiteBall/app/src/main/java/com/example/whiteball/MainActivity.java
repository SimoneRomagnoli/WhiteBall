package com.example.whiteball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.whiteball.controller.Controller;
import com.example.whiteball.controller.ControllerImpl;
import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.EntityImpl;
import com.example.whiteball.model.entities.EntityType;
import com.example.whiteball.scene.Scene;
import com.example.whiteball.scene.SceneImpl;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final Map<EntityType, Integer> LAYOUT_MAP;
    static {
        LAYOUT_MAP = ImmutableMap.of(
                EntityType.BALL, R.layout.ball,
                EntityType.SQUARE, R.layout.square
        );
    }

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.controller = new ControllerImpl(this);
        render();
    }

    public void render() {
        for (Entity entity:this.controller.getSceneEntities()) {
            View inflatedLayout = LayoutInflater.from(MainActivity.this).inflate(LAYOUT_MAP.get(entity.getType()), null, false);
            ((LinearLayout)findViewById(R.id.main_activity)).addView(inflatedLayout);
        }
    }
}
