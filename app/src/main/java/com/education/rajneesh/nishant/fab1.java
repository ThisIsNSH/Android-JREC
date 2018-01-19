package com.education.rajneesh.nishant;

import android.animation.Animator;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class fab1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab1);


        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface12);
        if (savedInstanceState == null) {
            rootLayout.setVisibility(View.INVISIBLE);

            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface12);
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
        ImageView image = (ImageView) findViewById(R.id.image);
        AnimatedVectorDrawable d = (AnimatedVectorDrawable) image.getDrawable();
        d.start();

    }


    private void enterReveal() {

        FloatingActionButton fab1;
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);


        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface12);


        int w = rootLayout.getWidth();
        int h = rootLayout.getHeight();

        int endRadius = (int) Math.hypot(w, h) *2 ;

      //  int cx = (int) (fab1.getX() + (fab1.getWidth()/2));
      //  int cy = (int) (fab1.getY())+ fab1.getHeight() + 56;
int cx = w;
        int cy = -h;



        //  int cx = rootLayout.getWidth() / 2;
        // int cy = rootLayout.getHeight() / 2;


        // create the animator for this view (the start radius is zero)
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, cx , cy , 0 , endRadius);
        circularReveal.setDuration(500);

        // make the view visible and start the animation
        rootLayout.setVisibility(View.VISIBLE);
        circularReveal.start();
    }



}
