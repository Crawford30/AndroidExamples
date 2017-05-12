package com.example.seekbar.fouliex.androidseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * Android SeekBar is a draggable thumb bar. The user can drag the thum left and right to move the
 * of song, movie etc. SeekBar is the subclass of AbsSeekBar.
 *
 * SeekBar -> AbsSeekBar -> ProgressBar -> View -> Object
 *
 */
public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        Toast.makeText(getApplicationContext(), "seekbar touch started!" + progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(), "seekbar touch started!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(), "seekbar touch stopped", Toast.LENGTH_SHORT).show();
    }
}
