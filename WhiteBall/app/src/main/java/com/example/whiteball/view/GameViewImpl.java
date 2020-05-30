package com.example.whiteball.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.example.whiteball.utility.Constants;
import com.example.whiteball.R;
import com.example.whiteball.controller.Controller;
import com.example.whiteball.model.entities.Entity;

import java.util.List;

public class GameViewImpl extends View implements GameView {

    private Context context;
    private Controller controller;

    public GameViewImpl(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.render(canvas);
        this.printElapsedTime(canvas);
        //this.printFPS(canvas);
        invalidate();
    }

    public void launch(Controller controller) {
        this.controller = controller;
        this.controller.startGameLoop();
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
        int secs = (int)(elapsed / Constants.SECOND_LONG)%60;

        String m = Integer.toString(mins);
        String s = Integer.toString(secs);

        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(this.context, R.color.white));
        paint.setTextSize(Constants.SCREEN_WIDTH/10);

        String roundS = secs < 10 ? "0" : "";
        String roundM = mins < 10 ? "0" : "";

        canvas.drawText(roundM + m + ":" + roundS + s, Constants.SCREEN_WIDTH - (int)(Constants.SCREEN_WIDTH / 4), Constants.SCREEN_WIDTH/13, paint);
    }

    private void render(Canvas canvas) {
        List<Entity> entities = this.controller.getEntities();
        for(Entity entity:entities) {
            final ViewEntity viewEntity = new ViewEntity(entity.getType(), entity.getPosition(), entity.getDimension());
            CanvasDrawer.drawCanvas(canvas, viewEntity);
        }
    }

}
