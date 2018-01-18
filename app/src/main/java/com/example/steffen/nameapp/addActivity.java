package com.example.steffen.nameapp;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Steffen on 11.01.2018.
 */

public class addActivity extends AppCompatActivity {

    /** Sjekke om det er kamera på enheten */
    /**
    private boolean checkCameraHardware(Context context) {


        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // Enheten har kamera
            return true;
        } else {
            // Enheten har ikke kamera
            return false;
        }
    }*/
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private ImageView mImageView;




        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add);
            mImageView=findViewById(R.id.imageView);
            Button butt=findViewById(R.id.button);
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
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }
    
    }







