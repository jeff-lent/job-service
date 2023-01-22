package com.xloop.resourceloop.createJob.Service;
import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.Job;
import com.xloop.resourceloop.createJob.Repository.JobRepository;

@Service
public class JobService {
    
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job save(Job job) {
        job.getResponsibilitiess().forEach(respons -> respons.setJob(job));
        job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        job.getEducations().forEach(respons -> respons.setJob(job));
        job.getDesignations().forEach(respons -> respons.setJob(job));
        return jobRepository.save(job);
    }



}
