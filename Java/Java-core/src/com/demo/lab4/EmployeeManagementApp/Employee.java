package com.demo.lab4.EmployeeManagementApp;

public class Employee {

    private int empId;
    private String lastName;
    private String city;
    private double salary;
    private String firstName;

    Employee(int empId, String firstName, String lastName, String city, double salary) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.salary = salary;
    }

    public int getId() {
        return empId;
    }

    public String getfName() {
    return firstName;
    }
    
    public String getlName() {
    return lastName;
    }
    
    public String getCity() {
    return city;
    }

    public double getSalary() {
        return salary;
    }
    
    // public String toString() {
    //     return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName" + lastName + ", city=" + city
    //             + ", salary=" + salary + "]";
    // }
}