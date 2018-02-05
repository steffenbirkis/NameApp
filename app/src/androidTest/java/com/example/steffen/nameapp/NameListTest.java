package com.example.steffen.nameapp;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.example.steffen.nameapp.Activities.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by kevin on 05-Feb-18.
 */
@RunWith(AndroidJUnit4.class)
public class NameListTest {

        private int numberOfDefaultUsers = 3;

        @Rule
        public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

        @Test
        public void theInitialNamesAreOnTheListWhenLaunched(){
            onView(withId(R.id.Navn)).perform(click());
            onView (withId (R.id.names_listview)).check (ViewAssertions.matches (HelpClass.withListSize (numberOfDefaultUsers)));
        }
    }