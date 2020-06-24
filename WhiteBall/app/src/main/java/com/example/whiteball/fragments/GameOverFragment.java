package com.example.whiteball.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.whiteball.utility.Constants;
import com.example.whiteball.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameOverFragment extends Fragment {

    private FragmentManager manager;

    private LinearLayout gameOverLayout;
    private Button retryButton;
    private Button goToMenuButton;

    public GameOverFragment(FragmentManager manager) {
        this.manager = manager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game_over, container, false);

        //GAME OVER LAYOUT
        this.gameOverLayout = root.findViewById(R.id.game_over_layout);
        this.gameOverLayout.setVisibility(View.VISIBLE);
        this.gameOverLayout.getLayoutParams().height = Constants.SCREEN_HEIGHT/5;

        this.retryButton = root.findViewById(R.id.retry_button);
        this.retryButton.setOnClickListener(v -> {
            FragmentTransaction t = this.manager.beginTransaction();
            GameFragment gameFragment = new GameFragment(this.manager);
            t.replace(R.id.fragment_container, gameFragment);
            t.commit();
            Constants.CURRENT_FRAGMENT = gameFragment;
        });

        this.goToMenuButton = root.findViewById(R.id.go_to_menu_button);
        this.goToMenuButton.setOnClickListener(v -> {
            FragmentTransaction t = this.manager.beginTransaction();
            MenuFragment menuFragment = new MenuFragment(this.manager);
            t.replace(R.id.fragment_container, menuFragment);
            t.commit();
            Constants.CURRENT_FRAGMENT = menuFragment;
        });

        return root;
    }
}
