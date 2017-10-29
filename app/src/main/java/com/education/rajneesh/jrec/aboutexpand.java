package com.education.rajneesh.jrec;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


import static com.education.rajneesh.jrec.R.id.contacts;
import static com.education.rajneesh.jrec.R.id.gallery;
import static com.education.rajneesh.jrec.R.id.history;

public class aboutexpand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutexpand);
         final TextView intro = (TextView) findViewById(history);
         final TextView contact1 = (TextView) findViewById(contacts);
        final TextView gallery1 = (TextView) findViewById(gallery);
        int test1[] = new int[2];
        intro.getLocationInWindow(test1);



        ValueAnimator a = ObjectAnimator.ofFloat( intro, "x",-10,  60 ).setDuration(1000);
        ValueAnimator b = ObjectAnimator.ofFloat(contact1, "x",-10,  60).setDuration(1000);
        ValueAnimator c = ObjectAnimator.ofFloat(gallery1, "x",-10,  60).setDuration(1000);
        b.setStartDelay(300);
        c.setStartDelay(500);
        ValueAnimator c1 = ObjectAnimator.ofFloat(gallery1, "alpha",0,1 ).setDuration(1500);
        ValueAnimator a1 = ObjectAnimator.ofFloat( intro, "alpha" ,0,1 ).setDuration(1500);
        ValueAnimator b1 = ObjectAnimator.ofFloat(contact1, "alpha", 0,1).setDuration(1500);

        final AnimatorSet anim = new AnimatorSet();

        intro.postDelayed(new Runnable() {
            public void run() {
                intro.setVisibility(View.VISIBLE);
            }
        }, 0);

        contact1.postDelayed(new Runnable() {
            public void run() {
                contact1.setVisibility(View.VISIBLE);
            }
        }, 350);
        gallery1.postDelayed(new Runnable() {
            public void run() {
                gallery1.setVisibility(View.VISIBLE);
            }
        }, 550);

        //anim.playSequentially(a,b,c);
        anim.play(a).with(a1);
        anim.play(b).with(b1);
        anim.play(c).with(c1);
  //anim.playTogether(a,a1,c1,b1,c,b);
       // anim.setStartDelay(-300);
        anim.start();

        /*
        anim.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animation) {

                TextView intro = (TextView) findViewById(history);
                TextView contact1 = (TextView) findViewById(contacts);
                contact1.setVisibility(View.VISIBLE);
                intro.setVisibility(View.VISIBLE);
            }});*/



}


    @Override
    public void onBackPressed() {
        // Write your code here

        final TextView intro = (TextView) findViewById(history);
        final TextView contact1 = (TextView) findViewById(contacts);
        final TextView gallery1 = (TextView) findViewById(gallery);
        ValueAnimator c1 = ObjectAnimator.ofFloat(gallery1, "alpha",1,0 ).setDuration(200);
        ValueAnimator a1 = ObjectAnimator.ofFloat( intro, "alpha" ,1,0 ).setDuration(200);
        ValueAnimator b1 = ObjectAnimator.ofFloat(contact1, "alpha", 1,0).setDuration(200);
        c1.start();
        b1.start();
        a1.start();
        super.onBackPressed();

    }


    public void historyclick(View view) {
        Intent intent = new Intent(aboutexpand.this, aboutus.class);
        startActivity(intent);
    }
    public void contactclick(View view) {
        Intent intent = new Intent(aboutexpand.this, contact.class);
        startActivity(intent);
    }
    public void galleryclick(View view) {
        Intent intent = new Intent(aboutexpand.this, gallery.class);
        startActivity(intent);
    }

}
