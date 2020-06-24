package com.example.whiteball;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.whiteball.fragments.GameFragment;
import com.example.whiteball.fragments.MenuFragment;
import com.example.whiteball.model.GameMode;
import com.example.whiteball.utility.AudioManager;
import com.example.whiteball.utility.Constants;

public class MainActivity extends FragmentActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display display = getWindowManager().getDefaultDisplay();
        Point outSize = new Point();
        display.getSize(outSize);
        Constants.SCREEN_WIDTH = outSize.x;
        Constants.SCREEN_HEIGHT = outSize.y;

        Constants.CURRENT_CONTEXT = this;
        Constants.GAME_MODE = GameMode.X;
        Constants.PLAYING_SONG = R.raw.giorno_giovanna;
        Constants.MEDIA_PLAYER_ON = true;
        //this.startService(new Intent(Constants.CURRENT_CONTEXT, AudioManager.class));
        Constants.FPS = 60;

        setContentView(R.layout.activity_main);
        this.manager = getSupportFragmentManager();
        FragmentTransaction transaction = this.manager.beginTransaction();
        MenuFragment menuFragment = new MenuFragment(this.manager);
        transaction.add(R.id.fragment_container, menuFragment);
        transaction.commit();
        Constants.CURRENT_FRAGMENT = menuFragment;
    }

    @Override
    protected void onDestroy() {
        //this.stopService(new Intent(Constants.CURRENT_CONTEXT, AudioManager.class));
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Constants.CURRENT_CONTEXT.getSharedPreferences(Constants.CURRENT_CONTEXT.getString(R.string.preferences), Context.MODE_PRIVATE).getBoolean("MUSIC", true)) {
            this.stopService(new Intent(Constants.CURRENT_CONTEXT, AudioManager.class));
        }
        if (Constants.CURRENT_FRAGMENT instanceof GameFragment) {
            ((GameFragment) Constants.CURRENT_FRAGMENT).pauseGameLoop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Constants.CURRENT_CONTEXT.getSharedPreferences(Constants.CURRENT_CONTEXT.getString(R.string.preferences), Context.MODE_PRIVATE).getBoolean("MUSIC", true)) {
            this.startService(new Intent(Constants.CURRENT_CONTEXT, AudioManager.class));
        }
        if (Constants.CURRENT_FRAGMENT instanceof GameFragment) {
            ((GameFragment) Constants.CURRENT_FRAGMENT).resumeGameLoop();
        }
    }
}
