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

import com.xloop.resourceloop.createJob.Model.BenefitsPerks;
import com.xloop.resourceloop.createJob.Service.DropDownService.BenefitsPerksService;

@RestController
@RequestMapping("/benefits")
@CrossOrigin(origins = "${app.cors.origin:'http://localhost:3000'}")
public class BenefitsPerksController {

    @Autowired
    private BenefitsPerksService benefitsPerksService;

    @PostMapping("/add")
    public ResponseEntity<BenefitsPerks> addTechnicalSkill(@RequestBody BenefitsPerks benefitsPerks) {
            try {
            return ResponseEntity.ok().body(benefitsPerksService.add(benefitsPerks));
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        try {
            benefitsPerksService.deactivate(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reactive/{id}")
    public ResponseEntity<String> reactiveBenefitsPerks(@PathVariable Long id) {
        try {
            benefitsPerksService.reactive(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<BenefitsPerks> updateBenefitPerk(@PathVariable Long id,
            @RequestBody BenefitsPerks benefitsPerks) {
        try {
            benefitsPerks.setId(id);
            return ResponseEntity.ok().body(benefitsPerksService.update(benefitsPerks));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<BenefitsPerks>> viewAllTechnicalSkills() {
        return ResponseEntity.ok().body(benefitsPerksService.viewAll());
    }

}
