package com.example.steffen.nameapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by kevin on 29-Jan-18.
 */

public class PrefPic extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;
    private Bitmap imageBitmap;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtopref);
        mImageView = findViewById(R.id.imgview);
        viewImg();
        Button butt = findViewById(R.id.button2);
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

    public void prefSave(View view) {
        BitmapDrawable bd = new BitmapDrawable(getResources(), imageBitmap);
        Bitmap bp = bd.getBitmap();
        mImageView.setImageBitmap(bp);
        saveimg(bp);
        finish();
    }

    public void saveimg(Bitmap bitmap) {
        new ImageSaver(this).
                setFileName("myImage.png").
                setDirectoryName("images").
                save(bitmap);
    }

    public void viewImg() {
        Bitmap bitmap = new ImageSaver(this).
                setFileName("myImage.png").
                setDirectoryName("images").
                load();
        mImageView.setImageBitmap(bitmap);
    }
}



