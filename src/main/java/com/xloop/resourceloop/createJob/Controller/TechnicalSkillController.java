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

import com.xloop.resourceloop.createJob.Model.TechnicalSkill;
import com.xloop.resourceloop.createJob.Service.SoftSkillService;
import com.xloop.resourceloop.createJob.Service.TechnicalSkillService;

@RestController
@RequestMapping("/technicalskill")
public class TechnicalSkillController {
    
    private final TechnicalSkillService technicalSkillService;

    public TechnicalSkillController(TechnicalSkillService technicalSkillService) {
        this.technicalSkillService = technicalSkillService;
    }

    @PostMapping("/add")
    public ResponseEntity<TechnicalSkill> addTechnicalSkill(@RequestBody TechnicalSkill technicalSkill){
       // return ResponseEntity.ok().build(TechnicalSkillService.addTechnicalSkill(technicalSkill));
       return ResponseEntity.ok().body(technicalSkillService.addTechnicalSkill(technicalSkill));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteJob(@PathVariable Long id){
        try {
            technicalSkillService.deleteTechnicalSkill(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reactive/{id}")
    public ResponseEntity<String>  reactiveTechnicalSkill(@PathVariable Long id){
        try {
            technicalSkillService.reactiveTechnicalSkill(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



    @GetMapping("/all")
    public ResponseEntity<List<TechnicalSkill>> viewAllTechnicalSkills(){
        return ResponseEntity.ok().body(technicalSkillService.viewAllTechnicalSkills());
    }




}
