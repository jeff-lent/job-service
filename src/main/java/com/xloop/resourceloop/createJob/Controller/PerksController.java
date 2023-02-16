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

import com.xloop.resourceloop.createJob.Model.DropDownModel.Benefits;
import com.xloop.resourceloop.createJob.Model.DropDownModel.Perks;
import com.xloop.resourceloop.createJob.Service.DropDownService.BenefitsService;
import com.xloop.resourceloop.createJob.Service.DropDownService.PerksService;

@RestController
@RequestMapping("/perks")
@CrossOrigin(origins = "${app.cors.origin:'http://localhost:3000'}")
public class PerksController {
    @Autowired
    private PerksService perksService;

    @PostMapping("/add")
    public ResponseEntity<Perks> addTechnicalSkill(@RequestBody Perks perks) {
            try {
            return ResponseEntity.ok().body(perksService.add(perks));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        try {
            perksService.deactivate(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reactive/{id}")
    public ResponseEntity<String> reactiveBenefitsPerks(@PathVariable Long id) {
        try {
            perksService.reactive(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Perks> updateBenefitPerk(@PathVariable Long id,
            @RequestBody Perks perks) {
        try {
            perks.setId(id);
            return ResponseEntity.ok().body(perksService.update(perks));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Perks>> viewAllTechnicalSkills() {
        return ResponseEntity.ok().body(perksService.viewAll());
    }
}
