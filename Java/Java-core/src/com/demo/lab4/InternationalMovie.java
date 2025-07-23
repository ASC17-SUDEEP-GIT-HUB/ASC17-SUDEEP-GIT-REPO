package com.demo.lab4;

import com.demo.lab4.Movie;

import java.util.ArrayList;

public class InternationalMovie extends Movie {

    String country;
    String language;

    public InternationalMovie(String movieName, String producedBy, String country, String language) {

        super(movieName, producedBy);

        this.country = country;
        this.language = language;
    }


    @Override
    public String showDetails() {
        return super.showDetails() + ", done in Country " + country + " in " + language + ", language..";
    }
}
