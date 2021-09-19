package com.example.employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee emp;

        if(optionalEmployee.isPresent()){
           emp = optionalEmployee.get();
        }else{
            emp = null;
        }

        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){

//        return new ResponseEntity<Employee>(employeeRepository.save(employee),HttpStatus.CREATED);
        Employee temp = employeeRepository.save(employee);
        return  ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(temp);
    }

    @PutMapping("/employees/{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        Employee emp;
        if(optionalEmployee.isPresent()){
            emp = optionalEmployee.get();
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setEmail(employee.getEmail());
            emp.setJobTitle(employee.getJobTitle());

            employeeRepository.save(emp);
        }else{
            emp = null;
        }

        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id){
        employeeRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }


}
