package com.demo.Polymorphism;

public class DynamicPoly {

    public static void main(String[] args) {

    }
}


class Movie1 {
    void play() {
        System.out.println("Playing Movie");
    }

    void play(String subtitle) {
        System.out.println("Playing movie with : " + subtitle);
    }
}

class FourkMovie extends Movie1 {
    void play() {
        System.out.println("playing 4k Movie");
    }
    void play(String subtitle) {
        System.out.println("Playing 4k movie in : " + subtitle);
    }
}

class WebSeries extends Movie1 {
    void play() {
        System.out.println("Playing web series");
    }
    void play(String subtitle) {
        System.out.println("Playing we series with : " + subtitle);
    }
}
