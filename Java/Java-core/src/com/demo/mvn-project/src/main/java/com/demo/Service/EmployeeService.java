package com.demo.Service;

import com.demo.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);
    
    public List<Employee> getAllEmployee();

    public void deleteEmployee(Long id);

    public void deleteAllEmployee();
}
