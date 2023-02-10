package com.xloop.resourceloop.createJob.Controller;
import java.util.List;

import org.aspectj.weaver.World;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.createJob.Model.Job;
import com.xloop.resourceloop.createJob.Service.JobService;

@RestController
@RequestMapping("/job")
@CrossOrigin(origins = "${app.cors.origin:'http://localhost:3000'}")
public class JobController {
    

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/post")
    public ResponseEntity<Job> postingJob(@RequestBody Job job){
        try {
            return ResponseEntity.status(201).body(jobService.save(job));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    } 

    @PostMapping("/update/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job ){
        try {
            job.setId(id);
            return ResponseEntity.status(200).body(jobService.update(job));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteJob(@PathVariable Long id){
        try {
            jobService.delete(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<Job>> viewAllJob(){
        return ResponseEntity.ok().body(jobService.viewAllJob());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Job> getAJob(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(jobService.getAJob(id).get());

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }   


    @GetMapping("/deactivated")
    public ResponseEntity<List<Job>> viewDeactivatedJobs(){
        return ResponseEntity.ok().body(jobService.viewDeactivatedJobs());
    }
}
