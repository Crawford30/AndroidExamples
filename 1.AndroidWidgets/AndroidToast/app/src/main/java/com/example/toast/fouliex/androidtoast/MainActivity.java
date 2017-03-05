package com.example.toast.fouliex.androidtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Android Toast can be used to display information for a short or long period of time.
 * Object <- Toast
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Displaying Toast with Hello World message
        Toast.makeText(MainActivity.this,"Hello World",Toast.LENGTH_SHORT).show();
    }
}
