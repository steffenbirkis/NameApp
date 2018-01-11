package com.example.steffen.nameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onPic(View view){
        Intent myIntent = new Intent(view.getContext(), PictureActivity.class);
        startActivityForResult(myIntent, 0);
    }


        //Halla bror !!!
        //sup
    }


