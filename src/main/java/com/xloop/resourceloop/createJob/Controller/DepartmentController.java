package com.xloop.resourceloop.createJob.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.createJob.Model.DropDownModel.Department;
import com.xloop.resourceloop.createJob.Repository.DepartmentRepository;
import com.xloop.resourceloop.createJob.Service.DropDownService.DepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "${app.cors.origin:'http://localhost:3000'}")

public class DepartmentController {
    
    @Autowired 
    DepartmentService departmentService;
    
    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        
        try {
            return ResponseEntity.ok().body(departmentService.add(department));
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        try {
            departmentService.deactivate(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



    
    @PostMapping("/reactive/{id}")
    public ResponseEntity<String> reactiveDepartment(@PathVariable Long id) {
        try {
            departmentService.reactive(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    
    @PostMapping("/update/{id}")
    public ResponseEntity<Department> updateSoftSkill(@PathVariable Long id,
            @RequestBody Department department) {
        try {
            department.setId(id);
            return ResponseEntity.ok().body(departmentService.update(department));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDeapartments(){
        return ResponseEntity.ok().body(departmentService.viewAll());
    } 

}
