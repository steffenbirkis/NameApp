package com.example.steffen.nameapp;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.steffen.nameapp.Activities.MainActivity;
import com.example.steffen.nameapp.Activities.addActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;
import static com.example.steffen.nameapp.Logic.ImageAdapter.plist;
import static org.junit.Assert.*;

/**
 * Created by Schnappi on 05.02.2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class addActivityTest {

    String typeName;

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        typeName = "TEST TEST";

    }

    @Test
    public void testAddPerson() throws Exception {

        onView(withId(R.id.Bilder)).perform(click());
        onView(withId(R.id.btnallservice1)).perform(click());
        intended(hasComponent(addActivity.class.getName()));

        onView(withId(R.id.Name)).perform(clearText()).perform(typeText(typeName), closeSoftKeyboard());
        onView(withId(R.id.Save)).perform(click());

        assertEquals(4, plist.length);

    }


}