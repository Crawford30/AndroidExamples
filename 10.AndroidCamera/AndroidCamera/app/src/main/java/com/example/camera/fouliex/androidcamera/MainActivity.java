package com.example.camera.fouliex.androidcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Camera is mainly used to capture picture and video.
 * <p>
 * Android provides the functionality to work with the camera via:
 * 1. Camera Intent
 * 2. Camera API
 * <p>
 * <p>
 * <p>
 * Basic 4 classes of Camera Intent and API
 * <p>
 * <p>
 * 1.Intent
 * By the help of 2 constants of MediaStore class, we can capture picture and video without
 * using the instance of Camera class.
 * 1.ACTION_IMAGE_CAPTURE
 * 2.ACTION_VIDEO_CAPTURE
 * <p>
 * 2. Camera
 * It is the main class of camera api. that can be used to take picture and video.
 * <p>
 * 3. SurfaceView
 * It represents a surface view or preview of live camera.
 * <p>
 * 4. MediaRecorder
 * It is used to record video using camera. It can also be used to record audio files.
 *
 * This example use camera Intent to capture a photo and then display the photo using imageView.
 */
public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 200; // OK
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) this.findViewById(R.id.imageView1);
        Button photoButton = (Button) this.findViewById(R.id.button1);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}
