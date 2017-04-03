package com.example.storage.external.fouliex.androidexternalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * From this example data is save to the device external memory, the sdcard. FileInputStream and
 * FileOutputStream classes are used to read and write data which is then save to the sdcard.
 */
public class MainActivity extends AppCompatActivity {

    EditText editTextFileName, editTextData;
    Button saveButton, readButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFileName = (EditText) findViewById(R.id.editText1);
        editTextData = (EditText) findViewById(R.id.editText2);
        saveButton = (Button) findViewById(R.id.button1);
        readButton = (Button) findViewById(R.id.button2);

        onSaveButton();
        onReadButton();


    }

    private void onReadButton() {
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = editTextFileName.getText().toString();
                String aDataRow;
                String aBuffer = "";
                try {
                    File myFile = new File("/sdcard/" + filename);
                    FileInputStream fIn = new FileInputStream(myFile);
                    BufferedReader myReader = new BufferedReader(
                            new InputStreamReader(fIn));

                    while ((aDataRow = myReader.readLine()) != null) {
                        aBuffer += aDataRow + "\n";
                    }
                    myReader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), aBuffer, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void onSaveButton() {
        // Performing action on save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = editTextFileName.getText().toString();
                String data = editTextData.getText().toString();

                FileOutputStream fos;
                try {
                    File myFile = new File("/sdcard/" + filename);
                    myFile.createNewFile();
                    FileOutputStream fOut = new

                            FileOutputStream(myFile);
                    OutputStreamWriter myOutWriter = new

                            OutputStreamWriter(fOut);
                    myOutWriter.append(data);
                    myOutWriter.close();
                    fOut.close();

                    Toast.makeText(getApplicationContext(), filename + " saved", Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });
    }
}
