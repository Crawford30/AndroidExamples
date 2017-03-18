package com.example.preferences.fouliex.androidpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by George Fouche on 3/16/17.
 */
public class PrefsActivity extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}

