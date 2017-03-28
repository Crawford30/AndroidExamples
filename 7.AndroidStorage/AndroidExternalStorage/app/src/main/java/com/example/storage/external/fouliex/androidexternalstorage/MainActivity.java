package com.example.storage.external.fouliex.androidexternalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * From this example data is save to the device external memory, the sdcard. FileInputStream and
 * FileOutputStream classes are used to read and write data which is then save to the sdcard.
 */
public class MainActivity extends AppCompatActivity {

    EditText editTextFileName,editTextData;
    Button saveButton,readButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
