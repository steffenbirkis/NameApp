package com.example.steffen.nameapp;

/**
 * Created by Steffen on 18.01.2018.
 */

public class People {
   private String name;
   private Integer uri;

   public People(String n, Integer u){
       this.name=n;
       this.uri=u;
   }

   public String getName(){
       return name;
   }
   public Integer getUri(){
       return uri;
   }
   public void setName(String names){
       this.name=names;

   }
   public void setUri(Integer uris){
       this.uri=uris;
   }


}

