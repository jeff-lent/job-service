package com.xloop.resourceloop.createJob.Service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.Job;
import com.xloop.resourceloop.createJob.Model.JobApply;
import com.xloop.resourceloop.createJob.Repository.JobApplyRepository;
import com.xloop.resourceloop.createJob.Repository.JobRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.InterfaceForDropDowns;

@Service
public class JobApplyService {
    
    public final JobApplyRepository jobApplyRepository;
    private final JobRepository jobRepository;

    public JobApplyService(JobApplyRepository jobApplyRepository, JobRepository jobRepository){
        this.jobApplyRepository=jobApplyRepository;
        this.jobRepository = jobRepository;
    }

    public String ApplyingJob(Long jobId, Long candidateId){

        Job jobToBeApplied = jobRepository.findById(jobId).get();
        // JobApply checkingAlreadyApply = jobApplyRepository.findByJobAndCandidateId(jobToBeApplied, candidateId);

        if( jobApplyRepository.findByJobAndCandidateId(jobToBeApplied, candidateId).isPresent()){
            return "Already Applied";
        }else{
            JobApply jobApplyObject  = new JobApply();
            jobApplyObject.setApplyDate(new Date());
            jobApplyObject.setCandidateId(candidateId);
            jobApplyObject.setJob(jobToBeApplied);
            jobApplyRepository.save(jobApplyObject);
            return "Applied Successfully";
        }
    }

    public List<JobApply> getAllAppliedJob() {
        return jobApplyRepository.findAll();  
    }
}
