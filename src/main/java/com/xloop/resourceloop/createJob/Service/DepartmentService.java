package com.xloop.resourceloop.createJob.Service;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.Department;
import com.xloop.resourceloop.createJob.Repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {
    
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
            this.departmentRepository = departmentRepository;
        }

     
    public Department savDepartment(Department department){
        department.getJobs().forEach(job->job.setDepartment(department));
        return departmentRepository.save(department);
    }    
        


}
