package com.xloop.resourceloop.createJob.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.createJob.Model.Job;
import com.xloop.resourceloop.createJob.Service.JobService;

@RestController
@RequestMapping("/job")
@CrossOrigin(origins = "${app.cors.origin}")
public class JobController {
    

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/post")
    public ResponseEntity<Job> postingJob(@RequestBody Job job){
        try {
            System.out.println(job.toString());
            return ResponseEntity.status(201).body(jobService.save(job));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    } 
    
    
}
