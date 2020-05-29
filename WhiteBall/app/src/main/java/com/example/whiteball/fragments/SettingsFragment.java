package com.example.whiteball.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.whiteball.Constants;
import com.example.whiteball.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private FragmentManager manager;

    private FrameLayout settingsLayout;

    private List<Button> fpsButtons;
    private Button fps30Button;
    private Button fps60Button;

    private Button backButton;

    public SettingsFragment(FragmentManager manager) {
        this.manager = manager;
        this.fpsButtons = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        this.settingsLayout = root.findViewById(R.id.settings_layout);
        this.settingsLayout.setBackgroundColor(Color.BLACK);

        this.fps30Button = root.findViewById(R.id.fps_30_button);
        this.fpsButtons.add(fps30Button);
        this.fps30Button.setOnClickListener(v -> {
            Constants.FPS = 30;
            for(Button b: this.fpsButtons) {
                b.setBackgroundColor(Color.BLACK);
                b.setTextColor(Color.WHITE);
            }
            fps30Button.setBackgroundColor(Color.WHITE);
            fps30Button.setTextColor(Color.BLACK);
        });

        this.fps60Button = root.findViewById(R.id.fps_60_button);
        this.fpsButtons.add(fps60Button);
        fps60Button.setBackgroundColor(Color.WHITE);
        fps60Button.setTextColor(Color.BLACK);
        this.fps60Button.setOnClickListener(v -> {
            Constants.FPS = 60;
            for(Button b: this.fpsButtons) {
                b.setBackgroundColor(Color.BLACK);
                b.setTextColor(Color.WHITE);
            }
            fps60Button.setBackgroundColor(Color.WHITE);
            fps60Button.setTextColor(Color.BLACK);
        });

        //root.findViewById(R.id.fps).getLayoutParams().width = fps30Button.getWidth() * 2;

        this.backButton = root.findViewById(R.id.back_button);
        this.backButton.setOnClickListener(v -> {
            FragmentTransaction t = this.manager.beginTransaction();
            MenuFragment menuFragment = new MenuFragment(this.manager);
            t.add(R.id.fragment_container, menuFragment);
            t.commit();
        });

        return root;
    }
}
