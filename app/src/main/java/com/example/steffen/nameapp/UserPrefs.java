package com.example.steffen.nameapp;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by kevin on 25-Jan-18.
 */

public class UserPrefs extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(android.R.id.content, new UserPrefsFragment());
        transaction.commit();
    }

    public static class UserPrefsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            PreferenceManager manager = getPreferenceManager();
            manager.setSharedPreferencesName("user_prefs");
            addPreferencesFromResource(R.xml.userprefs);
        }
    }
}