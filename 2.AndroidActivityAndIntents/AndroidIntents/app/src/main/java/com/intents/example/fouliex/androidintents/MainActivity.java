package com.intents.example.fouliex.androidintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Android Intent is the message that is passed between components such as activities,
 * content providers, broadcast receivers and services.
 * <p>
 * Object <- Intent <- LabeledIntent
 * <p>
 * Android intents are mainly used to
 * -Start A Service
 * -Launch an activity
 * -Display a list of contacts
 * -Broadcast a message
 * -Dial a phone call etc.
 * <p>
 * <p>
 * Implicit Intent doesn't specify the component. In such case, the intent provides information of
 * available components provided by the system that is to be invoked.
 * <p>
 * Explicit Intent specifies the component.In such case inthen provides the external class to be
 * invoked
 */
public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

    }

    private void addListenerOnButton() {
        editText = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editText.getText().toString();

                // Implicit Intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

               // Explicit Intent
                /*
                Intent i = new Intent(getApplicationContext(), ActivityTwo.class);
                startActivity(i);
                */
            }
        });
    }
}
