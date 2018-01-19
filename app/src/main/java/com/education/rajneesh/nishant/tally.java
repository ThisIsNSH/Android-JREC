package com.education.rajneesh.nishant;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

public class tally extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tally);

         LinearLayout rootLayout = (LinearLayout) findViewById(R.id.tally1);
        if (savedInstanceState == null) {
            rootLayout.setVisibility(View.INVISIBLE);

            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.tally1);
                        enterReveal();
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                            rootLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        } else {
                            rootLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    }
                });
            }
        }

    }

    @Override
    public void onBackPressed() {

        LinearLayout surface = (LinearLayout) findViewById(R.id.tally1);
        TextView intro = (TextView) findViewById(R.id.introduction);
        TextView detail = (TextView) findViewById(R.id.detail);

        ObjectAnimator surfacea = ObjectAnimator.ofFloat(surface,"alpha", 1,0).setDuration(300);
        surfacea.start();
/*
        ObjectAnimator intro2= ObjectAnimator.ofFloat(intro,"alpha", 0, 1 ).setDuration(300);

        ObjectAnimator detail2= ObjectAnimator.ofFloat(detail,"alpha", 0, 1 ).setDuration(300);




        AnimatorSet anim = new AnimatorSet();
        anim.playTogether(surfacea,intro2,detail2);
anim.start();*/
        surfacea.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                //super.onBackPressed();
                finish();
            }});



    }
/*
    @Override
    public void onEnterAnimationComplete() {
        enterReveal();
        overridePendingTransition(fade,fade);

        // RunAnimations();
        super.onEnterAnimationComplete();
    }

    void enterReveal() {
        // previously invisible view

        final LinearLayout myView = (LinearLayout) findViewById(R.id.tally1);

        // get the center for the clipping circle
        int cx = myView.getMeasuredWidth() / 2;
        int cy = myView.getMeasuredHeight() / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(myView.getWidth(), myView.getHeight()) / 2;

        // create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);

        // make the view visible and start the animation
        myView.setVisibility(View.VISIBLE);
        anim.start();
    }*/


    private void enterReveal() {
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.tally1);
        int cx = rootLayout.getWidth() / 2;
        int cy = rootLayout.getHeight() / 2;

        float finalRadius = Math.max(rootLayout.getWidth(), rootLayout.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, cx, cy, 0, finalRadius);
        circularReveal.setDuration(300);

        // make the view visible and start the animation
        rootLayout.setVisibility(View.VISIBLE);
        circularReveal.start();
    }
}
