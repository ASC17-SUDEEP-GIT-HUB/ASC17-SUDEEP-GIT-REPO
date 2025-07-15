package com.demo.oops;

public class StaticEx {
    public static void main(String args[]) {
        Employee1.companyName = "Asc";
        String companyName = Employee1.companyName;
    }
}

class Employee1 {
    public static String companyName = "AZ";
    public static String CEO = "Busy!!";

    public static void displayCompanyDetails() {
        System.out.println("Ascendion");
        System.out.println("Adugodi");
    }
}
