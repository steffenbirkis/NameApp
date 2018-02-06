package com.example.steffen.nameapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.test.InstrumentationRegistry;
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
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
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
        mockTakePhoto();

        onView(withId(R.id.Save)).perform(click());

        assertEquals(4, plist.length);

    }
    private void mockTakePhoto(){
        Bitmap icon = BitmapFactory.decodeResource(
                InstrumentationRegistry.getTargetContext().getResources(),
                R.drawable.sample_4);

        // Build a result to return from the Camera app
        Intent resultData = new Intent();
        resultData.putExtra("data", icon);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

        // Stub out the Camera. When an intent is sent to the Camera, this tells Espresso to respond
        // with the ActivityResult we just created
        intending(toPackage("com.android.camera")).respondWith(result);
        intending(toPackage("com.android.camera2")).respondWith(result);

        // Now that we have the stub in place, click on the button in our app that launches into the Camera
        onView(withId(R.id.button)).perform(click());
    }

}