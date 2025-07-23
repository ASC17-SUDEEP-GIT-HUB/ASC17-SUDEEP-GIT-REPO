package com.demo.lab3;

public class InternationalMovie extends Movie{

    String country;
    String language;


    public InternationalMovie(String movieName, String producedBy, String country, String language) {

        super(movieName, producedBy);

        this.country = country;
        this.language = language;


    }
}
