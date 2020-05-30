package com.example.whiteball.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.whiteball.utility.Constants;
import com.example.whiteball.R;
import com.example.whiteball.controller.Controller;
import com.example.whiteball.controller.ControllerImpl;
import com.example.whiteball.model.Model;
import com.example.whiteball.model.ModelImpl;
import com.example.whiteball.view.GameView;
import com.example.whiteball.view.GameViewImpl;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    private FragmentManager manager;

    private GameView gameView;
    private Controller controller;
    private Model model;

    private FrameLayout gameLayout;
    private Button pauseButton;

    private LinearLayout pausedLayout;
    private Button resumeButton;
    private Button restartButton;
    private Button exitButton;

    public GameFragment(FragmentManager manager) {
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);

        //GAME LAYOUT AND MVC
        this.gameLayout = root.findViewById(R.id.game_layout);
        this.gameLayout.setBackgroundColor(Color.BLACK);

        this.newGame();

        this.pauseButton = root.findViewById(R.id.pause_button);
        this.pauseButton.getLayoutParams().width = Constants.SCREEN_WIDTH/10;
        this.pauseButton.getLayoutParams().height = Constants.SCREEN_WIDTH/10;
        this.pauseButton.setOnClickListener(v -> {
            if(this.controller.isGameLoopRunning()) {
                if (this.controller.isGameLoopPaused()) {
                    this.pausedLayout.setVisibility(View.INVISIBLE);
                    this.controller.resumeGameLoop();
                    this.pauseButton.setBackgroundResource(R.drawable.pause);
                } else {
                    this.pausedLayout.setVisibility(View.VISIBLE);
                    this.controller.pauseGameLoop();
                    this.pauseButton.setBackgroundResource(R.drawable.resume);
                }
            }
        });

        //PAUSED LAYOUT
        this.pausedLayout = root.findViewById(R.id.paused_layout);
        this.pausedLayout.setVisibility(View.INVISIBLE);
        this.pausedLayout.getLayoutParams().height = Constants.SCREEN_HEIGHT/5;

        this.resumeButton = root.findViewById(R.id.resume_button);
        this.resumeButton.setOnClickListener(v -> {
            if(this.controller.isGameLoopPaused()) {
                this.pausedLayout.setVisibility(View.INVISIBLE);
                this.controller.resumeGameLoop();
                this.pauseButton.setBackgroundResource(R.drawable.pause);
            }
        });

        this.restartButton = root.findViewById(R.id.restart_button);
        this.restartButton.setOnClickListener(v -> {
            FragmentTransaction t = this.manager.beginTransaction();
            GameFragment gameFragment = new GameFragment(this.manager);
            t.add(R.id.fragment_container, gameFragment);
            t.commit();
        });

        this.exitButton = root.findViewById(R.id.exit_button);
        this.exitButton.setOnClickListener(v -> {
            this.controller.stopGameLoop();

            FragmentTransaction t = this.manager.beginTransaction();
            MenuFragment menuFragment = new MenuFragment(this.manager);
            t.add(R.id.fragment_container, menuFragment);
            t.commit();
        });

        return root;
    }

    private void newGame() {
        this.model = new ModelImpl();
        this.gameView = new GameViewImpl(Constants.CURRENT_CONTEXT);
        this.controller = new ControllerImpl(this.model, this.gameView, this.manager);
        this.gameView.launch(this.controller);
        ((View)this.gameView).setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        this.gameLayout.addView((View) this.gameView);
    }
}
