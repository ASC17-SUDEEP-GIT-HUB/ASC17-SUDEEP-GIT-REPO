package com.demo.lab4;

import com.demo.lab4.Movie;

import java.util.ArrayList;

public class ArrayClass {

    ArrayList<Movie> movieList = new ArrayList<>();

//    public ArrayClass(Movie movie, SpecialMovie sm, InternationalMovie itlm) {
//
//    }
    public void storeMovie(Movie moviee, SpecialMovie sm, InternationalMovie im) {

//        Movie movi = new Movie(moviee.movieName, moviee.producedBy);
        movieList.add(moviee);

//        SpecialMovie sp = new SpecialMovie(sm.movieName, sm.producedBy, sm.soundEffectsTechnology, sm.visualEffectsTechnology);
        movieList.add(sm);

//        InternationalMovie intlMovie = new InternationalMovie(im.movieName, im.producedBy, im.country, im.language);
        movieList.add(im);

    }

    public void getMovie() {
        for(Movie movie : movieList) {
            System.out.println(movie.showDetails());
        }
    }
}
