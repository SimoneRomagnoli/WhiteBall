package com.example.whiteball.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.whiteball.utility.AudioManager;
import com.example.whiteball.utility.Constants;
import com.example.whiteball.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private FragmentManager manager;

    private FrameLayout settingsLayout;
    private AnimationDrawable animation;
    private int buttonsWidth = (int)(Constants.SCREEN_WIDTH / 2);

    private List<Button> fpsButtons;
    private Button fps30Button;
    private Button fps60Button;

    private Button musicOnButton;
    private Button musicOffButton;

    private List<Button> soundButtons;
    private Button soundOneButton;
    private Button soundTwoButton;
    private Button soundThreeButton;

    private Button backButton;

    public SettingsFragment(FragmentManager manager) {
        this.manager = manager;
        this.fpsButtons = new ArrayList<>();
        this.soundButtons = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        this.settingsLayout = root.findViewById(R.id.settings_layout);
        this.settingsLayout.setBackgroundColor(Color.BLACK);
        this.settingsLayout.setBackgroundResource(R.drawable.animation_background);
        this.animation = (AnimationDrawable) this.settingsLayout.getBackground();
        this.animation.start();

        //MUSIC
        this.musicOnButton = root.findViewById(R.id.music_on);
        this.musicOnButton.getLayoutParams().width = this.buttonsWidth / 2;
        if(Constants.MEDIA_PLAYER_ON) {
            this.musicOnButton.setBackgroundColor(Color.WHITE);
            this.musicOnButton.setTextColor(Color.BLACK);
        }
        this.musicOnButton.setOnClickListener(v -> {
            this.musicOnButton.setBackgroundColor(Color.WHITE);
            this.musicOnButton.setTextColor(Color.BLACK);
            this.musicOffButton.setBackgroundColor(Color.BLACK);
            this.musicOffButton.setTextColor(Color.WHITE);
            Constants.MEDIA_PLAYER_ON = true;
            (Constants.CURRENT_CONTEXT).startService(new Intent(Constants.CURRENT_CONTEXT, AudioManager.class));
        });

        this.musicOffButton = root.findViewById(R.id.music_off);
        this.musicOffButton.getLayoutParams().width = this.buttonsWidth / 2;
        if(!Constants.MEDIA_PLAYER_ON) {
            this.musicOffButton.setBackgroundColor(Color.WHITE);
            this.musicOffButton.setTextColor(Color.BLACK);
        }
        this.musicOffButton.setOnClickListener(v -> {
            this.musicOffButton.setBackgroundColor(Color.WHITE);
            this.musicOffButton.setTextColor(Color.BLACK);
            this.musicOnButton.setBackgroundColor(Color.BLACK);
            this.musicOnButton.setTextColor(Color.WHITE);
            Constants.MEDIA_PLAYER_ON = false;
            (Constants.CURRENT_CONTEXT).stopService(new Intent(Constants.CURRENT_CONTEXT, AudioManager.class));
        });

        //FPS
        this.fps30Button = root.findViewById(R.id.fps_30_button);
        this.fpsButtons.add(fps30Button);
        if(Constants.FPS == 30) {
            this.fps30Button.setBackgroundColor(Color.WHITE);
            this.fps30Button.setTextColor(Color.BLACK);
        }
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
        if(Constants.FPS == 60) {
            this.fps60Button.setBackgroundColor(Color.WHITE);
            this.fps60Button.setTextColor(Color.BLACK);
        }
        this.fps60Button.setOnClickListener(v -> {
            Constants.FPS = 60;
            for(Button b: this.fpsButtons) {
                b.setBackgroundColor(Color.BLACK);
                b.setTextColor(Color.WHITE);
            }
            fps60Button.setBackgroundColor(Color.WHITE);
            fps60Button.setTextColor(Color.BLACK);
        });

        for(Button b: this.fpsButtons) {
            b.getLayoutParams().width = this.buttonsWidth / this.fpsButtons.size();
        }

        //SOUND
        this.soundOneButton = root.findViewById(R.id.sound_one);
        this.soundButtons.add(this.soundOneButton);
        if(Constants.PLAYING_SONG == R.raw.giorno_giovanna) {
            this.soundOneButton.setBackgroundColor(Color.WHITE);
            this.soundOneButton.setTextColor(Color.BLACK);
        }
        this.soundOneButton.setOnClickListener(v -> {
            if(Constants.PLAYING_SONG != R.raw.giorno_giovanna) {
                Constants.PLAYING_SONG = R.raw.giorno_giovanna;
                this.musicOffButton.performClick();
                this.musicOnButton.performClick();
                for(Button b: this.soundButtons) {
                    b.setBackgroundColor(Color.BLACK);
                    b.setTextColor(Color.WHITE);
                }
                soundOneButton.setBackgroundColor(Color.WHITE);
                soundOneButton.setTextColor(Color.BLACK);
            }
        });

        this.soundTwoButton = root.findViewById(R.id.sound_two);
        this.soundButtons.add(this.soundTwoButton);
        if(Constants.PLAYING_SONG == R.raw.bruno_bucciarati) {
            this.soundTwoButton.setBackgroundColor(Color.WHITE);
            this.soundTwoButton.setTextColor(Color.BLACK);
        }
        this.soundTwoButton.setOnClickListener(v -> {
            if(Constants.PLAYING_SONG != R.raw.bruno_bucciarati) {
                Constants.PLAYING_SONG = R.raw.bruno_bucciarati;
                this.musicOffButton.performClick();
                this.musicOnButton.performClick();
                for(Button b: this.soundButtons) {
                    b.setBackgroundColor(Color.BLACK);
                    b.setTextColor(Color.WHITE);
                }
                soundTwoButton.setBackgroundColor(Color.WHITE);
                soundTwoButton.setTextColor(Color.BLACK);
            }
        });

        this.soundThreeButton = root.findViewById(R.id.sound_three);
        this.soundButtons.add(this.soundThreeButton);
        if(Constants.PLAYING_SONG == R.raw.dio_brando) {
            this.soundThreeButton.setBackgroundColor(Color.WHITE);
            this.soundThreeButton.setTextColor(Color.BLACK);
        }
        this.soundThreeButton.setOnClickListener(v -> {
            if(Constants.PLAYING_SONG != R.raw.dio_brando) {
                Constants.PLAYING_SONG = R.raw.dio_brando;
                this.musicOffButton.performClick();
                this.musicOnButton.performClick();
                for(Button b: this.soundButtons) {
                    b.setBackgroundColor(Color.BLACK);
                    b.setTextColor(Color.WHITE);
                }
                soundThreeButton.setBackgroundColor(Color.WHITE);
                soundThreeButton.setTextColor(Color.BLACK);
            }
        });

        for(Button b: this.soundButtons) {
            b.getLayoutParams().width = this.buttonsWidth / this.soundButtons.size();
        }

        //BACK
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
