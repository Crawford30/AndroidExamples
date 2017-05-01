package com.example.sqlite.fouliex.androidsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

/**
 *SQlite is an open-source relational database used to perform database operations on android devices
 * Since it is embedded with android by default there's not need to perform any database setup or
 * admin task.
 *
 * This example of SQlite store and fetch Contact data which are display as logcat logs.
 */
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
