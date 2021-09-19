package com.practice.departmentservice.controller;

import com.practice.departmentservice.entity.Department;
import com.practice.departmentservice.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/")
    public Department saveDept(@RequestBody Department department){
        log.info("Inside save Dept Method of Department Controller");
        return  deptService.saveDept(department);
    }

    @GetMapping("/{id}")
    public Department findDeptById(@PathVariable("id") Long deptId){
        log.info("Inside find dept by id from department controller");
        return deptService.findDeptById(deptId);
    }

}
