package com.demo.Collections;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {

    public static void main(String[] args) {
//        rawTypes();
//        genericType();


        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for(int i=1; i<=3; i++) {
            System.out.print("Enter the name: ");
            String name = sc.next();
            list.add(name);
        }

        System.out.println(list);
    }

    private static void rawTypes() {
        ArrayList colorList = new ArrayList();

        colorList.add("Red");
        colorList.add("yellow");
        colorList.add(null);
        colorList.add("null");

        ArithmeticException arithmeticException = new ArithmeticException();

        //colorList.add(arithmeticException);

        System.out.println(colorList);

    }

    private static void genericType() {
        ArrayList<String> colorList  = new ArrayList<>();

        colorList.add("Blue");
        colorList.add("red");
        colorList.add(null);
        colorList.add("null");

        ArrayList<Number> integerList = new ArrayList<>();

        integerList.add(10);
        integerList.add(12.2);
        integerList.add(33);
    }


}
