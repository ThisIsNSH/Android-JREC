package com.education.rajneesh.jrec;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.MotionEvent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.animation;
import static com.education.rajneesh.jrec.R.layout.activity_fab;

public class fab extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_fab);


        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);
        if (savedInstanceState == null) {
            rootLayout.setVisibility(View.INVISIBLE);

            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);
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

        ImageView rootLayout1 = (ImageView) findViewById(R.id.fab_pic);
        if (savedInstanceState == null) {
            rootLayout1.setVisibility(View.INVISIBLE);

            ViewTreeObserver viewTreeObserver = rootLayout1.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        ImageView rootLayout1= (ImageView) findViewById(R.id.fab_pic);
                        enterReveal1();
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                            rootLayout1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        } else {
                            rootLayout1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    }
                });
            }



    }



       // LinearLayout one = (LinearLayout) findViewById(R.id.fabsurface1);
      // FrameLayout fab = (FrameLayout) findViewById(R.id.fab_two);
       // fab.setVisibility(View.INVISIBLE);
       // one.setVisibility(View.INVISIBLE);



        }

 @Override
 public void onResume(){
     super.onResume();
     FrameLayout fm = (FrameLayout) findViewById(R.id.fab_one);
     fm.setVisibility(View.VISIBLE);
 }



    private void enterReveal() {
/*
        FloatingActionButton fab;
        fab = (FloatingActionButton)findViewById(R.id.fab1);

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);

                int w = rootLayout.getWidth();
        int h = rootLayout.getHeight();

        int endRadius = (int) Math.hypot(w, h);

        int cx = (int) (fab.getX() + (fab.getWidth()/2));
        int cy = (int) (fab.getY())+ fab.getHeight() + 56;

*/

      //  int cx = rootLayout.getWidth() / 2;
       // int cy = rootLayout.getHeight() / 2;

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);

        int cx = rootLayout.getWidth() / 2;
        int cy = rootLayout.getHeight() / 2;

        float finalRadius = Math.max(rootLayout.getWidth(), rootLayout.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, cx , cy, 0, finalRadius);
        circularReveal.setDuration(500);

        // make the view visible and start the animation
        rootLayout.setVisibility(View.VISIBLE);
        circularReveal.start();
    }

/*
@Override
    public void onBackPressed(){
    FloatingActionButton fab;
    fab = (FloatingActionButton)findViewById(R.id.fab1);

    final LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);

    int w = rootLayout.getWidth();
    int h = rootLayout.getHeight();

    int endRadius = (int) Math.hypot(w, h);

    int cx = (int) (fab.getX() + (fab.getWidth()/2));
    int cy = (int) (fab.getY())+ fab.getHeight() + 56;

    final LinearLayout rootLayout = (LinearLayout) findViewById(R.id.fabsurface);
    int cx = rootLayout.getWidth() / 2;
    int cy = rootLayout.getHeight() / 2;

    float finalRadius = Math.max(rootLayout.getWidth(), rootLayout.getHeight());

    Animator anim =
            ViewAnimationUtils.createCircularReveal(rootLayout, cx, cy, finalRadius, 0);
    anim.setDuration(300);


    FrameLayout surfacea = (FrameLayout) findViewById(R.id.activity_fab);

    final ObjectAnimator surface = ObjectAnimator.ofFloat(surfacea, "alpha" , 1,0).setDuration(200);

    AnimatorSet anim1 = new AnimatorSet();
    anim1.playTogether(anim);
anim1.start();
    anim1.addListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {



            super.onAnimationEnd(animation);

            rootLayout.setVisibility(View.INVISIBLE);

            //surface.start();
finish();
        }
    });
}
*/



    private void enterReveal1()

    {

        ImageView rootLayout = (ImageView) findViewById(R.id.fab_pic);
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

}
