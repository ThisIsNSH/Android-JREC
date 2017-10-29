package com.education.rajneesh.jrec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class coursesexpand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursesexpand);

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
