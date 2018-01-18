package com.example.steffen.nameapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
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
    private Bitmap mImageBitmap;
    private String mCurrentPhotoPath;
    private ImageView mImageView;




        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add);
            this.mImageView = (ImageView)this.findViewById(R.id.imageView1);
            Button photoButton = (Button) this.findViewById(R.id.button1);
            photoButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
                }
            });
        }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mImageView.setImageBitmap(photo);
        }
    }
}






