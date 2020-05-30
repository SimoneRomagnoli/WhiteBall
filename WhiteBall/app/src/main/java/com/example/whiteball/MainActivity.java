package com.example.whiteball;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.example.whiteball.fragments.MenuFragment;
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
        Constants.PLAYING_SONG = R.raw.giorno_giovanna;
        Constants.MEDIA_PLAYER_ON = false;
        Constants.FPS = 60;

        setContentView(R.layout.activity_main);
        this.manager = getSupportFragmentManager();
        FragmentTransaction transaction = this.manager.beginTransaction();
        MenuFragment menuFragment = new MenuFragment(this.manager);
        transaction.add(R.id.fragment_container, menuFragment);
        transaction.commit();

    }

}
