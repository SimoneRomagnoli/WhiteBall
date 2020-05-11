package com.example.whiteball.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.core.content.ContextCompat;

import com.example.whiteball.R;
import com.example.whiteball.controller.Controller;
import com.example.whiteball.model.entities.Entity;

import java.util.List;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private Context context;
    private Controller controller;

    public GameView(Context context) {
        super(context);
        this.context = context;

        getHolder().addCallback(this);

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.controller.startGameLoop();
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
        //this.printFPS(canvas);
        render(canvas);
    }

    public void launch(Controller controller) {
        this.controller = controller;
    }

    public SurfaceHolder getSurfaceHolder() {
        return getHolder();
    }

    private void printFPS(Canvas canvas) {
        String str = Double.toString(this.controller.getAvgFPS());
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(this.context, R.color.magenta));
        paint.setTextSize(20);
        canvas.drawText("FPS: "+str, 10, 20, paint);
    }

    private void render(Canvas canvas) {
        List<Entity> entities = this.controller.getEntities();
        for(Entity entity:entities) {
            entity.draw(canvas);
        }
    }
}
