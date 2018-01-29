package com.example.steffen.nameapp;

import android.widget.EditText;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Schnappi on 29.01.2018.
 */
public class gameActivityTest {

    String[] testList = {"Sondre", "steFFen", "keviN"};
    Integer score = 0;

    @Test
    public void answer() throws Exception {
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