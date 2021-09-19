package com.practice.departmentservice.service;

import com.practice.departmentservice.entity.Department;
import com.practice.departmentservice.repository.DeptRepsitory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeptService {

    @Autowired
    private DeptRepsitory deptRepsitory;

    public Department saveDept(Department department) {
        log.info("Inside save Dept Method of Department Service");
        System.out.println(department.toString());
        return deptRepsitory.save(department);
    }

    public Department findDeptById(Long deptId) {
        return deptRepsitory.findById(deptId).orElse(null);
    }
}
