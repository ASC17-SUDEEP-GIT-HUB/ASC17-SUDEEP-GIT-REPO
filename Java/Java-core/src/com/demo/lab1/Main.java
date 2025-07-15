package com.demo.lab1;

import com.demo.lab1.Student;

public class Main {

    public static void main(String args[]) {
        Student s1 = new Student();
        s1.setName("sudi");
        s1.setId(101);
        s1.setCity("Bangalore");
        s1.setmarks1(100);
        s1.setmarks2(99);
        s1.setmarks3(98);
        s1.setFeePerMonth(399);
        s1.setIsEligibleForScholarShip(true);


        Student s2 = new Student();
        s2.setName("Hii");
        s2.setId(102);
        s2.setCity("Chennai");
        s2.setmarks1(59);
        s2.setmarks2(99);
        s2.setmarks3(98);
        s2.setFeePerMonth(400);
        s2.setIsEligibleForScholarShip(true);

        System.out.println(s1.getAnnualFee());
        System.out.println(s1.getTotalMarks());
        System.out.println(s1.getAverage());
        System.out.println(s1.getResult());

        System.out.println(s2.getAnnualFee());
        System.out.println(s2.getTotalMarks());
        System.out.println(s2.getAverage());
        System.out.println(s2.getResult());

    }
}