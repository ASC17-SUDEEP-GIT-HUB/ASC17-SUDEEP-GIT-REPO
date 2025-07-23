package com.demo.Polymorphism;

public class StaticPoly {
    public static void main(String[] args) {
        Movie movie = new Movie();

        movie.play();
        movie.play("English");
    }
}

class Movie {
    void play() {
        System.out.println("Playing movie");
    }

    void play(String subtitle) {
        System.out.println("Playing with subtitle : " + subtitle);
    }
}
