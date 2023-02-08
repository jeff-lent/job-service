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

import com.xloop.resourceloop.createJob.Model.BenefitsPerks;
import com.xloop.resourceloop.createJob.Service.BenefitsPerksService;

@RestController
@RequestMapping("/benefits")
public class BenefitsPerksController {
    private final BenefitsPerksService benefitsPerksService;
    
    public BenefitsPerksController(BenefitsPerksService benefitsPerksService){
        this.benefitsPerksService=benefitsPerksService;

    }

    @PostMapping("/add")
    public ResponseEntity<BenefitsPerks> addTechnicalSkill(@RequestBody BenefitsPerks benefitsPerks){
       // return ResponseEntity.ok().build(TechnicalSkillService.addTechnicalSkill(technicalSkill));
       return ResponseEntity.ok().body(benefitsPerksService.addBenefitsPerks(benefitsPerks));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteJob(@PathVariable Long id){
        try {
            benefitsPerksService.deleteBenefitsPerks(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reactive/{id}")
    public ResponseEntity<String>  reactiveBenefitsPerks(@PathVariable Long id){
        try {
            benefitsPerksService.reactiveBenefitsPerks(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }






    @GetMapping("/all")
    public ResponseEntity<List<BenefitsPerks>> viewAllTechnicalSkills(){
        return ResponseEntity.ok().body(benefitsPerksService.viewAllBenefitsPerks());
    }




}
