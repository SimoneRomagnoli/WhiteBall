package com.example.whiteball.fragments;

import android.content.Context;
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
import android.widget.TextView;

import com.example.whiteball.R;
import com.example.whiteball.utility.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    FragmentManager manager;

    private FrameLayout scoreLayout;
    private AnimationDrawable animation;

    private TextView xValue;
    private TextView yValue;
    private TextView xyValue;

    private Button backButton;

    public ScoreFragment(FragmentManager manager) {
        // Required empty public constructor
        this.manager = manager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_score, container, false);

        this.scoreLayout = root.findViewById(R.id.score_layout);
        this.scoreLayout.setBackgroundColor(Color.BLACK);
        this.scoreLayout.setBackgroundResource(R.drawable.animation_background);
        this.animation = (AnimationDrawable) this.scoreLayout.getBackground();
        this.animation.start();

        //SHARED PREFERENCES
        SharedPreferences sp = Constants.CURRENT_CONTEXT.getSharedPreferences(Constants.CURRENT_CONTEXT.getString(R.string.preferences), Context.MODE_PRIVATE);
        long defaultValue = 0;

        //X HIGH SCORE
        this.xValue = root.findViewById(R.id.x_value);
        long xHighScore = sp.getLong(Constants.CURRENT_CONTEXT.getString(R.string.x_high_score), defaultValue);
        int xMins = (int)(xHighScore / Constants.MINUTE_LONG);
        int xSecs = (int)(xHighScore / Constants.SECOND_LONG)%60;
        String xM = Integer.toString(xMins);
        String xS = Integer.toString(xSecs);
        String xRoundS = xSecs < 10 ? "0" : "";
        String xRoundM = xMins < 10 ? "0" : "";
        this.xValue.setText(xRoundM + xM + ":" + xRoundS + xS);

        //Y HIGH SCORE
        this.yValue = root.findViewById(R.id.y_value);
        long yHighScore = sp.getLong(Constants.CURRENT_CONTEXT.getString(R.string.y_high_score), defaultValue);
        int yMins = (int)(yHighScore / Constants.MINUTE_LONG);
        int ySecs = (int)(yHighScore / Constants.SECOND_LONG)%60;
        String yM = Integer.toString(yMins);
        String yS = Integer.toString(ySecs);
        String yRoundS = ySecs < 10 ? "0" : "";
        String yRoundM = yMins < 10 ? "0" : "";
        this.yValue.setText(yRoundM + yM + ":" + yRoundS + yS);

        //XY HIGH SCORE
        this.xyValue = root.findViewById(R.id.xy_value);
        long xyHighScore = sp.getLong(Constants.CURRENT_CONTEXT.getString(R.string.xy_high_score), defaultValue);
        int xyMins = (int)(xyHighScore / Constants.MINUTE_LONG);
        int xySecs = (int)(xyHighScore / Constants.SECOND_LONG)%60;
        String xyM = Integer.toString(xyMins);
        String xyS = Integer.toString(xySecs);
        String xyRoundS = xySecs < 10 ? "0" : "";
        String xyRoundM = xyMins < 10 ? "0" : "";
        this.xyValue.setText(xyRoundM + xyM + ":" + xyRoundS + xyS);

        //BACK
        this.backButton = root.findViewById(R.id.back_button);
        this.backButton.setBackgroundResource(R.drawable.button_selector);
        this.backButton.setOnClickListener(v -> {
            this.animation.stop();
            FragmentTransaction t = this.manager.beginTransaction();
            MenuFragment menuFragment = new MenuFragment(this.manager);
            t.replace(R.id.fragment_container, menuFragment);
            t.commit();
        });

        return root;
    }
}
