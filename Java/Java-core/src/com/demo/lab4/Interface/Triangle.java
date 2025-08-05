package com.demo.lab4.Interface;

public class Triangle implements Shape {

//    Triangle() {
//
//    }

    @Override
    public void perimeterOfShape() {
        double peri = baseC + sideA + sideB;
        System.out.println("The perimeter of Triangle is : " + peri);
    }

    @Override
    public void areaOfShape() {
        double area = (double) 1 /2 * baseC * height;

        System.out.println("The area of Triangle is : " + area);
    }


}
