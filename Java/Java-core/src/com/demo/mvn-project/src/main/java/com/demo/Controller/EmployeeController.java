package com.demo.Controller;

import com.demo.Entity.Employee;
import com.demo.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employe ID with " + id + " deleted!!";
    }
    //http://localhost:8080/api/emp/1

//    public List<Employee> getEmployeeByList() {
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(1, "name", "name@gmail.com"));
//        employees.add(new Employee(2, ))
//    }

    @GetMapping("/getHTML")
    public String getHTMLContent() {
        String html = "<html><head><title>Welcome</title></head></html>";

        return html;
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllEmployee() {
        employeeService.deleteAllEmployee();
        return "All employee Deleted";
    }
}
