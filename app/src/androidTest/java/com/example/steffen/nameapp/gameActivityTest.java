package com.example.steffen.nameapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.steffen.nameapp.Activities.gameActivity;

import org.junit.Assert;
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
import static org.junit.Assert.assertEquals;

/**
 * Created by Schnappi on 29.01.2018.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class gameActivityTest {

    private String[] testList = {"Sondre", "steFFen", "keviN"};

    private String typeSteffen, typeSondre, typeKevin;

    @Rule
    public ActivityTestRule<gameActivity> gActivityRule = new ActivityTestRule<>(gameActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        typeSteffen = "steffen";
        typeSondre = "sondre";
        typeKevin = "kevin";
    }

    @Test
    public void answer() throws Exception {

        // Type text and then press the button. Then do it 3 times.
        // maybe we need to remove shuffling of the array in gameActivity
        onView(withId(R.id.editText)).perform(typeText(typeSondre), closeSoftKeyboard());

        // Quick check if editText was changed.
        onView(withId(R.id.editText)).check(matches(withText(typeSondre)));

        onView(withId(R.id.button_game)).perform(click());

        onView(withId(R.id.editText)).perform(typeText(typeSondre), closeSoftKeyboard());
        onView(withId(R.id.button_game)).perform(click());

        onView(withId(R.id.editText)).perform(typeText(typeSondre), closeSoftKeyboard());
        onView(withId(R.id.button_game)).perform(click());

        //somebody toucha my SPAGHET >:(
        int scoree = gActivityRule.getActivity().getScore();
        Assert.assertEquals(1, scoree);

    }

    @Test
    public void testToLowerCase(){
        assertEquals("Sondre", testList[0]);
        assertEquals("sondre", testList[0].toLowerCase());
        assertEquals("steffen", testList[1].toLowerCase());
        assertEquals("kevin", testList[2].toLowerCase());

    }

}