package com.demo.lab4.Interface;

import com.demo.lab4.Interface.Circle;
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

   // super(periCircle, areaCircle);

   // Circle circle = new Circle();

    @Override
    public void perimeterOfShape() {
        super.perimeterOfShape();
        System.out.println("Perimeter of semicircle : " + getPerimeter()  / 2);
    }

    @Override
    public void areaOfShape() {
        super.areaOfShape();
         System.out.println("Area of semicircle: " + getArea() / 2);
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