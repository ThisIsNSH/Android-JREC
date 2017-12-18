package com.education.rajneesh.jrec;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.data.Freezable;

import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int a;
    int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // MobileAds.initialize(this, "ca-app-pub-4207929380822734~5353834001");
        setContentView(R.layout.activity_main);



/*
        //.addTestDevice("0F4C93A8E4B31EC8591E468FB2BDE152")
        NativeExpressAdView adView = (NativeExpressAdView) findViewById(R.id.adView);

        AdRequest request = new AdRequest.Builder().build();

        adView.loadAd(request);

        NativeExpressAdView ad1View = (NativeExpressAdView) findViewById(R.id.ad1View);

        AdRequest request1 = new AdRequest.Builder().build();

        ad1View.loadAd(request1);


        adView.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

        VideoController vc = adView.getVideoController();

        vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            public void onVideoEnd() {
                // Here apps can take action knowing video playback is finished
                // It's always a good idea to wait for playback to complete before
                // replacing or refreshing a native ad, for example.
                super.onVideoEnd();
            }
        });


        ad1View.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

        VideoController vc1 = ad1View.getVideoController();

        vc1.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            public void onVideoEnd() {
                // Here apps can take action knowing video playback is finished
                // It's always a good idea to wait for playback to complete before
                // replacing or refreshing a native ad, for example.
                super.onVideoEnd();
            }
        });

*/

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        a);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }


// Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        b);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        TextView myView0 = (TextView) findViewById(R.id.one);

        int[] attrs0 = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray0 = this.obtainStyledAttributes(attrs0);
        int backgroundResource0 = typedArray0.getResourceId(0, 0);
        myView0.setBackgroundResource(backgroundResource0);

        TextView myView20 = (TextView) findViewById(R.id.two);

        int[] attrs20 = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray20 = this.obtainStyledAttributes(attrs20);
        int backgroundResource20 = typedArray20.getResourceId(0, 0);
        myView20.setBackgroundResource(backgroundResource20);

        TextView myView30 = (TextView) findViewById(R.id.three);

        int[] attrs30 = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray30 = this.obtainStyledAttributes(attrs30);
        int backgroundResource30 = typedArray30.getResourceId(0, 0);
        myView30.setBackgroundResource(backgroundResource30);




        LinearLayout aboutus = (LinearLayout) findViewById(R.id.aboutussurface);
        //FrameLayout adone = (FrameLayout) findViewById(R.id.ad1);
        LinearLayout courses = (LinearLayout) findViewById(R.id.coursessurface);
      //  FrameLayout adtwo = (FrameLayout) findViewById(R.id.ad2);
        LinearLayout question = (LinearLayout) findViewById(R.id.paperssurface);
        LinearLayout main = (LinearLayout) findViewById(R.id.mainsurface);


        Animation aboutus1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        aboutus1.setStartOffset(300);
        ObjectAnimator aboutus2 = ObjectAnimator.ofFloat(aboutus, "alpha", 0, 1).setDuration(1500);
        aboutus2.start();
        aboutus2.setStartDelay(300);
        aboutus.startAnimation(aboutus1);


/*        Animation adone1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        adone1.setStartOffset(600);
        ObjectAnimator adone2 = ObjectAnimator.ofFloat(adone, "alpha", 0, 1).setDuration(1500);
        adone2.start();
        adone2.setStartDelay(600);
        adone.startAnimation(adone1);
*/

        Animation courses1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        courses1.setStartOffset(900);
        ObjectAnimator courses2 = ObjectAnimator.ofFloat(courses, "alpha", 0, 1).setDuration(1500);
        courses2.start();
        courses2.setStartDelay(900);
        courses.startAnimation(courses1);

/*
        Animation adtwo1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        adtwo1.setStartOffset(1200);
        ObjectAnimator adtwo2 = ObjectAnimator.ofFloat(adtwo, "alpha", 0, 1).setDuration(1500);
        adtwo2.start();
        adtwo2.setStartDelay(1200);
        adtwo.startAnimation(adtwo1);

*/
        Animation question1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        question1.setStartOffset(1500);
        ObjectAnimator question2 = ObjectAnimator.ofFloat(question, "alpha", 0, 1).setDuration(1500);
        question2.start();
        question2.setStartDelay(1500);
        question.startAnimation(question1);





        Animation main1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        main1.setStartOffset(0);
        ObjectAnimator main2 = ObjectAnimator.ofFloat(main, "alpha", 0, 1).setDuration(1500);
        main2.start();
        main2.setStartDelay(0);
        main.startAnimation(main1);

    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 'a': {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request

            case 'b': {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request

        }
    }


    //SHARED ELEMENT TRANSTION aboutusexpand
    public void aboutexpand(View view) {

        // Ordinary Intent for launching a new activity
        Intent intent = new Intent(this, aboutexpand.class);

        // Get the transition name from the string
        String transitionName = getString(R.string.simple);

        // Define the view that the animation will start from
        View viewStart = findViewById(R.id.aboutussurface);

        ActivityOptionsCompat options =

                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        viewStart,   // Starting view
                        transitionName    // The String
                );
        //Start the Intent
        ActivityCompat.startActivity(this, intent, options.toBundle());
        Toast.makeText(MainActivity.this, "Use back button to go back!!",
                Toast.LENGTH_LONG).show();

    }


    //SHARED ELEMENT TRANSTION coursesexpand
    public void coursesexpand(View view) {

        // Ordinary Intent for launching a new activity
        Intent intent = new Intent(this, coursesexpand.class);

        // Get the transition name from the string
        String transitionName = getString(R.string.simple1);

        // Define the view that the animation will start from
        View viewStart = findViewById(R.id.coursessurface);

        ActivityOptionsCompat options =

                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        viewStart,   // Starting view
                        transitionName    // The String
                );
        //Start the Intent
        ActivityCompat.startActivity(this, intent, options.toBundle());
        Toast.makeText(MainActivity.this, "Use back button to go back!!",
                Toast.LENGTH_LONG).show();

    }





    //SHARED ELEMENT TRANSTION fab
    public void fabclick(View view) {


        // Ordinary Intent for launching a new activity
        Intent intent = new Intent(this, fab.class);

        // Get the transition name from the string
        String transitionName = getString(R.string.fab1);

        // Define the view that the animation will start from
        View viewStart = findViewById(R.id.fab);

        ActivityOptionsCompat options =

                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        viewStart,   // Starting view
                        transitionName    // The String
                );
        //Start the Intent
        ActivityCompat.startActivity(this, intent, options.toBundle());


    }


    //SHARED ELEMENT TRANSTION paperexpand
  /*  public void paperexpand(View view) {

        // Ordinary Intent for launching a new activity
        Intent intent = new Intent(this, paperexpand.class);

        // Get the transition name from the string
        String transitionName = getString(R.string.simple7);

        // Define the view that the animation will start from
        View viewStart = findViewById(R.id.paperssurface);

        ActivityOptionsCompat options =

                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        viewStart,   // Starting view
                        transitionName    // The String
                );
        //Start the Intent
        ActivityCompat.startActivity(this, intent, options.toBundle());
        Toast.makeText(MainActivity.this, "Scroll down for more courses",
                Toast.LENGTH_LONG).show();


    }

        public void info2(View view){
    Toast.makeText(MainActivity.this, "Developer: Nishant Singh Hada    WhatsApp: 9560705734",
            Toast.LENGTH_LONG).show();

    ImageView icon = (ImageView)    findViewById(R.id.info1);
    icon.setElevation(8);

}*/

}




