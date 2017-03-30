package com.video.example.fouliex.androidvideo;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Uri fileUri;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    private static MainActivity ActivityContext = null;
    private File mediaStorageDir;
    private Button buttonRecording;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(ActivityContext,new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
        buttonRecording = (Button) findViewById(R.id.recording);
    }

    /**
     * This function run about the camera screen has been executed
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Video saved to: " + data.getData(), Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "User cancelled the video", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Video capture failed", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE:
                if(grantResults.length >0){
                    buttonRecording.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                            // create a file to save the video
                            fileUri = getOutPutMediaFileUri(MEDIA_TYPE_VIDEO);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                            // set the video image quality to high
                            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                            // start the Video Capture Intent
                            startActivityForResult(intent, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
                        }
                    });
                }
        }

    }

    /**
     * Create a file URi to save an image or video
     *
     * @param mediaType
     * @return
     */
    private Uri getOutPutMediaFileUri(int mediaType) {
        return Uri.fromFile(getOutputMediaFile(mediaType));

    }

    /**
     * Create a File for saving an image or video
     *
     * @param mediaType
     * @return
     */
    private File getOutputMediaFile(int mediaType) {
        if (!isSDCardMounted()) {
            createStorageDir();
        }
        return createMediaFile(mediaType);
    }

    /**
     * Check that the SDCard is mounted
     *
     * @return
     */
    private boolean isSDCardMounted() {
        mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyMedia");
        return mediaStorageDir.exists();
    }


    /**
     * Create the storage directory (MyMedia) if it does not exist
     */
    private void createStorageDir() {
        if (!mediaStorageDir.mkdirs()) {
            Toast.makeText(ActivityContext, "Failed to create directory MyCameraVideo.",
                    Toast.LENGTH_LONG).show();
            Log.d("MyMedia", "Failed to create directory MyCameraVideo.");

        }
    }

    /**
     * Create a media file name
     *
     * @param mediaType
     */
    private File createMediaFile(int mediaType) {
        Date date = new Date();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date.getTime());

        File mediaFile = null;
        if (mediaType == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "VID_" + timeStamp + ".mp4");
        }

        return mediaFile;
    }
}
