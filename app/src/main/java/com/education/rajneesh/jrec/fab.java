package com.education.rajneesh.jrec;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.EditText;
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

        Button send = (Button) findViewById(R.id.submit);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                EditText name = (EditText) findViewById(R.id.name);
                EditText mobile = (EditText) findViewById(R.id.mobile);
                EditText email = (EditText) findViewById(R.id.email);
                EditText message = (EditText) findViewById(R.id.message);

                String name1 = name.getText().toString();
                String mobile1 = mobile.getText().toString();
                String email2 = email.getText().toString();
                String message1 = message.getText().toString();


                Intent email1 = new Intent(Intent.ACTION_SEND);
                email1.setData(Uri.parse("mailto:"));

                email1.setType("message/rfc822");
                email1.putExtra(Intent.EXTRA_EMAIL, new String[]{"jrec.singh@gmail.com"});
                email1.putExtra(Intent.EXTRA_SUBJECT, "App Query");
                email1.putExtra(Intent.EXTRA_TEXT, "Name: " + name1 + "\nAddress: " + email2 + "\nMobile: " + mobile1 + "\n\nMessage: " + message1);
                if (email1.resolveActivity(getPackageManager()) != null) {
                    startActivity(email1);
                }

            }
        });
        EditText myView = (EditText) findViewById(R.id.name);

        int[] attrs = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray = this.obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);
        myView.setBackgroundResource(backgroundResource);


        EditText myView1 = (EditText) findViewById(R.id.mobile);

        int[] attrs1 = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray1 = this.obtainStyledAttributes(attrs1);
        int backgroundResource1 = typedArray1.getResourceId(0, 0);
        myView1.setBackgroundResource(backgroundResource1);


        EditText myView2 = (EditText) findViewById(R.id.email);

        int[] attrs2 = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray2 = this.obtainStyledAttributes(attrs2);
        int backgroundResource2 = typedArray2.getResourceId(0, 0);
        myView2.setBackgroundResource(backgroundResource2);


        EditText myView3 = (EditText) findViewById(R.id.message);

        int[] attrs3 = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray3 = this.obtainStyledAttributes(attrs3);
        int backgroundResource3 = typedArray3.getResourceId(0, 0);
        myView3.setBackgroundResource(backgroundResource3);

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.contactsurface);
        if (savedInstanceState == null) {
            rootLayout.setVisibility(View.INVISIBLE);

            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.contactsurface);
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





       // LinearLayout one = (LinearLayout) findViewById(R.id.fabsurface1);
      // FrameLayout fab = (FrameLayout) findViewById(R.id.fab_two);
       // fab.setVisibility(View.INVISIBLE);
       // one.setVisibility(View.INVISIBLE);



        }

    public void back(View view)
    {
        finish();
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
