package com.example.steffen.nameapp;

/**
 * Created by Steffen on 11.01.2018.
 */
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class PictureActivity extends AppCompatActivity  {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_picture);
    ImageAdapter ia = new ImageAdapter(this);
    final People plist[] = ia.getPeople();
    GridView gridview = (GridView) findViewById(R.id.gridview);
    gridview.setAdapter(ia);

    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v,
                                int position, long id) {
            Toast.makeText(PictureActivity.this, "" + plist[position],
                    Toast.LENGTH_SHORT).show();
        }
    });
}
public void addNew(View view){
    Intent myIntent = new Intent(view.getContext(), addActivity.class);
    startActivityForResult(myIntent, 0);
}


    }













