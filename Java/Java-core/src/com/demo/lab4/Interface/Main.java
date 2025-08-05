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
        semicircle.borderColor();
        semicircle.shapeColor();

        Triangle triangle =  new Triangle();

        triangle.areaOfShape();
        triangle.perimeterOfShape();

        Shape shape;
        shape = new Triangle();

        shape.areaOfShape();
        shape.perimeterOfShape();

        
    }
}
