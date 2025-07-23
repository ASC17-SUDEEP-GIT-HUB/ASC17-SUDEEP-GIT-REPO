package com.demo.lab4.Interface;
//
//public class Semicircle implements Color {
//
//    public void perimeterOfShape() {
//
//        System.out.println("Perimeter of semicircle: " + pie * radius + 2 * radius);
//    }
//
//    public void areaOfShape() {
//        System.out.println("Area of semicircle: " + pie * (radius * radius) / 2);
//    }
//
//    public void borderColor() {
//        System.out.println("The color of border is : " + borderColor);
//    }
//
//    public void shapeColor() {
//        System.out.println("The color of shape is : " + color);
//    }
//
//}


public class Semicircle extends Circle implements Shape, Color {

    Semicircle() {

    }

   // Circle circle = new Circle();

    @Override
    public void perimeterOfShape() {

        System.out.println("Perimeter of semicircle : " + periCircle  / 2);
    }

    @Override
    public void areaOfShape() {
        System.out.println("Area of semicircle: " + areaCircle / 2);
    }

    @Override
    public void borderColor() {
        System.out.println("The color of border is : " + borderColor);
    }

    @Override
    public void shapeColor() {
        System.out.println("The color of shape is : " + color);
    }

}