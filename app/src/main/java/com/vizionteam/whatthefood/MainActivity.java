package com.vizionteam.whatthefood;

import android.graphics.Matrix;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgWheel;
    ImageView imgWtf;

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        imgWtf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgWheel.startAnimation(animation);
            }
        });

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                long duration = animation.getDuration();
                if (duration > 2000) {
                    imgWheel.clearAnimation();
                } else {
                    animation.setDuration(duration + 500);
                }
            }
        });
    }

    private void addControls() {
        imgWheel = (ImageView) findViewById(R.id.imgWheel);
        imgWtf = (ImageView) findViewById(R.id.imgWtf);

        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.clockwise_rotation);
    }
}
