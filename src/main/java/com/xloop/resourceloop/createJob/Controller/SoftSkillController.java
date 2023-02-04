package com.xloop.resourceloop.createJob.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.createJob.Model.SoftSkill;
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

}
