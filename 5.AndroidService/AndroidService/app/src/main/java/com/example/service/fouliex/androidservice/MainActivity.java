package com.example.service.fouliex.androidservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Android Service is a component that is used to perform operations on the background,for example
 * playing music,handle network transactions, interacting content providers etc.
 * <p>
 * It doesn't have any UI and the service runs in the background indefinitely even if the
 * application is destroyed.
 * <p>
 * Service <- ContextWrapper <- Context <- Object.
 * <p>
 * There can be two forms of a service. The lifecycle of service can follow two different paths:
 * 1. Started
 * 2. Bound
 * <p>
 * Started Service
 * A service is started when a component such as an Activity calls startService() method and the
 * service will run in the background indefinitely. it will stop by calling stopService() method or
 * the Service can stop itself by calling the stopSelf() method.
 * <p>
 * Bound Service
 * <p>
 * A service is bound when another component such as a client calls BindService() method. The client
 * can unbind the service by calling the unbindService() method. The service can't be stopped until
 * all clients unbind the service.
 *
 *
 * In this Service example, the audio will not stopped even if we switch to another activity.
 * The audio will only when the stop button(Stop Service ) is pressed.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonStart, buttonStop, buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);
        buttonNext = (Button) findViewById(R.id.buttonNext);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.buttonStart:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.buttonStop:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.buttonNext:
                Intent intent=new Intent(this,NextPage.class);
                startActivity(intent);
                break;
        }
    }
}
