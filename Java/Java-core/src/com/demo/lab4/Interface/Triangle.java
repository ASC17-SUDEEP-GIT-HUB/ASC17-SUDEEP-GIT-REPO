package com.demo.lab4.Interface;

public class Triangle implements Shape {

    Triangle() {

    }

    @Override
    public void perimeterOfShape() {
        System.out.println("The perimeter of Triangle is : " + (baseC + sideA + sideB));
    }

    @Override
    public void areaOfShape() {
        System.out.println("The area of Triangle is : " + (1/2) * baseC * height);
    }


}
