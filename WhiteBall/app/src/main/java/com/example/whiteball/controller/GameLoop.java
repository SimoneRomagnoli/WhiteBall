package com.example.whiteball.controller;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.example.whiteball.model.Model;
import com.example.whiteball.view.GameView;

public class GameLoop extends Thread {

    private static final int FPS = 30;
    private static final double PERIOD = 1E+3 / FPS;
    //public static Canvas canvas;

    //private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private Model model;

    private double avgFPS = 0;
    private boolean running;

    public GameLoop(GameView gameView, Model model) {
        super();
        this.running = false;

        //this.surfaceHolder = gameView.getSurfaceHolder();
        this.gameView = gameView;
        this.model = model;
    }

    @Override
    public void run() {
        super.run();

        long startTime;
        long elapsedTime;
        long sleepTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000/FPS;

        startTime = System.currentTimeMillis();
        while(running) {

            //Heart of the game loop, updating and rendering
            /*try{
                canvas = this.gameView.getSurfaceHolder().lockCanvas();
                synchronized (this.gameView.getSurfaceHolder()) {
                    this.gameView.draw(canvas);
                    this.model.update();
                }
                this.gameView.getSurfaceHolder().unlockCanvasAndPost(canvas);

                frameCount++;
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            this.gameView.render();
            this.model.update();
            frameCount++;

            //Pause game loop to reach the target FPS
            elapsedTime = System.currentTimeMillis() - startTime;
            sleepTime = (long)(frameCount*PERIOD - elapsedTime);
            if(sleepTime > 0) {
                try {
                    this.sleep(sleepTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //Calculate FPS
            elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime >= 1000) {
                avgFPS =  frameCount / (1E-3 * elapsedTime);
                frameCount = 0;
                startTime = System.currentTimeMillis();
            }
        }
    }

    public double getAvgFPS() {
        return this.avgFPS;
    }

    public void startGameLoop() {
        running = true;
        start();
    }

    public void stopGameLoop() {
        running = false;
    }
}
