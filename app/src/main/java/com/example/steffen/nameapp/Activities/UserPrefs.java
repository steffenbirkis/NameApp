package com.example.steffen.nameapp.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import com.example.steffen.nameapp.Activities.PrefPic;
import com.example.steffen.nameapp.R;

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
            Preference myPref = findPreference("select_image");
            myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    Intent myIntent = new Intent(preference.getContext(), PrefPic.class);
                    startActivityForResult(myIntent, 0);
                    return true;
                }
            });
        }
    }
}