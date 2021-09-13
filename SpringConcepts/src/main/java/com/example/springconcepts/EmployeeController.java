package com.example.springconcepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private Employee employee;

    @Autowired
    private  Employee emp2;

    @PostMapping("/employees")
    public  Employee setEmployee(@RequestBody Employee emp){
        employee.setId(emp.getId());
        employee.setName(emp.getName());

        return employee;
    }

    @GetMapping("/employees")
    public  Employee getEmployee(){
        return emp2;
    }

}
