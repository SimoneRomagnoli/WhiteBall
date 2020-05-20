package com.example.whiteball;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

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

    private GameView gameView;
    private Controller controller;
    private Model model;
    private Button pauseButton;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);

        FrameLayout gameLayout = root.findViewById(R.id.game_layout);

        this.model = new ModelImpl();
        this.gameView = new GameViewImpl(Constants.CURRENT_CONTEXT);
        this.controller = new ControllerImpl(this.model, this.gameView);
        this.gameView.launch(this.controller);
        ((View)this.gameView).setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        gameLayout.addView((View) this.gameView);

        this.pauseButton = root.findViewById(R.id.pause_button);
        this.pauseButton.getLayoutParams().width = Constants.SCREEN_WIDTH/10;
        this.pauseButton.getLayoutParams().height = Constants.SCREEN_WIDTH/10;
        this.pauseButton.setOnClickListener(v -> {
            if(this.controller.isGameLoopPaused()) {
                this.controller.resumeGameLoop();
                this.pauseButton.setBackgroundResource(R.drawable.pause);
            } else {
                this.controller.pauseGameLoop();
                this.pauseButton.setBackgroundResource(R.drawable.resume);
            }
        });

        return root;
    }
}
