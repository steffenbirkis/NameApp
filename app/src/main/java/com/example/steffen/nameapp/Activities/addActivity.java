package com.example.steffen.nameapp.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.steffen.nameapp.Logic.ImageAdapter;
import com.example.steffen.nameapp.Logic.People;
import com.example.steffen.nameapp.R;

/**
 * Created by Steffen on 11.01.2018.
 */

public class addActivity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;

    private ImageView mImageView;
    private String mCurrentPhotoPath;
    private Bitmap imageBitmap;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mImageView = findViewById(R.id.imageView);
        Button butt = findViewById(R.id.button);
        butt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dispatchTakePictureIntent();

            }

        });
    }

    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }

    }

    public void Save(View view) {
        EditText et = findViewById(R.id.Name);
        BitmapDrawable bd = new BitmapDrawable(getResources(), imageBitmap);
        Bitmap bp = bd.getBitmap();
        String name = et.getText().toString();
        People p = new People(name, bp);


        ImageAdapter.addPeople(p);
        finish();


    }

}







