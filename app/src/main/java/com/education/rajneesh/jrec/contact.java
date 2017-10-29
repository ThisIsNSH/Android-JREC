package com.education.rajneesh.jrec;

import android.Manifest;
import android.animation.Animator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.contact123);
        if (savedInstanceState == null) {
            rootLayout.setVisibility(View.INVISIBLE);

            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.contact123);
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

        Button button = (Button) findViewById(R.id.contacts);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_VIEW);
                callIntent.setData(Uri.parse("tel:9828275532"));

                if (ActivityCompat.checkSelfPermission(contact.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Toast.makeText( contact.this, "Allow Call Permision in Phone Settings ",
                        Toast.LENGTH_LONG).show();
                startActivity(callIntent);
            }
        });

        Button button1 = (Button) findViewById(R.id.googlemaps);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
/*
                Uri gmmIntentUri = Uri.parse("geo:25.186642,75.872082");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
                startActivity(mapIntent);*/

                String url = "https://www.google.co.in/maps/place/JREC+COMPUTER+EDUCATION/@25.1865968,75.8693253,17z/data=!3m1!4b1!4m5!3m4!1s0x396f9ac1456aefb1:0xe5f3f81960cc5e9f!8m2!3d25.186592!4d75.871514";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);





            }
        });



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

        final LinearLayout myView = (LinearLayout) findViewById(R.id.contact123);

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
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.contact123);
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
        LinearLayout title = (LinearLayout) findViewById(R.id.contact123);
        title.setVisibility(View.VISIBLE);
        title.clearAnimation();
        title.startAnimation(a);





        //logoAnimation.start();
    }

}






