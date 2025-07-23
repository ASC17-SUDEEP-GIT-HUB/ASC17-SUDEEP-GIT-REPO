package com.demo.lab4;

import com.demo.lab4.Movie;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Movie m = new Movie("GOT", "producer");
        //m.setMovieCount(1);
        System.out.println(m.generateMovieId());
        System.out.println(m.showDetails());
        Movie m2 = new Movie("BB", "prod");
        System.out.println(m2.generateMovieId());
        System.out.println(m2.showDetails());

        SpecialMovie sm = new SpecialMovie("ST", "someone", "maximum", "greatvisuals");
        InternationalMovie im = new InternationalMovie("POH", "none", "london", "english");
        System.out.println(sm.generateMovieId());

        im.generateMovieId();

        Movie.getCount();
        SpecialMovie.getCount();
        InternationalMovie.getCount();

//        ArrayClass arrayClass = new ArrayClass(m, sm, im);
        ArrayClass arrayClass = new ArrayClass();

        arrayClass.storeMovie(m, sm, im);

        arrayClass.getMovie(); 
    }
}
