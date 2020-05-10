package com.example.whiteball.gameview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
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
import com.example.whiteball.model.entities.EntityType;
import com.example.whiteball.model.entities.ViewEntity;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private static final Map<EntityType, Integer> LAYOUT_MAP;
    static {
        LAYOUT_MAP = ImmutableMap.of(
                EntityType.BALL, R.drawable.ball,
                EntityType.SQUARE, R.drawable.square
        );
    }

    private Controller controller;
    private Context context;
    private GameLoop gameLoop;

    public GameView(Context context) {
        super(context);

        this.context = context;
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.gameLoop = new GameLoop(surfaceHolder, this);
        this.controller = new ControllerImpl(this);

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

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawFPS(canvas);
        //render(canvas);
    }

    public void drawFPS(Canvas canvas) {
        String averageFPS = Double.toString(this.gameLoop.getAvgFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(20);
        canvas.drawText("FPS "+ averageFPS , 100, 20, paint);
    }

    public void render(Canvas canvas) {
        //((LinearLayout)findViewById(R.id.main_activity)).removeAllViews();

        for (ViewEntity entity:this.controller.getSceneEntities()) {
            //View inflatedLayout = LayoutInflater.from(this.context).inflate(LAYOUT_MAP.get(entity.getType()), null, false);
            //inflatedLayout.setX((float) entity.getPosition().getX());
            //inflatedLayout.setY((float) entity.getPosition().getY());

            //inflatedLayout.draw(canvas);
            //System.out.println(inflatedLayout.getX());
            //System.out.println(inflatedLayout.getY());
            //((LinearLayout) findViewById(R.id.main_activity)).addView(inflatedLayout);
        }
    }
}
