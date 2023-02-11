package com.xloop.resourceloop.createJob.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.View.Message;
import com.xloop.resourceloop.createJob.Integrating_Class.CandidatePersonalInfo;
import com.xloop.resourceloop.createJob.Integrating_Class.UserProfile;
import com.xloop.resourceloop.createJob.Model.JobApply;
import com.xloop.resourceloop.createJob.Service.JobApplyService;

@RestController
@RequestMapping("/apply")
@CrossOrigin(origins = "${app.cors.origin:'http://localhost:3000'}")
public class JobApplyController {
    
    private final JobApplyService jobApplyService;

    

    public JobApplyController(JobApplyService jobApplyService) {
        this.jobApplyService = jobApplyService;
    }


    @PostMapping("/job/{jobId}/candidate/{candidateId}")
    public ResponseEntity<Message> applyJob(@PathVariable Long jobId , @PathVariable Long candidateId ){
       try {
            Message msg = new Message(jobApplyService.ApplyingJob(jobId, candidateId));
            return ResponseEntity.accepted().body(msg);
       } catch (Exception e) {
            return ResponseEntity.badRequest().body( new Message(e.getMessage()) );
       }
    }

    @GetMapping("/list/{jobId}")
    public ResponseEntity<List<CandidatePersonalInfo>> getAppliedCandidateForJob(@PathVariable Long jobId){

      return jobApplyService.getAllAppliedCandidates(jobId);
      
      //checking list size
      // if(candidates.spliterator().estimateSize()>0){
      //   String candidateList = String.join(",",candidates);
      //   return new UserProfile().getAllAppliedCandidate(candidateList);
      // }else{
      //   return ResponseEntity.noContent().build();
      // }
      //Join List into String

    } 
    
}
