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

import com.xloop.resourceloop.createJob.Model.DropDownModel.JobType;
import com.xloop.resourceloop.createJob.Service.DropDownService.JobTypeService;

@RestController
@RequestMapping("/jobType")
@CrossOrigin(origins = "${app.cors.origin:'http://localhost:3000'}")
public class JobTypeController {
    
    @Autowired
    private JobTypeService jobTypeService;

    @PostMapping("/add")
    public ResponseEntity<JobType> addJobType(@RequestBody JobType jobType){

        try{
            return ResponseEntity.ok().body(jobTypeService.add(jobType));
        } catch(DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteJob(@PathVariable Long id){
        try {
            jobTypeService.deactivate(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reactive/{id}")
    public ResponseEntity<String>  reactiveSoftSkill(@PathVariable Long id){
        try {
            jobTypeService.reactive(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<JobType> updateSoftSkill(@PathVariable Long id,
            @RequestBody JobType jobType) {
        try {
            jobType.setId(id);
            return ResponseEntity.ok().body(jobTypeService.update(jobType));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobType>> viewAllSoftSkills(){
        return ResponseEntity.ok().body(jobTypeService.viewAll());
    }

    
}
