package com.xloop.resourceloop.createJob.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.createJob.Model.SoftSkill;
import com.xloop.resourceloop.createJob.Repository.JobRepository;
import com.xloop.resourceloop.createJob.Repository.SoftSkillRepository;
import com.xloop.resourceloop.createJob.Service.JobService;
import com.xloop.resourceloop.createJob.Service.SoftSkillService;

@RestController
@RequestMapping("/softSkill")
public class SoftSkillController {
    
    
    private final SoftSkillService softSkillService;

    public SoftSkillController(SoftSkillService softSkillService) {
        this.softSkillService= softSkillService;
    }

    @PostMapping("/add")
    public ResponseEntity<SoftSkill> addSoftSkill(@RequestBody SoftSkill softSkill){
        return ResponseEntity.ok().body(softSkillService.addSoftSkill(softSkill));
    }

    // @DeleteMapping("/delete/{id}")
    // public ResponseEntity<String>  deleteJob(@PathVariable Long id){
    //     try {
    //         softSkillService.deleteSoftSkill(id);
    //         return ResponseEntity.ok().build();

    //     } catch (Exception e) {
    //         return ResponseEntity.badRequest().build();
    //     }
    // }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteJob(@PathVariable Long id){
        try {
            softSkillService.deleteSoftSkill(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/reactive/{id}")
    public ResponseEntity<String>  reactiveSoftSkill(@PathVariable Long id){
        try {
            softSkillService.reactiveSoftSkill(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // @PostMapping("/update/{id}")
    // public Void updateSoftSkill(@PathVariable Long id){
    //     try {
            // softSkill.setId(id);
    //         softSkillService.reactiveSoftSkill(id);
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         return ResponseEntity.badRequest().build();
    //     }
    // }

    // @PostMapping("update/{id}")
    // public void reactiveSoftSkill(@PathVariable Long id ){

    // }



    // @PostMapping("/update/{id}")
    // public ResponseEntity<SoftSkill> reactiveJob(@PathVariable Long id, @RequestBody SoftSkill softSkill ){
    //     try {
    //         softSkill.setId(id);
    //         return ResponseEntity.status(200).body(SoftSkillService.reactiveSoftSkill(id));
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         return ResponseEntity.badRequest().build();
    //     }
    // }

    



    @GetMapping("/all")
    public ResponseEntity<List<SoftSkill>> viewAllSoftSkills(){
        return ResponseEntity.ok().body(softSkillService.viewAllSoftSkills());
    }
}
