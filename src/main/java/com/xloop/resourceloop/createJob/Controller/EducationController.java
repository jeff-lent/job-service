package com.xloop.resourceloop.createJob.Controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.createJob.Model.Education;
import com.xloop.resourceloop.createJob.Service.EducationService;

@RestController
@RequestMapping("/education")
public class EducationController {
    
    private final EducationService educationService;

    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Education> addEducation(@RequestBody Education education){

        try{
            return ResponseEntity.ok().body(educationService.addEducation(education));
        } catch(DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteJob(@PathVariable Long id){
        try {
            educationService.deleteEducation(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reactive/{id}")
    public ResponseEntity<String>  reactiveSoftSkill(@PathVariable Long id){
        try {
            educationService.reactiveEducation(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Education>> viewAllSoftSkills(){
        return ResponseEntity.ok().body(educationService.viewAllEducations());
    }

    
}
