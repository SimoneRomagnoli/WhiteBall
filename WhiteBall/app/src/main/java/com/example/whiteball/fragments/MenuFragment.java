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

import com.example.whiteball.Constants;
import com.example.whiteball.R;
import com.example.whiteball.fragments.GameFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private FragmentManager manager;

    private FrameLayout menuLayout;
    private Button startButton;
    private Button settingsButton;
    private Button exitButton;

    public MenuFragment(FragmentManager manager) {
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

        Constants.FPS = 60;

        this.menuLayout = root.findViewById(R.id.fragment_menu);
        this.menuLayout.setBackgroundColor(Color.BLACK);

        this.startButton = root.findViewById(R.id.start_button);
        this.startButton.setOnClickListener(v -> {
            FragmentTransaction t = this.manager.beginTransaction();
            GameFragment gameFragment = new GameFragment(this.manager);
            t.add(R.id.fragment_container, gameFragment);
            t.commit();
        });

        this.settingsButton = root.findViewById(R.id.settings_button);
        this.settingsButton.setOnClickListener(v -> {
            FragmentTransaction t = this.manager.beginTransaction();
            SettingsFragment settingsFragment = new SettingsFragment(this.manager);
            t.add(R.id.fragment_container, settingsFragment);
            t.commit();
        });

        this.exitButton = root.findViewById(R.id.close_app_button);
        this.exitButton.setOnClickListener(v -> {
            //come si chiude la applicazione?
        });

        return root;
    }
}
