package com.practice.departmentservice.repository;

import com.practice.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepsitory extends JpaRepository<Department,Long> {
}
