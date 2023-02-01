package com.xloop.resourceloop.createJob.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        job.setPostDate(new Date());
        job.getResponsibilitiess().forEach(respons -> respons.setJob(job));
        job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        job.getEducations().forEach(respons -> respons.setJob(job));
        job.getSoftSkills().forEach(ss -> ss.setJob(job));
        job.getTechnicalSkills().forEach(ts -> ts.setJob(job));
        return jobRepository.save(job);
    }

    public Job update(Job job){
        job.setPostDate(new Date());
        job.getResponsibilitiess().forEach(respons -> respons.setJob(job));
        job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        job.getEducations().forEach(respons -> respons.setJob(job));
        job.getSoftSkills().forEach(ss -> ss.setJob(job));
        job.getTechnicalSkills().forEach(ts -> ts.setJob(job));
        return jobRepository.save(job);
    }

    
    public Job getJobById(Long id){
        return jobRepository.getById(id);
    }


    public void delete(Long id){
        
        //jobRepository.deleteById(id);
       //List<Job> allJobs = jobRepository.findAll();
       //changing the value of isActive column.
        Job pashaJob =  jobRepository.getById(id);
        pashaJob.setPasha(false);
       jobRepository.save(pashaJob);
        
    }

    public List<Job> viewAllJob(){
      List<Job> allJobs =  jobRepository.findAll();
     List<Job> activeJobs = allJobs.stream()
     .filter(p -> p.isPasha() == true)
     .collect(Collectors.toList());   
     return activeJobs; 
    }

    public List<Job> viewDeactivatedJobs() {
        List<Job> allJobs =  jobRepository.findAll();
        List<Job> deactivatedJobs = allJobs.stream().filter(a-> a.isPasha()==false).collect(Collectors.toList());
        return deactivatedJobs;
    }


    
    
}
