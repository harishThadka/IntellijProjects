package com.example.springconcepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mvc")
public class EmployeeMVC {

    @Autowired
    private  Employee employee;

    @GetMapping("/employees")
    @ResponseBody // By default dispatcher servlet search for view if don't specify
    public  Employee getEmployee(){
        return employee;
    }


}
