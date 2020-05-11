package com.example.whiteball;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.whiteball.controller.GameLoop;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private Context context;
    private GameLoop gameLoop;

    public GameView(Context context) {
        super(context);
        this.context = context;

        getHolder().addCallback(this);

        this.gameLoop = new GameLoop(getHolder(), this);

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.gameLoop.startGameLoop();
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
        String str = Double.toString(this.gameLoop.getAvgFPS());
        Paint paint = new Paint();
        paint.setColor(R.color.magenta);
        paint.setTextSize(20);
        canvas.drawText("FPS: "+str, 10, 20, paint);
    }

}
