package com.demo.lab3;

public class Movie {

    String movieName;
    String producedBy;
    String directedBy;
    int duration;
    String year;
    String catagory;
    static int movieCount = 0;
    private String movieId;

    //static int count = 0;

    public Movie(String movieName, String producedBy) {
        this.movieName = movieName;
        this.producedBy = producedBy;
//        this.directedBy = directedBy;
//        this.duration = duration;
//        this.year = year;
//        this.catagory = catagory;

        movieCount++;
    }

    public static int getCount() {
        return movieCount;
    }

//    public void setMovieCount(int movieCount) {
//        this.movieCount = movieCount;
//    }

    public int getmovieCount() {
        return movieCount;
    }

    public String generateMovieId() {
        movieId = movieName + "_" + movieCount;

        return movieId;
    }

    public String showDetails() {
        return "The movie name is " + movieName + " and the movie id is " + movieId;
    }
}
