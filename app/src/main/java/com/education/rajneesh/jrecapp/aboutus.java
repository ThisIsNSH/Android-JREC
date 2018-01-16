package com.education.rajneesh.jrecapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.history);
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.aboutussurface1);
        if (savedInstanceState == null) {
            rootLayout.setVisibility(View.INVISIBLE);

            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.aboutussurface1);
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
        TextView intro = (TextView) findViewById(R.id.introduction);
        TextView detail = (TextView) findViewById(R.id.detail);
       // LinearLayout surface = (LinearLayout) findViewById(R.id.aboutussurface1);

        //ObjectAnimator surfacea = ObjectAnimator.ofFloat(surface,"alpha", 0,1).setDuration(500);
        //surfacea.start();


        Animation intro1= AnimationUtils.loadAnimation(this, R.anim.translate_intro);
        intro.startAnimation(intro1);
        ObjectAnimator intro2= ObjectAnimator.ofFloat(intro,"alpha", 0, 1 ).setDuration(1000);
        intro2.start();
        intro2.setStartDelay(0);

        Animation detail1= AnimationUtils.loadAnimation(this, R.anim.translate_detail);
        //detail1.setStartOffset(300);
        detail.startAnimation(detail1);
        ObjectAnimator detail2= ObjectAnimator.ofFloat(detail,"alpha", 0, 1 ).setDuration(1000);
        detail2.start();
        //detail2.setStartDelay(300);


       // overridePendingTransition(R.anim.enter1, R.anim.exit1);
    }

   /* @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }*/


   /* @Override
    protected void onPause(){
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadein1);
    }*/

    @Override
    public void onBackPressed() {

        LinearLayout surface = (LinearLayout) findViewById(R.id.aboutussurface1);
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
    public void end(){
        LinearLayout surface = (LinearLayout) findViewById(R.id.aboutussurface1);
        ObjectAnimator surfacea = ObjectAnimator.ofFloat(surface,"alpha", 1,0).setDuration(300);
        surfacea.start();
    }

    @Override
    public void onBackPressed(){

        end();

        super.onBackPressed();

    }
 */ /*  @Override
    public void onEnterAnimationComplete() {
        enterReveal();
       // RunAnimations();
        super.onEnterAnimationComplete();
    }

    void enterReveal() {
        // previously invisible view

        final LinearLayout myView = (LinearLayout) findViewById(R.id.aboutussurface1);

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
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.aboutussurface1);
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
        LinearLayout title = (LinearLayout) findViewById(R.id.aboutussurface1);
        title.setVisibility(View.VISIBLE);
        title.clearAnimation();
        title.startAnimation(a);





        //logoAnimation.start();
    }



}

