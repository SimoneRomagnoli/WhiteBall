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

import com.example.whiteball.R;
import com.example.whiteball.fragments.GameFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private FragmentManager manager;

    private FrameLayout menuLayout;
    private Button startButton;

    public MenuFragment(FragmentManager manager) {
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

        this.menuLayout = root.findViewById(R.id.fragment_menu);
        this.menuLayout.setBackgroundColor(Color.BLACK);

        this.startButton = root.findViewById(R.id.start_button);
        this.startButton.setOnClickListener(v -> {

            FragmentTransaction t = this.manager.beginTransaction();
            GameFragment gameFragment = new GameFragment(this.manager);
            t.add(R.id.fragment_container, gameFragment);
            t.commit();
        });

        return root;
    }
}
