package com.example.preferences.fouliex.androidpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button storeinforamtion = (Button) findViewById(R.id.storeinformation);
        Button showinformation = (Button)findViewById(R.id.storeinformation);

    }
}
