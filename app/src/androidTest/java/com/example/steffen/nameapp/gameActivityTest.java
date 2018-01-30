package com.example.steffen.nameapp;

import android.test.suitebuilder.annotation.LargeTest;
import android.widget.EditText;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by Schnappi on 29.01.2018.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class gameActivityTest {

    private String[] testList = {"Sondre", "steFFen", "keviN"};

    People[] testPeopleList;
    ImageAdapter ia;
    Integer score;
    Integer count;

    private String typeSteffen;
    private String typeSondre;
    private String typeKevin;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        typeSteffen = "steffen";
        typeSondre = "sondre";
        typeKevin = "kevin";
    }

    @Test
    public void answer() throws Exception {
        testPeopleList = ia.getPeople();

        // Type text and then press the button. Then do it 3 times.
        onView(withId(R.id.editText))
                .perform(typeText(typeSteffen), closeSoftKeyboard());
        onView(withId(R.id.button_game)).perform(click());

        onView(withId(R.id.editText))
                .perform(typeText(typeSondre), closeSoftKeyboard());
        onView(withId(R.id.button_game)).perform(click());

        onView(withId(R.id.editText))
                .perform(typeText(typeKevin), closeSoftKeyboard());
        onView(withId(R.id.button_game)).perform(click());

        // Check that the text was changed. CHANGEEE
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText(mStringToBetyped)));
    }

    @Test
    public void testToLowerCase(){
        assertEquals("Sondre", testList[0]);
        assertEquals("sondre", testList[0].toLowerCase());
        assertEquals("steffen", testList[1].toLowerCase());
        assertEquals("kevin", testList[2].toLowerCase());
    }

    @Test
    public void testScore(){
        EditText user = (EditText) gameActivity.findViewById(R.id.editText);
        sendKeys("sondre");


    }

}