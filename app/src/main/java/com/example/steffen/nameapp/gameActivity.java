package com.example.steffen.nameapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kevin on 22-Jan-18.
 */

public class gameActivity extends AppCompatActivity {

    People[] list;
    ImageAdapter ia;
    Integer score;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ia = new ImageAdapter(this);
        list = ia.getPeople();
        score = 0;
        play();
    }

    protected void play(){

        for(int i = 0; i<list.length; i++) {
            game(i);

        }
    }

    protected void game(int i){

                setContentView(R.layout.activity_game);
                ImageView iw = (ImageView) findViewById(R.id.imageView3);
                Integer image = list[i].getUri();
                iw.setImageResource(image);
                EditText user = (EditText) findViewById(R.id.editText);
                String input = user.getText().toString();
                if(input.equals(list[i].getName())){
                    Toast.makeText(gameActivity.this, "Correct - Current Score:"+score,
                            Toast.LENGTH_LONG).show();
                            score = score+1;
                }else{
                    Toast.makeText(gameActivity.this, "Wrong - Current Score:"+score,
                            Toast.LENGTH_LONG).show();
                }
    }
}
