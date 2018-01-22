package com.example.steffen.nameapp;

import android.graphics.drawable.BitmapDrawable;

/**
 * Created by Steffen on 18.01.2018.
 */

public class People {
   private String name;
   private BitmapDrawable uri;


   public People(String n, BitmapDrawable u){
       this.name=n;
       this.uri=u;
   }

   public String getName(){
       return name;
   }
   public BitmapDrawable getUri(){
       return uri;
   }
   public void setName(String names){
       this.name=names;

   }
   public void setUri(BitmapDrawable uris){
       this.uri=uris;
   }



}

