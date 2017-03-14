package com.example.alarm.fouliex.androidalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

/**
 * Created by George Fouche on 3/14/17.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{
MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        //TODO add an alarm file
        //mediaPlayer = MediaPlayer.create(context,R.raw.alrm);
        mediaPlayer.start();
        Toast.makeText(context,"Alarm...",Toast.LENGTH_LONG).show();
    }
}
