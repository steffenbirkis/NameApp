package com.example.steffen.nameapp.Activities;


import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.steffen.nameapp.Logic.ImageAdapter;
import com.example.steffen.nameapp.Logic.People;
import com.example.steffen.nameapp.R;

import java.util.Random;

/**
 * Created by kevin on 22-Jan-18.   //shuffles the pictures array and starts the learning game
 */

public class gameActivity extends AppCompatActivity {

    private People[] list;
    private ImageAdapter ia;
    private Integer score = 0;
    private Integer count = 0;


    private ImageView iw;


    @TargetApi(19)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ia = new ImageAdapter(this);
        list = ia.getPeople();
        list = shuffleArray(list);
        setContentView(R.layout.activity_game);

        iw = findViewById(R.id.imageView3);
        if (list.length > 0) {
            Bitmap image = list[count].getUri();
            iw.setImageBitmap(image);
        } else {
            Toast.makeText(this, "You need to add pictures first", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (list.length == 0) {
            People a = new People("Steffen", People.getFromResource(this, R.drawable.sample_1));
            People b = new People("Sondre", People.getFromResource(this, R.drawable.sample0));
            People c = new People("Kevin", People.getFromResource(this, R.drawable.sample_4));
            ImageAdapter.addPeople(a);
            ImageAdapter.addPeople(b);
            ImageAdapter.addPeople(c);
        }
        Button button = findViewById(R.id.button_game);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                animateOut(iw);

                answer();

            }
        });
    }

    protected void answer() {

        EditText user = findViewById(R.id.editText);
        String input = user.getText().toString();
        if (input.toLowerCase().equals(list[count].getName().toLowerCase())) {
            score = score + 1;
            Toast.makeText(gameActivity.this, "Correct - Current Score:" + score,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(gameActivity.this, "Wrong - Current Score:" + score,
                    Toast.LENGTH_LONG).show();
        }
        count = count + 1;
        if (count < list.length) {
            //  setContentView(R.layout.activity_game);
            ImageView iw = findViewById(R.id.imageView3);

            Bitmap image = list[count].getUri();
            user.setText("");
            iw.setImageBitmap(image);
            Button button = findViewById(R.id.button_game);
            animateIn(iw);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    answer();
                }
            });
        } else {
            animateOut(iw);
            setContentView(R.layout.activity_result);
            TextView txt = findViewById(R.id.textView2);
            txt.setText(score.toString() + " out of " + count.toString());

        }

    }

    static People[] shuffleArray(People[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            People a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    public void animateIn(ImageView iv) {
        int fadeInDuration = 1000;
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator(1)); // add this
        fadeIn.setDuration(fadeInDuration);
        iv.setAnimation(fadeIn);
        iv.startAnimation(fadeIn);

    }

    public void animateOut(ImageView iv) {
        int fadeInDuration = 1000;
        Animation fadeIn = new AlphaAnimation(1, 0);
        fadeIn.setInterpolator(new DecelerateInterpolator(1)); // add this
        fadeIn.setDuration(fadeInDuration);
        iv.setAnimation(fadeIn);
        iv.startAnimation(fadeIn);

    }

    public void back(View view) {
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
    }

    public Integer getScore() {
        return score;
    }

}


