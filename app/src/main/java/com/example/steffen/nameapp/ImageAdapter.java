package com.example.steffen.nameapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Steffen on 11.01.2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

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

        imageView.setImageResource(ia[position].getUri());

        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6,
    };

    public Integer[] getmThumbIds() {
        return mThumbIds;
    }

    public People plist[] = {
            new People("Steffen", R.drawable.sample_2),
            new People("Sondre", R.drawable.sample_3),
            new People("Kevin", R.drawable.sample_4),
            new People("Tommy", R.drawable.sample_5),
    };

    public People[] getPeople() {

        return plist;
    }

    public void addPeople(People s) {
        People list[] = new People[plist.length + 1];
        for (int i = 0; i < plist.length; i++) {
            list[i] = plist[i];
        }
        list[list.length - 1] = s;

        plist = list;
    }
}