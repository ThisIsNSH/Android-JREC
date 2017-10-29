package com.education.rajneesh.jrec;

import android.animation.Animator;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.gallery123);
        if (savedInstanceState == null) {
            rootLayout.setVisibility(View.INVISIBLE);

            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.gallery123);
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
/*
    @Override
    public void onEnterAnimationComplete() {
        enterReveal();
        //RunAnimations();
        super.onEnterAnimationComplete();
    }

    void enterReveal() {
        // previously invisible view

        final LinearLayout myView = (LinearLayout) findViewById(R.id.gallery123);

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
    }
*/


    private void enterReveal() {
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.gallery123);
        int cx = rootLayout.getWidth() / 2;
        int cy = rootLayout.getHeight() / 2;

        float finalRadius = Math.max(rootLayout.getWidth(), rootLayout.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, cx, cy, 0, finalRadius);
        circularReveal.setDuration(600);

        // make the view visible and start the animation
        rootLayout.setVisibility(View.VISIBLE);
        circularReveal.start();
    }
    private void RunAnimations() {


        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
  /*  a.reset();
    logoImage = (ImageView) findViewById(R.id.dopescrawl);
    logoImage.setBackgroundResource(R.drawable.dopesplash);
    logoAnimation = (AnimationDrawable)  logoImage.getBackground();
    logoImage.clearAnimation();
    logoImage.startAnimation(a);
    */
        a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        a.reset();
        LinearLayout title = (LinearLayout) findViewById(R.id.gallery123);
        title.setVisibility(View.VISIBLE);
        title.clearAnimation();
        title.startAnimation(a);





        //logoAnimation.start();
    }
}
