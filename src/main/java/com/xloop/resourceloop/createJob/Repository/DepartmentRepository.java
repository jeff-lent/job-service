package com.xloop.resourceloop.createJob.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    
}
