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

import com.xloop.resourceloop.createJob.Model.DropDownModel.SoftSkill;
import com.xloop.resourceloop.createJob.Repository.JobRepository;
import com.xloop.resourceloop.createJob.Repository.SoftSkillRepository;
import com.xloop.resourceloop.createJob.Service.JobService;
import com.xloop.resourceloop.createJob.Service.DropDownService.SoftSkillService;

@RestController
@RequestMapping("/softSkill")
@CrossOrigin(origins = "${app.cors.origin:'http://localhost:3000'}")
public class SoftSkillController {
    
    
    @Autowired
    private SoftSkillService softSkillService;


    @PostMapping("/add")
    public ResponseEntity<SoftSkill> addSoftSkill(@RequestBody SoftSkill softSkill){
        try{
            return ResponseEntity.ok().body(softSkillService.add(softSkill));
        } catch(DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteJob(@PathVariable Long id){
        try {
            softSkillService.deactivate(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/reactive/{id}")
    public ResponseEntity<String>  reactiveSoftSkill(@PathVariable Long id){
        try {
            softSkillService.reactive(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<SoftSkill> updateSoftSkill( @PathVariable Long id, @RequestBody SoftSkill softSkill ){
        try {
            softSkill.setId(id);
            return ResponseEntity.ok().body(softSkillService.update(softSkill));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<SoftSkill>> viewAllSoftSkills(){
        return ResponseEntity.ok().body(softSkillService.viewAll());
    }
}
