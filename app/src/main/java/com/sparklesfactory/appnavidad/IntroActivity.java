package com.sparklesfactory.appnavidad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private ImageView var;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();
        tv1= (TextView) findViewById(R.id.s);
        tv2= (TextView) findViewById(R.id.f);
        var= (ImageView) findViewById(R.id.varita);

        Animation anim3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sparkle);
        var.startAnimation(anim3);
        Animation anim4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hidding);
        tv1.startAnimation(anim4);
        Animation anim5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hidding);
        tv2.startAnimation(anim5);
        anim3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.letters);
                tv1.startAnimation(anim1);
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.letters);
                tv2.startAnimation(anim2);

                anim1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent i= new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                anim2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent i= new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
