package com.example.steffen.nameapp.Logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.steffen.nameapp.R;

/**
 * Created by Steffen on 11.01.2018.
 */

public class ImageAdapter extends BaseAdapter {
    private static Context mContext;


    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return plist.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 10, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }
        People[] ia = getPeople();
        if (ia.length == 0) {
            imageView.setImageResource(R.drawable.sample_1);
        }
        Bitmap bm = ia[position].getUri();
        imageView.setImageBitmap(bm);
        return imageView;

    }

    // references to our images
    public static People plist[] = {};

    public People[] getPeople() {
        return plist;
    }

    public static void addPeople(People s) {
        People list[] = new People[plist.length + 1];
        for (int i = 0; i < plist.length; i++) {
            list[i] = plist[i];
        }
        list[list.length - 1] = s;
        plist = list;
    }
}