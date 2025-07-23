package com.demo.lab4;

public class Movie {

    public String movieName;
    public String producedBy;
    public String directedBy;
    public int duration;
    public String year;
    public String catagory;
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

//    public int getmovieCount() {
//        return movieCount;
//    }

    public String generateMovieId() {
        movieId = movieName + "_" + movieCount;
        return movieId;
    }

    public String showDetails() {

        return "The movie name is " + movieName + " and the movie id is " + movieId;
    }
}
