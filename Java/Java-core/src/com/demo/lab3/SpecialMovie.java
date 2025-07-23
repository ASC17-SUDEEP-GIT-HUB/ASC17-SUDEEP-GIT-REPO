package com.demo.lab3;

import com.demo.lab3.Movie;

public class SpecialMovie extends Movie{

    String soundEffectsTechnology;
    String visualEffectsTechnology;

     public SpecialMovie(String movieName, String producedBy, String soundEffectsTechnology, String visualEffectsTechnology) {

         super(movieName, producedBy);

         this.soundEffectsTechnology = soundEffectsTechnology;
         this.visualEffectsTechnology = visualEffectsTechnology;


     }


}