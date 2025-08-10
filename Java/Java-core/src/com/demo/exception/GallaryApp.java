package com.demo.exception;

public class GallaryApp {
    public static void main(String args[]) {
        System.out.println("Welcome");
        Photograph hdPhoto;
        //create the instance
        hdPhoto = new Photograph();

        //access the obj
        //set the name
        //accessing the property
//        hdPhoto.name = "nandhiHills";
//        hdPhoto.frameWidth = 1;
//        hdPhoto.colorPhoto = "Orange";
//        hdPhoto.hang();
//        boolean isIlluminated = hdPhoto.illiminate();
//
//        System.out.println(hdPhoto.name);
//        System.out.println(hdPhoto.frameWidth);


        //implemantion of rootedTree

        hdPhoto.name = "Rooted Tree";
        hdPhoto.frameWidth = 1;
        hdPhoto.colorPhoto = "Black";
        hdPhoto.frameMaterial = "wood";

        System.out.println("The frame Name is " + hdPhoto.name);
        System.out.println("The frame width is " + hdPhoto.frameWidth);
        System.out.println("The frame color is " + hdPhoto.colorPhoto);
        System.out.println("The frame material is " + hdPhoto.frameMaterial);

        hdPhoto.hang();
        hdPhoto.changeOriantation("Landscape");
        boolean isilluminated = hdPhoto.illiminate();
        if(isilluminated) {
            System.out.println("Swiched on!!!");
        }

        //System.out.println(isilluminated);
        hdPhoto.autograph();
    }
}



