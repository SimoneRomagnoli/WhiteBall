package com.example.whiteball.controller;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import androidx.fragment.app.Fragment;

import com.example.whiteball.GameView;

public class GameLoop extends Thread {

    //private Model model;
    //private MainActivity activity;
    //private boolean running;
    //private boolean paused;

    private static final int FPS = 30;
    private static final double PERIOD = 1E+3 / FPS;
    private final GameView gameView;
    private double avgFPS = 0;
    private SurfaceHolder surfaceHolder;
    private boolean running;
    public static Canvas canvas;

    public GameLoop(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.running = false;
        //this.paused = false;
        //this.model = model;
        //this.activity = activity;

        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
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
            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameView.draw(canvas);
                }
                surfaceHolder.unlockCanvasAndPost(canvas);

                frameCount++;
            } catch (Exception e) {
                e.printStackTrace();
            }

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


    public void setRunning(boolean isRunning) {
        this.running = isRunning;
    }

    public double getAvgFPS() {
        return this.avgFPS;
    }

    public void startGameLoop() {
        running = true;
        start();
    }
}
