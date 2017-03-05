package com.intents.activity.example.fouliex.androidactivityandintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Android Activity Lifecycle is controlled by 7 methods of android.app.Activity class.The android
 * Activity is the ContextThemeWrapper class.
 *
 * Object <- Context <- ContextWrapper <- ContextThemeWrapper <- Activity
 *
 * And activity is the single screen in android. It is very similar to window or frame in Java.By the
 * help of activity, we can place all our UI components or widgets in a single screen.
 *
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when activity is first created.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("**LifeCycle", "onCreate invoked");
    }

    /**
     * Called when an activity is becoming visible to the user.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("**Lifecycle","onStart invoked");
    }

    /**
     * Called when activity will start interacting with the user.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("**Lifecycle","onResume invoked");
    }

    /**
     * Called when activity is not visible to the user.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("**Lifecycle","onPause invoked");
    }

    /**
     * Called when activity is no longer visible to the user.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("**Lifecycle","onStop invoked");
    }

    /**
     * Called after your activity is stopped, prior to start.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("**Lifecycle","onRestart invoked");
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("**Lifecycle","onDestroy invoked");
    }
}
