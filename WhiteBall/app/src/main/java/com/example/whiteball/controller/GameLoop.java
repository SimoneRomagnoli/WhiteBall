package com.example.whiteball.controller;

import com.example.whiteball.model.Model;
import com.example.whiteball.view.GameView;

public class GameLoop extends Thread {
    private static final int FPS = 30;

    private final long frameRate;

    private GameView gameView;
    private Model model;

    private double avgFPS = 0;
    private boolean isRunning;

    public GameLoop(GameView gameView, Model model) {
        super();
        this.isRunning = false;

        this.gameView = gameView;
        this.model = model;
        this.frameRate = (long) (1 / (this.FPS * 0.001));
    }

    @Override
    public void run() {
        super.run();
        int frameCount = 0;
        long lastTime = System.currentTimeMillis();
        long totalTime = lastTime;
        while(this.isRunning) {
            final long currentTime = System.currentTimeMillis();

            //Heart of the game loop: taking input, updating and rendering
            this.processInput();
            final long elapsedTime = currentTime - lastTime;
            this.update(elapsedTime);
            this.render();
            frameCount++;

            //Pause game loop to reach the target FPS
            this.waitForNextFrame(currentTime);

            //Calculate FPS
            totalTime += elapsedTime;
            if(totalTime >= 1000) {
                avgFPS =  frameCount / (1E+3 * totalTime);
                frameCount = 0;
                totalTime = System.currentTimeMillis();
            }
            lastTime = currentTime;
        }
    }

    public double getAvgFPS() {
        return this.avgFPS;
    }

    public void startGameLoop() {
        this.isRunning = true;
        this.start();
    }

    public void stopGameLoop() {
        this.isRunning = false;
    }

    private void processInput() {

    }

    private void render() {
        this.gameView.render();
    }

    private void update(final double elapsedTime) {
        this.model.update();
    }

    private void waitForNextFrame(final long currentTime) {
        final long dt = System.currentTimeMillis() - currentTime;
        if (dt < this.frameRate) {
            try {
                Thread.sleep(this.frameRate - dt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
