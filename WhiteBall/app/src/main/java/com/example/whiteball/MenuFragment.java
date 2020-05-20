package com.example.whiteball;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private Button startButton;
    private FragmentManager manager;

    public MenuFragment(FragmentManager manager) {
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        this.startButton = root.findViewById(R.id.start_button);
        this.startButton.setOnClickListener(v -> {

            FragmentTransaction t = this.manager.beginTransaction();
            GameFragment gameFragment = new GameFragment();
            t.add(R.id.fragment_container, gameFragment);
            t.commit();
        });
        return root;
    }
}
