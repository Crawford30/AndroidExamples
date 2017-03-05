package com.example.button.fouliex.androidbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Android Button represents a push-button.
 * The android.widget.Button is a subclass of TextView class and CompoundButton is the subclass of Button class.
 * <p>
 * Object <- View <- TextView <- Button <- CompoundButton
 * <p>
 * There are different types of button in android such as RadioButton,ToggleButton and CompoundButton.
 * <p>
 * From this example, we are going to create two Textfields and one Button for sum of two numbers.
 */
public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button buttonSum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    private void addListenerOnButton() {
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        buttonSum = (Button) findViewById(R.id.button1);
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = editText1.getText().toString();
                String value2 = editText2.getText().toString();

                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int sum = a + b;
                Toast.makeText(getApplicationContext(),String.valueOf(sum), LENGTH_LONG).show();
            }
        });
    }


}
