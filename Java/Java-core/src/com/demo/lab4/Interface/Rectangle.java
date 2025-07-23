package com.demo.lab4.Interface;

class Rectangle implements Shape {

    Rectangle() {

    }
    @Override
    public void perimeterOfShape() {
        double p = 2 * (length * width);

      //  System.out.println("Perimeter of the rectangle: ");
        System.out.println("The perimeter of rectangle is: " + p);
    }
    @Override
    public void areaOfShape() {
        double area = length * width;

   //     System.out.println("Area of the rectangle: ");
        System.out.println("The area of rectangle is: " + area);
    }
}
