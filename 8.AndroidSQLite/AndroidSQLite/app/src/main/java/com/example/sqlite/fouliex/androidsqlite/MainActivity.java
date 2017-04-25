package com.example.sqlite.fouliex.androidsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        //Inserting Contacts
        Log.d("Insert:", "Inserting..");
        db.addContact(new Contact("George","55555555555"));
        db.addContact(new Contact("Erol","111111111111"));

        //Reading all contacts
        Log.d("Reading: ","Reading all contacts..");
        List<Contact> contacts =db.getAllContacts();

        for(Contact cn : contacts){
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }

}
