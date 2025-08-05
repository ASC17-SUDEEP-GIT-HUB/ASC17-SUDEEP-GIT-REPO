package com.demo.lab4.EmployeeManagementApp;

public class Main {
    public static void main(String[] args) {
        UserUI ui = new UserUI();

        Employee employee = ui.acceptEmpDetails();

       // StorageImpl st = new StorageImpl();
       Storage st = StorageFactory.getStorage();
         st.addEmployee(employee);

        System.out.println(ui.displayEmpDetailsById());
    }
}