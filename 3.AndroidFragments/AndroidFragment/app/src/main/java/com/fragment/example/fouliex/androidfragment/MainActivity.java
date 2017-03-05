package com.fragment.example.fouliex.androidfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Android Fragment is part of Activity and also known as sub-activity. There can be more than one
 * fragment in an activity. It represent multiple screen inside one activity.
 *
 * Fragment lifecycle is affected by activity lifecycle because fragments are included in activity.
 * Each fragment has its own life cycle methods that is affected by activity life cycle because
 * fragments are embedded in activity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
