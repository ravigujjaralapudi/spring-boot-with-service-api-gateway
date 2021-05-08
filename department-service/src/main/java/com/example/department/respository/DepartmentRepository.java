package com.example.department.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
