package com.example.steffen.nameapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kevin on 22-Jan-18.
 */

public class gameActivity extends AppCompatActivity {

    People[] list;
    ImageAdapter ia;
    Integer score;
    Integer count;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ia = new ImageAdapter(this);
        list = ia.getPeople();
        score = 0;
        count = 0;

        setContentView(R.layout.activity_game);
        ImageView iw = (ImageView) findViewById(R.id.imageView3);
        Integer image = list[count].getUri();
        iw.setImageResource(image);

        Button button = (Button) findViewById(R.id.button_game);

        button.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                answer();
            }
        });
    }


    protected void answer(){
        EditText user = (EditText) findViewById(R.id.editText);
        String input = user.getText().toString();
        if(input.equals(list[count].getName())){
            Toast.makeText(gameActivity.this, "Correct - Current Score:"+score,
                    Toast.LENGTH_LONG).show();
            score = score+1;
        }else{
            Toast.makeText(gameActivity.this, "Wrong - Current Score:"+score,
                    Toast.LENGTH_LONG).show();
        }
        count = count+1;
        if(count<list.length) {
            setContentView(R.layout.activity_game);
            ImageView iw = (ImageView) findViewById(R.id.imageView3);
            Integer image = list[count].getUri();
            iw.setImageResource(image);
        }else{
            setContentView(R.layout.activity_result);
            TextView txt = (TextView) findViewById(R.id.textView2);
            txt.setText(score.toString()+" out of "+count.toString());
        }

    }

}
