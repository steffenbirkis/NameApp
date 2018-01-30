package com.example.steffen.nameapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

import static com.example.steffen.nameapp.ImageAdapter.plist;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            if(plist.length==0){
                People a=new People("steffen",People.getFromResource(this,R.drawable.sample_1));
                People b=new People("Sondre",People.getFromResource(this, R.drawable.sample0));
                ImageAdapter.addPeople(a);
                ImageAdapter.addPeople(b);
            }
        checkPrefs();
    }

    public void onPic(View view){
        Intent myIntent = new Intent(view.getContext(), PictureActivity.class);
        startActivityForResult(myIntent, 0);
    }

    public void onName(View view){
        Intent myIntent = new Intent(view.getContext(), NamesActivity.class);
        startActivityForResult(myIntent, 0);
    }

    public void onGame(View view){
        Intent myIntent = new Intent(view.getContext(), gameActivity.class);
        startActivityForResult(myIntent, 0);
    }

    public void onPrefs(View view){
        Intent myIntent = new Intent(view.getContext(), UserPrefs.class);
        startActivityForResult(myIntent, 0);
    }

    public void checkPrefs(){
        SharedPreferences prefs = this.getSharedPreferences(
                "name", Context.MODE_PRIVATE);
        String pref = prefs.toString();
        if(pref.equals("name") || pref.equals("")) {
            Intent myIntent = new Intent(this, UserPrefs.class);
            startActivityForResult(myIntent, 0);
        }
    }
}


