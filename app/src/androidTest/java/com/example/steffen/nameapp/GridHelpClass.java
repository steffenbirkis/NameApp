package com.example.steffen.nameapp;

import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by kevin on 05-Feb-18.
 */

public class GridHelpClass {
    public static Matcher<View> withGridSize (final int size) {
        return new TypeSafeMatcher<View>() {
            @Override public boolean matchesSafely (final View view) {
                return ((GridView) view).getCount () == size;
            }

            @Override public void describeTo (final Description description) {
                description.appendText ("ListView should have " + size + " items");
            }
        };
    }
}
