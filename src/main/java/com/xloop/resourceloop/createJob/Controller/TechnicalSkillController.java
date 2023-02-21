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

import com.xloop.resourceloop.createJob.Model.DropDownModel.TechnicalSkill;
import com.xloop.resourceloop.createJob.Repository.TechnicalSkillRepository;
// import com.xloop.resourceloop.createJob.Service.SoftSkillService;
import com.xloop.resourceloop.createJob.Service.DropDownService.TechnicalSkillService;

@RestController
@RequestMapping("/technicalSkill")
@CrossOrigin(origins = "${app.cors.origin:'http://localhost:3000'}")
public class TechnicalSkillController {

    @Autowired
    private TechnicalSkillService technicalSkillService;

    // @Autowired
    // private TechnicalSkillRepository technicalSkillRepository;

    // public TechnicalSkillController(TechnicalSkillService technicalSkillService )
    // {
    // this.technicalSkillService = technicalSkillService;
    // }

    @PostMapping("/add")
    public ResponseEntity<TechnicalSkill> addTechnicalSkill(@RequestBody TechnicalSkill technicalSkill) {

        try {
            return ResponseEntity.ok().body(technicalSkillService.add(technicalSkill));
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        try {
            technicalSkillService.deactivate(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reactive/{id}")
    public ResponseEntity<String> reactiveTechnicalSkill(@PathVariable Long id) {
        try {
            technicalSkillService.reactive(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TechnicalSkill> updateSoftSkill(@PathVariable Long id,
            @RequestBody TechnicalSkill technicalSkill) {
        try {
            technicalSkill.setId(id);
            return ResponseEntity.ok().body(technicalSkillService.update(technicalSkill));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<TechnicalSkill>> viewAllTechnicalSkills() {
        return ResponseEntity.ok().body(technicalSkillService.viewAll());
    }

}
