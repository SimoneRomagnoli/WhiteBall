package com.example.whiteball.utility;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.whiteball.model.GameMode;

public class Constants {
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static int FPS;
    public static int PLAYING_SONG;
    public static boolean MEDIA_PLAYER_ON;
    public static GameMode GAME_MODE;

    public static Context CURRENT_CONTEXT;

    //public static double GYROSCOPE_SENSITIVITY;

    public static double VELOCITY_FACTOR = 0.2;
    public static float PLAYER_RADIUS_FLOAT = 40f;
    public static int PLAYER_RADIUS_INT = 40;
    public static int SQUARE_EDGE = 100;
    public static int TRIANGLE_EDGE = 100;
    public static int RHOMBUS_EDGE = 100;

    public static int MINUTE_LONG = 60000;
    public static int SECOND_LONG = 1000;

}
