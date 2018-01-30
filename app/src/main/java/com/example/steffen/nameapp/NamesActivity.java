package com.example.steffen.nameapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kevin on 18-Jan-18.
 */

public class NamesActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        ListView listview = (ListView) findViewById(R.id.names_listview);
        final People list[];
        String stringlist[];
        ImageAdapter ia = new ImageAdapter(this);
        list = ia.getPeople();
        stringlist = new String[list.length];
        for(int i = 0; i<list.length; i++){
            stringlist[i] = list[i].getName();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringlist);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                setContentView(R.layout.activity_singlepic);
                ImageView iw = (ImageView) findViewById(R.id.ImageView2);
                Bitmap image = list[position].getUri();
                iw.setImageBitmap(image);
            }
        });

    }
    public void addNew(View view) {
        Intent myIntent = new Intent(view.getContext(), addActivity.class);
        startActivityForResult(myIntent, 0);
    }
}
