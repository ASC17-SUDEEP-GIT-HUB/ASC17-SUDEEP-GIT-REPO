package com.demo.lab4.EmployeeManagementApp;

import java.util.ArrayList;

public class StorageImpl implements Storage{

    private ArrayList<Employee> arraylist = new ArrayList<>();

    @Override
    public void addEmployee(Employee e) {
        arraylist.add(e);
    }

    @Override
    public Employee getEmployee(int empId) {

         for(Employee e : arraylist) {
             if(e.getId() == empId) {
                // return "The Employee id : " + e.empId + " and the name : " + e.firstName + " " + e.lastName + " an the city is : " + e.city + " and the salary is : " + e.salary;
                return e;
             }
         }
         return null;
    }
}