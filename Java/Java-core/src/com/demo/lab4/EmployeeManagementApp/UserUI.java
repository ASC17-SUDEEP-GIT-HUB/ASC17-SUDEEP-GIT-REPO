package com.demo.lab4.EmployeeManagementApp;

import java.util.Scanner;

public class UserUI {

    Scanner sc = new Scanner(System.in);

//      UserUI(int empId, String firstName, String lastName, String city, double salary) {
//        super(empId, firstName, lastName, city, salary);
//    }

    public Employee acceptEmpDetails() {


        System.out.print("Enter the id: ");
        int empId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the F name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter the L name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter the city: ");
        String city = sc.nextLine();

        System.out.print("Enter the salary: ");
        double salary = sc.nextDouble();

        return new Employee(empId, firstName, lastName, city, salary);
    }

    //StorageFactory st = new StorageFactory();

    public String displayEmpDetailsById() {
        System.out.print("Enter the ID of Employee: ");
        int id = sc.nextInt();
        sc.nextLine();
        Employee em = StorageFactory.getStorage().getEmployee(id);

        if(em == null) {
            return "Employee with ID " + id + " not found";
        }

         return "The Employee id : " + em.getId() + " and the name : " + em.getfName() + " " + em.getlName() + " an the city is : " + em.getCity() + " and the salary is : " + em.getSalary();
    }
}