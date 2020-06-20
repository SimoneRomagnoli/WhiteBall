package com.example.whiteball.controller;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.whiteball.model.GameMode;
import com.example.whiteball.utility.Constants;
import com.example.whiteball.R;
import com.example.whiteball.fragments.GameOverFragment;
import com.example.whiteball.model.Model;
import com.example.whiteball.view.GameView;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class GameLoop extends Thread {
    private final long frameRate;

    private FragmentManager manager;
    private GameView gameView;
    private Model model;
    private double avgFPS = 0;
    private boolean isRunning;
    private boolean paused;
    private List<Command> commands;

    public GameLoop(GameView gameView, Model model, FragmentManager manager) {
        super();
        this.isRunning = false;
        this.paused = false;

        this.manager = manager;
        this.gameView = gameView;
        this.model = model;
        this.frameRate = (long) (1 / (Constants.FPS * 0.001));
        this.commands = new ArrayList<>();
    }

    @Override
    public void run() {
        super.run();
        int frameCount = 0;
        long lastTime = System.currentTimeMillis();
        long startTime = lastTime;
        while(this.isRunning) {
            final long currentTime = System.currentTimeMillis();

            if(this.model.isGameOver()) {
                this.stopGameLoop();
                checkScore();
            }

            //Heart of the game loop: taking input, updating and rendering
            this.processInput();
            final long elapsedTime = currentTime - lastTime;

            if(!this.paused) {
                this.update(elapsedTime);
                //la render viene fatta automaticamente dalla view
            }

            frameCount++;

            //Pause game loop to reach the target FPS
            this.waitForNextFrame(currentTime);

            //Calculate FPS
            long frameTime = System.currentTimeMillis() - startTime;
            if(frameTime >= 1000) {
                avgFPS =  frameCount / (1E-3 * frameTime);
                frameCount = 0;
                startTime = System.currentTimeMillis();
            }

            lastTime = currentTime;
        }

        FragmentTransaction t = this.manager.beginTransaction();
        GameOverFragment gameOverFragment = new GameOverFragment(this.manager);
        t.add(R.id.fragment_container, gameOverFragment);
        t.commit();
    }

    private void checkScore() {
        SharedPreferences sp = Constants.CURRENT_CONTEXT.getSharedPreferences(Constants.CURRENT_CONTEXT.getString(R.string.preferences), Context.MODE_PRIVATE);
        long defaultValue = 0;
        long newHighScore = this.model.getElapsedTime();

        if(Constants.GAME_MODE.equals(GameMode.X)) {
            long oldHighScore = sp.getLong(Constants.CURRENT_CONTEXT.getString(R.string.x_high_score), defaultValue);
            if(newHighScore > oldHighScore) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putLong(Constants.CURRENT_CONTEXT.getString(R.string.x_high_score), newHighScore);
                editor.commit();
            }
        } else if(Constants.GAME_MODE.equals(GameMode.Y)) {
            long oldHighScore = sp.getLong(Constants.CURRENT_CONTEXT.getString(R.string.y_high_score), defaultValue);
            if(newHighScore > oldHighScore) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putLong(Constants.CURRENT_CONTEXT.getString(R.string.y_high_score), newHighScore);
                editor.commit();
            }
        } else if(Constants.GAME_MODE.equals(GameMode.XY)) {
            long oldHighScore = sp.getLong(Constants.CURRENT_CONTEXT.getString(R.string.xy_high_score), defaultValue);
            if(newHighScore > oldHighScore) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putLong(Constants.CURRENT_CONTEXT.getString(R.string.xy_high_score), newHighScore);
                editor.commit();
            }
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

    public boolean isRunning() { return this.isRunning; }

    public void addInput(Command command) {
        this.commands.add(command);
    }

    public boolean isPaused() { return this.paused; };

    public void pauseLoop() { this.paused = true; }

    public void resumeLoop() { this.paused = false; }

    private void processInput() {
        this.model.resolveInputs(ImmutableList.copyOf(this.commands));
        this.commands = new ArrayList<>();
    }

    private void update(final long elapsedTime) {
        this.model.update(elapsedTime);
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
