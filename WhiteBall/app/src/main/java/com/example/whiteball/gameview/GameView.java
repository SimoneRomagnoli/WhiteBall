package com.example.whiteball.gameview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.example.whiteball.R;
import com.example.whiteball.controller.Controller;
import com.example.whiteball.controller.ControllerImpl;
import com.example.whiteball.controller.GameLoop;
import com.example.whiteball.model.entities.Entity;
import com.example.whiteball.model.entities.EntityType;
import com.example.whiteball.model.entities.ViewEntity;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private static final Map<EntityType, Integer> COLORS_MAP;
    static {
        COLORS_MAP = ImmutableMap.of(
                EntityType.BALL, R.color.white,
                EntityType.SQUARE, R.color.magenta
        );
    }

    private Controller controller;
    private Context context;
    private GameLoop gameLoop;
    private boolean bool = true;

    public GameView(Context context) {
        super(context);

        this.context = context;
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.gameLoop = new GameLoop(surfaceHolder, this);
        this.controller = new ControllerImpl();

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameLoop.startGameLoop();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        //System.out.println(Double.toString(this.gameLoop.getAvgFPS()));
        //rawFPS(canvas);
        //render(canvas);
        if(this.bool) {
            Rect r = new Rect(100, 100, 100, 100);
            Paint paint = new Paint();
            paint.setColor(ContextCompat.getColor(context, R.color.magenta));
            canvas.drawRect(r, paint);
            this.bool = false;
        }
    }

    public void drawFPS(Canvas canvas) {
        String averageFPS = Double.toString(this.gameLoop.getAvgFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(20);
        canvas.drawText("FPS "+ averageFPS , 100, 20, paint);
    }

    private void render(Canvas canvas) {
        for (ViewEntity entity:toSceneEntities(this.controller.getEntities())) {
            Paint paint = new Paint();
            paint.setColor(ContextCompat.getColor(context, R.color.white));
            entity.getShape().draw(canvas, paint);
        }
    }

    private List<ViewEntity> toSceneEntities(List<Entity> entities) {
        List<ViewEntity> list = new ArrayList<>();
        for (Entity entity:entities) {
            list.add(new ViewEntity(entity, COLORS_MAP.get(entity.getType())));
        }
        return list;
    }
}
