package com.demo.oops;

public class StaticVsInstance {
    public static void main(String args[]) {
         Employee.companyName = "Ascendion";
         String companayName = Employee.companyName;

        System.out.println(companayName);

        Employee emp1 = new Employee();

        emp1.employeeName = "Peter";

        System.out.println(emp1.employeeName);

        Employee emp2 = new Employee();
        emp2.employeeName = "Sam";

        System.out.println(emp2.employeeName);
        //System.out.println(emp2.companayName);
        System.out.println(Employee.companyName);
    }
}

class Employee {
    public static String companyName = "Ascendion";

    public String employeeName;
}
