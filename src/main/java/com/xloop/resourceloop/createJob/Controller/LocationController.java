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

import com.xloop.resourceloop.createJob.Model.DropDownModel.Location;
import com.xloop.resourceloop.createJob.Service.DropDownService.LocationService;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "${app.cors.origin:'http://localhost:3000'}")
public class LocationController {

    @Autowired
    LocationService locationService;

    
    @PostMapping("/add")
    public ResponseEntity<Location> addLocation(@RequestBody Location location){
        
        try {
            return ResponseEntity.ok().body(locationService.add(location));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        try {
        locationService.deactivate(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reactive/{id}")
    public ResponseEntity<String> reactiveDepartment(@PathVariable Long id) {
        try {
            locationService.reactive(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Location> updateSoftSkill(@PathVariable Long id,
            @RequestBody Location location) {
        try {
            location.setId(id);
            return ResponseEntity.ok().body(locationService.update(location));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<Location>> getAllDeapartments(){
        return ResponseEntity.ok().body(locationService.viewAll());
    } 
    

    
}
