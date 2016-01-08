
package com.example.testapp.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import android.widget.RelativeLayout;

import com.example.testapp.R;


public abstract class Baseactivity extends AppCompatActivity {

    public FrameLayout container;
    public android.support.v7.widget.Toolbar toolbar;
    public RelativeLayout mainlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        container = (FrameLayout) findViewById(R.id.container);
        mainlayout = (RelativeLayout) findViewById(R.id.fulllayout);

        //Set the custom toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(R.string.app_name);
            toolbar.setTitleTextColor(Color.WHITE);
        }
    }

    // Method to set xml object reference.
    public abstract void setReference();
}