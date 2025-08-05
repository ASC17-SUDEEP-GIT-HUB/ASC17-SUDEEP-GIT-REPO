package com.demo.lab4.Interface;

public class Circle implements Color {

    private double periCircle;
    private double areaCircle;

//    Circle() {
//
//    }

   // @Override
    public void perimeterOfShape() {
         periCircle = 2 * pie * radius;

       // System.out.println("Perimeter of the Circle: ");
        System.out.println("The perimeter of circle is: " + periCircle);

    }

    public double getPerimeter() {
        return periCircle;
    }

    //@Override
    public void areaOfShape() {
        areaCircle = pie * radius * radius;

     //   System.out.println("Perimeter of the Circle: ");
        System.out.println("The area of circle is: " + areaCircle);
    }

    public double getArea() {
        return areaCircle;
    }
   // @Override
    public void borderColor() {
        System.out.println("Border color: " + borderColor);
    }

   // @Override
    public void shapeColor() {
        System.out.println("Shape color: " + color);
    }
}
