package com.example.steffen.nameapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
        Integer list[];
        ImageAdapter ia = new ImageAdapter(this);
        list = ia.getmThumbIds();
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(arrayAdapter);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(NamesActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
