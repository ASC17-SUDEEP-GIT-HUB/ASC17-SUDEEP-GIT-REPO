package com.demo.lab4.Interface;

public class Main {
    public static void main(String args[]) {
        Rectangle rectangle = new Rectangle();

        rectangle.perimeterOfShape();
        rectangle.areaOfShape();

        Circle circle = new Circle();

        circle.perimeterOfShape();
        circle.areaOfShape();

        Semicircle semicircle = new Semicircle();

        semicircle.areaOfShape();
        semicircle.perimeterOfShape();

        Triangle triangle =  new Triangle();

        triangle.areaOfShape();
        triangle.perimeterOfShape();


    }
}
