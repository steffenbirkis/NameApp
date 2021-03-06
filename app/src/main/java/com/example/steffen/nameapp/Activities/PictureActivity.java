package com.example.steffen.nameapp.Activities;

/**
 * Created by Steffen on 11.01.2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.steffen.nameapp.Logic.ImageAdapter;
import com.example.steffen.nameapp.Logic.People;
import com.example.steffen.nameapp.R;

public class PictureActivity extends AppCompatActivity {        //Uses Imageadapter to place thumbnails in a gridview
    private ImageAdapter ia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ia = new ImageAdapter(this);
        final People plist[] = ia.getPeople();
        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(ia);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(PictureActivity.this, "" + plist[position].getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addNew(View view) {
        Intent myIntent = new Intent(view.getContext(), addActivity.class);
        startActivityForResult(myIntent, 0);
    }
}













