package com.example.service.fouliex.androidservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import static com.example.service.fouliex.androidservice.R.raw;

/**
 * Created by George Fouche on 3/13/17.
 */

public class MyService extends Service {
MediaPlayer myPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        Toast.makeText(this,"Service Created",Toast.LENGTH_LONG).show();
        myPlayer = MediaPlayer.create(this, raw.jazz_rag_ensemble);
        myPlayer.setLooping(false);//Set it to loop
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        myPlayer.start();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service Stopped",Toast.LENGTH_LONG).show();
        myPlayer.stop();
    }
}
