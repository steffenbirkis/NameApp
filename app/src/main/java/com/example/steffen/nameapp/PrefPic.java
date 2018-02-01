package com.example.steffen.nameapp;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by kevin on 29-Jan-18.
 */

public class PrefPic extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;

    private ImageView mImageView;
    private String mCurrentPhotoPath;
    private Bitmap imageBitmap;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtopref);
        mImageView = findViewById(R.id.imgview);
        directory();
        viewImg("ImageDir");
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

    public void prefSave(View view) {
        BitmapDrawable bd = new BitmapDrawable(getResources(), imageBitmap);
        Bitmap bp = bd.getBitmap();
        saveToInternalStorage(bp);
        finish();

    }

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    private void viewImg(String path){
        Bitmap b = null;
            try {
                File f=new File(path, "profile.jpg");
                b = BitmapFactory.decodeStream(new FileInputStream(f));
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }

            if(b != null){
                mImageView.setImageBitmap(b);
            }
    }

    private void directory(){
        String fname = "imageDir";
        File folder = getFilesDir();
        File f= new File(folder, fname);
        if(!f.exists()){
            f.mkdir();
        }
    }
}



