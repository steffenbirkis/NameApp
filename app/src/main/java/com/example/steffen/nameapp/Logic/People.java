package com.example.steffen.nameapp.Logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by Steffen on 18.01.2018.
 */

public class People {
    private String name;
    private Bitmap uri;

    public People(String n, Bitmap u) {
        this.name = n;
        this.uri = u;
    }


    public String getName() {
        return name;
    }

    public Bitmap getUri() {
        return uri;
    }

    public void setName(String names) {
        this.name = names;
    }

    public Bitmap getBm(BitmapDrawable bd) {
        return bd.getBitmap();
    }

    public static Bitmap getFromResource(Context c, int i) {
        Bitmap bm = BitmapFactory.decodeResource(c.getResources(),
                i);
        return bm;
    }
}

