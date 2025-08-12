package com.demo.Service;

import com.demo.Entity.Employee;
import com.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> getAllEmployee() {
        System.out.println("Getting All Employee");
        return employeeRepository.findAll();
    }
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }
}