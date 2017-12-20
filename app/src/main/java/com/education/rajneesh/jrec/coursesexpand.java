package com.education.rajneesh.jrec;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.education.rajneesh.jrec.R.id.contacts;
import static com.education.rajneesh.jrec.R.id.gallery;
import static com.education.rajneesh.jrec.R.id.history;

public class coursesexpand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursesexpand);

        final TextView intro = (TextView) findViewById(R.id.rscit);
        final TextView contact1 = (TextView) findViewById(R.id.tally);
        final TextView gallery1 = (TextView) findViewById(R.id.hard);
        final TextView tally1 = (TextView) findViewById(R.id.pmkvy);
        final TextView pwd1 = (TextView) findViewById(R.id.pwd);

        int test1[] = new int[2];
        intro.getLocationInWindow(test1);


        ValueAnimator a = ObjectAnimator.ofFloat(intro, "x", -10, 60).setDuration(1000);
        ValueAnimator b = ObjectAnimator.ofFloat(contact1, "x", -10, 60).setDuration(1000);
        ValueAnimator c = ObjectAnimator.ofFloat(gallery1, "x", -10, 60).setDuration(1000);
        ValueAnimator d = ObjectAnimator.ofFloat(tally1, "x", -10, 60).setDuration(1000);
        ValueAnimator e = ObjectAnimator.ofFloat(pwd1, "x", -10, 60).setDuration(1000);

        b.setStartDelay(200);
        c.setStartDelay(400);
        d.setStartDelay(600);
        e.setStartDelay(800);

        ValueAnimator c1 = ObjectAnimator.ofFloat(gallery1, "alpha", 0, 1).setDuration(1500);
        ValueAnimator a1 = ObjectAnimator.ofFloat(intro, "alpha", 0, 1).setDuration(1500);
        ValueAnimator b1 = ObjectAnimator.ofFloat(contact1, "alpha", 0, 1).setDuration(1500);
        ValueAnimator e1 = ObjectAnimator.ofFloat(tally1, "alpha", 0, 1).setDuration(1500);
        ValueAnimator d1 = ObjectAnimator.ofFloat(pwd1, "alpha", 0, 1).setDuration(1500);


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
        tally1.postDelayed(new Runnable() {
            public void run() {
                tally1.setVisibility(View.VISIBLE);
            }
        }, 900);
        pwd1.postDelayed(new Runnable() {
            public void run() {
                pwd1.setVisibility(View.VISIBLE);
            }
        }, 950);

        anim.play(a).with(a1);
        anim.play(b).with(b1);
        anim.play(c).with(c1);
        anim.play(d).with(d1);
        anim.play(e).with(e1);

        anim.start();




    }



    @Override
    public void onBackPressed() {
        // Write your code here

        final TextView intro = (TextView) findViewById(R.id.rscit);
        final TextView contact1 = (TextView) findViewById(R.id.tally);
        final TextView gallery1 = (TextView) findViewById(R.id.hard);
        final TextView tally1 = (TextView) findViewById(R.id.pmkvy);
        final TextView pwd1 = (TextView) findViewById(R.id.pwd);

        ValueAnimator e1 = ObjectAnimator.ofFloat(pwd1, "alpha", 1, 0).setDuration(200);
        ValueAnimator d1 = ObjectAnimator.ofFloat(tally1, "alpha", 1, 0).setDuration(200);
        ValueAnimator c1 = ObjectAnimator.ofFloat(gallery1, "alpha", 1, 0).setDuration(200);
        ValueAnimator a1 = ObjectAnimator.ofFloat(intro, "alpha", 1, 0).setDuration(200);
        ValueAnimator b1 = ObjectAnimator.ofFloat(contact1, "alpha", 1, 0).setDuration(200);

        e1.start();
        d1.start();
        c1.start();
        b1.start();
        a1.start();
        super.onBackPressed();

    }


    public void rscitclick(View view) {
        Intent intent = new Intent(coursesexpand.this, rscit.class);
        startActivity(intent);
    }
    public void tallyclick(View view) {
        Intent intent = new Intent(coursesexpand.this, tally.class);
        startActivity(intent);
    }
    public void hardclick(View view) {
        Intent intent = new Intent(coursesexpand.this, hardware.class);
        startActivity(intent);
    }
    public void pwdclick(View view) {
        Intent intent = new Intent(coursesexpand.this, pwd.class);
        startActivity(intent);
    }

    public void pmkvyclick(View view) {
        Intent intent = new Intent(coursesexpand.this, pmkvy.class);
        startActivity(intent);
    }
    public void back(View view){
        LinearLayout surface = (LinearLayout) findViewById(R.id.coursessurface);
        RelativeLayout c = (RelativeLayout) findViewById(R.id.backc);
        //TextView intro = (TextView) findViewById(R.id.introduction);
        //TextView detail = (TextView) findViewById(R.id.detail);

        ObjectAnimator surfaceab = ObjectAnimator.ofFloat(c,"alpha", 1,0).setDuration(300);
        ObjectAnimator surfacea = ObjectAnimator.ofFloat(surface,"alpha", 1,0).setDuration(300);
        surfacea.start();
        surfaceab.start();
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


}
