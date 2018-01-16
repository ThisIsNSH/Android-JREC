package com.education.rajneesh.jrecapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
       RunAnimations();
        Button button = (Button) findViewById(R.id.googlemaps);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Uri gmmIntentUri = Uri.parse("geo:25.186680,75.871913");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
                startActivity(mapIntent);
            }
        });
/*
    }
        Uri gmmIntentUri = Uri.parse("geo:25.186680,75.871913");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }
*/
}

    @Override
    public void finish() {
        super.finish();
        RunAnimations1();

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
        ImageView title = (ImageView) findViewById(R.id.imageview);
        title.setVisibility(View.VISIBLE);
        title.clearAnimation();
        title.startAnimation(a);





        //logoAnimation.start();
    }

    private void RunAnimations1() {


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
        ImageView title = (ImageView) findViewById(R.id.imageview);
        title.setVisibility(View.INVISIBLE);
        title.clearAnimation();
        title.startAnimation(a);





        //logoAnimation.start();
    }










}

