package com.demo.exception;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Photograph {
    String name;
    byte frameWidth;
    String colorPhoto;
    String frameMaterial;

    void hang() {
        System.out.println("Hang on the wall");
    }
    String changeOriantation(String oriantation) {
        System.out.println("Oriantation changed to : " + oriantation);
        return oriantation;
    }

    boolean illiminate() {
        System.out.println("switched on");
        return true;
    }
    void autograph() {
        System.out.println("Signed");
    }

    public static void main(String srgs[]) {
        System.out.println();
    }
}
