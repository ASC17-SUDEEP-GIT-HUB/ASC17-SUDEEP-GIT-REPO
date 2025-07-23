package com.demo.lab4;

import com.demo.lab4.Movie;

public class SpecialMovie extends Movie{

    public String soundEffectsTechnology;
    public String visualEffectsTechnology;

     public SpecialMovie(String movieName, String producedBy, String soundEffectsTechnology, String visualEffectsTechnology) {

         super(movieName, producedBy);

         this.soundEffectsTechnology = soundEffectsTechnology;
         this.visualEffectsTechnology = visualEffectsTechnology;
     }

//     @Override
//     public String generateMovieId() {
//         movieId = movieName + "_" + movieCount;
//         return movieId;
//     }

    @Override
    public String showDetails() {
        return super.showDetails() + ", Sound Effect are: " + soundEffectsTechnology + ", Visual Effect are : " + visualEffectsTechnology;
    }
}