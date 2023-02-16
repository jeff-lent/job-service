package com.xloop.resourceloop.createJob.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.DropDownModel.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentName(String departmentName);
}
