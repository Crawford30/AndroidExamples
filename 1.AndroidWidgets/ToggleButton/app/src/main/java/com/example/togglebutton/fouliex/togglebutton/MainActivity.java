package com.example.togglebutton.fouliex.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Android Toggle Button can be used to display checked/unchecked (On/Off) state on the button.
 * <p>
 * It is beneficial if user have to change the setting between two states such as ON/OFF for sound,
 * Wifi,Bluetooth etc.
 */
public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton1, toggleButton2;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();
    }

    private void addListenerOnButtonClick() {
        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        buttonSubmit = (Button) findViewById(R.id.button1);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder result = new StringBuilder();
                result.append("ToggleButton1: ").append(toggleButton1.getText());
                result.append("\nToggleButton2 :").append(toggleButton2.getText());
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
