package com.example.steffen.nameapp;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Schnappi on 02.02.2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class buttonsActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void testPictureButton() throws Exception {

        onView(withId(R.id.Bilder)).perform(click());
        intended(hasComponent(PictureActivity.class.getName()));

    }

    @Test
    public void testNameButton() throws Exception {

        onView(withId(R.id.Navn)).perform(click());
        intended(hasComponent(NamesActivity.class.getName()));


    }

    @Test
    public void testGameButton() throws Exception {

        onView(withId(R.id.Spill)).perform(click());
        intended(hasComponent(gameActivity.class.getName()));


    }

    @Test
    public void testPrefButton() throws Exception {

        onView(withId(R.id.Settings)).perform(click());
        intended(hasComponent(UserPrefs.class.getName()));


    }

}