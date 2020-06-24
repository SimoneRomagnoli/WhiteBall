package com.example.whiteball.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.example.whiteball.model.GameMode;
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

    private int buttonsWidth = Constants.SCREEN_WIDTH / 2;

    private List<Button> modsButtons;
    private Button xModButton;
    private Button xyModButton;
    private Button yModButton;

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
        this.modsButtons = new ArrayList<>();
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

        //GAME MODE
        this.xModButton = root.findViewById(R.id.x_mode_button);
        this.modsButtons.add(xModButton);
        if(Constants.GAME_MODE == GameMode.X) {
            this.xModButton.setBackgroundResource(R.drawable.button_selected);
            this.xModButton.setTextColor(Color.BLACK);
        } else {
            this.xModButton.setBackgroundResource(R.drawable.button_selector);
        }
        this.xModButton.setOnClickListener(v -> {
            Constants.GAME_MODE = GameMode.X;
            for(Button b: this.modsButtons) {
                b.setBackgroundResource(R.drawable.button_selector);
                b.setTextColor(Color.WHITE);
            }
            this.xModButton.setBackgroundResource(R.drawable.button_selected);
            this.xModButton.setTextColor(Color.BLACK);
        });

        this.yModButton = root.findViewById(R.id.y_mode_button);
        this.modsButtons.add(yModButton);
        if(Constants.GAME_MODE == GameMode.Y) {
            this.yModButton.setBackgroundResource(R.drawable.button_selected);
            this.yModButton.setTextColor(Color.BLACK);
        } else {
            this.yModButton.setBackgroundResource(R.drawable.button_selector);
        }
        this.yModButton.setOnClickListener(v -> {
            Constants.GAME_MODE = GameMode.Y;
            for(Button b: this.modsButtons) {
                b.setBackgroundResource(R.drawable.button_selector);
                b.setTextColor(Color.WHITE);
            }
            this.yModButton.setBackgroundResource(R.drawable.button_selected);
            this.yModButton.setTextColor(Color.BLACK);
        });

        this.xyModButton = root.findViewById(R.id.xy_mode_button);
        this.modsButtons.add(xyModButton);
        if(Constants.GAME_MODE == GameMode.XY) {
            this.xyModButton.setBackgroundResource(R.drawable.button_selected);
            this.xyModButton.setTextColor(Color.BLACK);
        } else {
            this.xyModButton.setBackgroundResource(R.drawable.button_selector);
        }
        this.xyModButton.setOnClickListener(v -> {
            Constants.GAME_MODE = GameMode.XY;
            for(Button b: this.modsButtons) {
                b.setBackgroundResource(R.drawable.button_selector);
                b.setTextColor(Color.WHITE);
            }
            this.xyModButton.setBackgroundResource(R.drawable.button_selected);
            this.xyModButton.setTextColor(Color.BLACK);
        });

        for(Button b: this.modsButtons) {
            b.getLayoutParams().width = this.buttonsWidth / this.modsButtons.size();
        }

        //MUSIC
        this.musicOnButton = root.findViewById(R.id.music_on);
        this.musicOnButton.getLayoutParams().width = this.buttonsWidth / 2;
        if(Constants.CURRENT_CONTEXT.getSharedPreferences(Constants.CURRENT_CONTEXT.getString(R.string.preferences), Context.MODE_PRIVATE).getBoolean("MUSIC", true)) {
            this.musicOnButton.setBackgroundResource(R.drawable.button_selected);
            this.musicOnButton.setTextColor(Color.BLACK);
        } else {
            this.musicOnButton.setBackgroundResource(R.drawable.button_selector);
        }
        this.musicOnButton.setOnClickListener(v -> {
            this.musicOnButton.setBackgroundResource(R.drawable.button_selected);
            this.musicOnButton.setTextColor(Color.BLACK);
            this.musicOffButton.setBackgroundResource(R.drawable.button_selector);
            this.musicOffButton.setTextColor(Color.WHITE);
            Constants.MEDIA_PLAYER_ON = true;
            (Constants.CURRENT_CONTEXT).startService(new Intent(Constants.CURRENT_CONTEXT, AudioManager.class));

            SharedPreferences sp = Constants.CURRENT_CONTEXT.getSharedPreferences(Constants.CURRENT_CONTEXT.getString(R.string.preferences), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(Constants.CURRENT_CONTEXT.getString(R.string.music), true);
            editor.commit();
        });

        this.musicOffButton = root.findViewById(R.id.music_off);
        this.musicOffButton.getLayoutParams().width = this.buttonsWidth / 2;
        if(!Constants.CURRENT_CONTEXT.getSharedPreferences(Constants.CURRENT_CONTEXT.getString(R.string.preferences), Context.MODE_PRIVATE).getBoolean("MUSIC", true)) {
            this.musicOffButton.setBackgroundResource(R.drawable.button_selected);
            this.musicOffButton.setTextColor(Color.BLACK);
        } else {
            this.musicOffButton.setBackgroundResource(R.drawable.button_selector);
        }
        this.musicOffButton.setOnClickListener(v -> {
            this.musicOffButton.setBackgroundResource(R.drawable.button_selected);
            this.musicOffButton.setTextColor(Color.BLACK);
            this.musicOnButton.setBackgroundResource(R.drawable.button_selector);
            this.musicOnButton.setTextColor(Color.WHITE);
            Constants.MEDIA_PLAYER_ON = false;
            (Constants.CURRENT_CONTEXT).stopService(new Intent(Constants.CURRENT_CONTEXT, AudioManager.class));

            SharedPreferences sp = Constants.CURRENT_CONTEXT.getSharedPreferences(Constants.CURRENT_CONTEXT.getString(R.string.preferences), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(Constants.CURRENT_CONTEXT.getString(R.string.music), false);
            editor.commit();
        });

        //FPS
        this.fps30Button = root.findViewById(R.id.fps_30_button);
        this.fpsButtons.add(fps30Button);
        if(Constants.FPS == 30) {
            this.fps30Button.setBackgroundResource(R.drawable.button_selected);
            this.fps30Button.setTextColor(Color.BLACK);
        } else {
            this.fps30Button.setBackgroundResource(R.drawable.button_selector);
        }
        this.fps30Button.setOnClickListener(v -> {
            Constants.FPS = 30;
            for(Button b: this.fpsButtons) {
                b.setBackgroundResource(R.drawable.button_selector);
                b.setTextColor(Color.WHITE);
            }
            this.fps30Button.setBackgroundResource(R.drawable.button_selected);
            this.fps30Button.setTextColor(Color.BLACK);
        });

        this.fps60Button = root.findViewById(R.id.fps_60_button);
        this.fpsButtons.add(fps60Button);
        if(Constants.FPS == 60) {
            this.fps60Button.setBackgroundResource(R.drawable.button_selected);
            this.fps60Button.setTextColor(Color.BLACK);
        } else {
            this.fps60Button.setBackgroundResource(R.drawable.button_selector);
        }
        this.fps60Button.setOnClickListener(v -> {
            Constants.FPS = 60;
            for(Button b: this.fpsButtons) {
                b.setBackgroundResource(R.drawable.button_selector);
                b.setTextColor(Color.WHITE);
            }
            this.fps60Button.setBackgroundResource(R.drawable.button_selected);
            this.fps60Button.setTextColor(Color.BLACK);
        });

        for(Button b: this.fpsButtons) {
            b.getLayoutParams().width = this.buttonsWidth / this.fpsButtons.size();
        }

        //SOUND
        this.soundOneButton = root.findViewById(R.id.sound_one);
        this.soundButtons.add(this.soundOneButton);
        if(Constants.PLAYING_SONG == R.raw.giorno_giovanna) {
            this.soundOneButton.setBackgroundResource(R.drawable.button_selected);
            this.soundOneButton.setTextColor(Color.BLACK);
        } else {
            this.soundOneButton.setBackgroundResource(R.drawable.button_selector);
        }
        this.soundOneButton.setOnClickListener(v -> {
            if(Constants.PLAYING_SONG != R.raw.giorno_giovanna) {
                Constants.PLAYING_SONG = R.raw.giorno_giovanna;
                if(Constants.MEDIA_PLAYER_ON) {
                    this.musicOffButton.performClick();
                    this.musicOnButton.performClick();
                }
                for(Button b: this.soundButtons) {
                    b.setBackgroundResource(R.drawable.button_selector);
                    b.setTextColor(Color.WHITE);
                }
                this.soundOneButton.setBackgroundResource(R.drawable.button_selected);
                this.soundOneButton.setTextColor(Color.BLACK);
            }
        });

        this.soundTwoButton = root.findViewById(R.id.sound_two);
        this.soundButtons.add(this.soundTwoButton);
        if(Constants.PLAYING_SONG == R.raw.bruno_bucciarati) {
            this.soundTwoButton.setBackgroundResource(R.drawable.button_selected);
            this.soundTwoButton.setTextColor(Color.BLACK);
        } else {
            this.soundTwoButton.setBackgroundResource(R.drawable.button_selector);
        }
        this.soundTwoButton.setOnClickListener(v -> {
            if(Constants.PLAYING_SONG != R.raw.bruno_bucciarati) {
                Constants.PLAYING_SONG = R.raw.bruno_bucciarati;
                if(Constants.MEDIA_PLAYER_ON) {
                    this.musicOffButton.performClick();
                    this.musicOnButton.performClick();
                }
                for(Button b: this.soundButtons) {
                    b.setBackgroundResource(R.drawable.button_selector);
                    b.setTextColor(Color.WHITE);
                }
                this.soundTwoButton.setBackgroundResource(R.drawable.button_selected);
                this.soundTwoButton.setTextColor(Color.BLACK);
            }
        });

        this.soundThreeButton = root.findViewById(R.id.sound_three);
        this.soundButtons.add(this.soundThreeButton);
        if(Constants.PLAYING_SONG == R.raw.dio_brando) {
            this.soundThreeButton.setBackgroundResource(R.drawable.button_selected);
            this.soundThreeButton.setTextColor(Color.BLACK);
        } else {
            this.soundThreeButton.setBackgroundResource(R.drawable.button_selector);
        }
        this.soundThreeButton.setOnClickListener(v -> {
            if(Constants.PLAYING_SONG != R.raw.dio_brando) {
                Constants.PLAYING_SONG = R.raw.dio_brando;
                if(Constants.MEDIA_PLAYER_ON) {
                    this.musicOffButton.performClick();
                    this.musicOnButton.performClick();
                }
                for(Button b: this.soundButtons) {
                    b.setBackgroundResource(R.drawable.button_selector);
                    b.setTextColor(Color.WHITE);
                }
                this.soundThreeButton.setBackgroundResource(R.drawable.button_selected);
                this.soundThreeButton.setTextColor(Color.BLACK);
            }
        });

        for(Button b: this.soundButtons) {
            b.getLayoutParams().width = this.buttonsWidth / this.soundButtons.size();
        }

        //BACK
        this.backButton = root.findViewById(R.id.back_button);
        this.backButton.setBackgroundResource(R.drawable.button_selector);
        this.backButton.setOnClickListener(v -> {
            this.animation.stop();
            FragmentTransaction t = this.manager.beginTransaction();
            MenuFragment menuFragment = new MenuFragment(this.manager);
            t.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            t.replace(R.id.fragment_container, menuFragment);
            t.commit();
            Constants.CURRENT_FRAGMENT = menuFragment;
        });

        return root;
    }

    @Override
    public void onDestroy() {
        this.animation.stop();
        super.onDestroy();
    }

}
