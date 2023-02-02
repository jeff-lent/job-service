package com.xloop.resourceloop.createJob.Service;
import java.util.Date;
import java.util.List;

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

    
    public void delete(Long id){
        
        jobRepository.deleteById(id);
        return;
    }
    
    public Job getAJob(Long id){
        return jobRepository.getById(id);
        
    }

    public List<Job> viewAllJob(){
      return jobRepository.findAll();  
    }
    
}
