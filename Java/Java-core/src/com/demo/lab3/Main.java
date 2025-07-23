package com.demo.lab3;

public class Main {

    public static void main(String[] args) {
        Movie m = new Movie("GOT", "producer");
        //m.setMovieCount(1);
        System.out.println(m.generateMovieId());
        System.out.println(m.showDetails());
        Movie m2 = new Movie("BB", "prod");
        System.out.println(m2.generateMovieId());
        System.out.println(m2.showDetails());

        Movie.getCount();
    }
}
