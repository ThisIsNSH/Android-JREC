package com.education.rajneesh.jrec;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.education.rajneesh.jrec.R.id.contacts;
import static com.education.rajneesh.jrec.R.id.gallery;
import static com.education.rajneesh.jrec.R.id.history;

public class coursesexpand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursesexpand);

        final TextView intro = (TextView) findViewById(R.id.rscit);
        final TextView contact1 = (TextView) findViewById(R.id.hard);
        final TextView gallery1 = (TextView) findViewById(R.id.pmkvy);
        final TextView tally1 = (TextView) findViewById(R.id.tally);
        final TextView pwd1 = (TextView) findViewById(R.id.pwd);

        int test1[] = new int[2];
        intro.getLocationInWindow(test1);


        ValueAnimator a = ObjectAnimator.ofFloat(intro, "x", -10, 60).setDuration(1000);
        ValueAnimator b = ObjectAnimator.ofFloat(contact1, "x", -10, 60).setDuration(1000);
        ValueAnimator c = ObjectAnimator.ofFloat(gallery1, "x", -10, 60).setDuration(1000);
        ValueAnimator d = ObjectAnimator.ofFloat(tally1, "x", -10, 60).setDuration(1000);
        ValueAnimator e = ObjectAnimator.ofFloat(pwd1, "x", -10, 60).setDuration(1000);

        b.setStartDelay(300);
        c.setStartDelay(500);
        d.setStartDelay(700);
        e.setStartDelay(900);

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
        }, 750);
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


}
