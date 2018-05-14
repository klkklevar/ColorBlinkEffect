package com.klevar.colorblinkeffect;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        Button blinkBtn = (Button) findViewById(R.id.btn);
        blinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageBlinkEffect();
            }
        });
    }

    @SuppressLint("WrongConstant")
    private void manageBlinkEffect() {
        ObjectAnimator anim = ObjectAnimator.ofInt(image, "backgroundColor", Color.GREEN, Color.GREEN,
                Color.RED);
        anim.setDuration(1500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatCount(Animation.START_ON_FIRST_FRAME);
        anim.setRepeatCount(Animation.RESTART);

        anim.start();
    }
}
