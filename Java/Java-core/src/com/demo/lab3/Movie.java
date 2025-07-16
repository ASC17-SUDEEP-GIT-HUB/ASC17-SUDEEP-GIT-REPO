package com.demo.lab3;

public class Movie {

    String movieName;
    String producedBy;
    String directedBy;
    int duration;
    String year;
    String catagory;
    static int movieCount;

    public Movie(String movieName, String producedBy, String directedBy, int duration, String year, String catagory) {
        this.movieName = movieName;
        this.producedBy = producedBy;
        this.directedBy = directedBy;
        this.duration = duration;
        this.year = year;
        this.catagory = catagory;
    }

    public void setMovieCount(int movieCount) {
        this.movieCount = movieCount;
    }

    public int getmovieCount() {
        return movieCount;
    }


}
