package com.xloop.resourceloop.createJob.Service.DropDownService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.Department;
import com.xloop.resourceloop.createJob.Repository.DepartmentRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;
import com.xloop.resourceloop.createJob.ServiceInterface.InterfaceForDropDowns;

import jakarta.transaction.Transactional;

@Service
// @Transactional
public class DepartmentService extends GenericDropDown<Department, DepartmentRepository>   {
    
    // private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        // this.departmentRepository = departmentRepository;
        super(departmentRepository);
    }

     
    // public Department saveDepartment(Department department){

    //     department.getJobs().forEach(job->job.setDepartment(department));
    //     return departmentRepository.save(department);
    
    // }    

    // public Department updateDepartment(Department department){
        
    //     department.getJobs().forEach(job->job.setDepartment(department));
    //     return departmentRepository.save(department);

    // }    
    
    // public List<Department> getAllDepartments(){
    //     return departmentRepository.findAll();
    // }




}
