package com.example.service.fouliex.androidservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Android Service is a component that is used to perform operations on the background,for example
 * playing music,handle network transactions, interacting content providers etc.
 * <p>
 * It doesn't have any UI and the service runs in the background indefinitely even if the
 * application is destroyed.
 * <p>
 * Service <- ContextWrapper <- Context <- Object.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
