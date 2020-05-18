package com.example.whiteball.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.core.content.ContextCompat;

import com.example.whiteball.Constants;
import com.example.whiteball.R;
import com.example.whiteball.controller.Controller;
import com.example.whiteball.model.entities.Entity;

import java.util.List;

public class GameViewImpl extends SurfaceView implements GameView {

    private Context context;
    private Controller controller;
    private View pause;

    public GameViewImpl(Context context) {
        super(context);
        this.context = context;

        Constants.CURRENT_CONTEXT = context;

        LayoutInflater li = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        pause = li.inflate(R.layout.pause, null);
        pause.measure(MeasureSpec.getSize(pause.getMeasuredWidth()), MeasureSpec.getSize(pause.getMeasuredHeight()));
        pause.layout(0, 0, 0, 0);
        pause.setOnClickListener(v -> {
            controller.pauseLoop();
        });

        getHolder().addCallback(this);
        setFocusable(true);
    }

    @SuppressLint("ResourceType")
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.controller.startGameLoop();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.render(canvas);
        //this.printFPS(canvas);
        this.printElapsedTime(canvas);
        pause.draw(canvas);
    }

    @Override
    public void render() {
        try {
            Canvas canvas = this.getSurfaceHolder().lockCanvas();
            synchronized (this.getSurfaceHolder()) {
                this.draw(canvas);
            }
            this.getSurfaceHolder().unlockCanvasAndPost(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void printElapsedTime(Canvas canvas) {
        long elapsed = this.controller.getElapsedTime();
        int mins = (int)(elapsed / Constants.MINUTE_LONG);
        int secs = (int)(elapsed / Constants.SECOND_LONG);

        String m = Integer.toString(mins);
        String s = Integer.toString(secs);

        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(this.context, R.color.white));
        paint.setTextSize(100);

        String roundS = secs < 10 ? "0" : "";
        String roundM = mins < 10 ? "0" : "";

        canvas.drawText(roundM + m + ":" + roundS + s, Constants.SCREEN_WIDTH - (int)(Constants.SCREEN_WIDTH / 4.2), 85, paint);
    }

    private void render(Canvas canvas) {
        List<Entity> entities = this.controller.getEntities();
        for(Entity entity:entities) {
            final ViewEntity viewEntity = new ViewEntity(entity.getType(), entity.getPosition(), entity.getDimension());
            CanvasDrawer.drawCanvas(canvas, viewEntity);
        }
    }

}
