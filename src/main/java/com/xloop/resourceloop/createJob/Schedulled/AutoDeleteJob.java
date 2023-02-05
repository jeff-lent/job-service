package com.xloop.resourceloop.createJob.Schedulled;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.xloop.resourceloop.createJob.Service.JobService;

import lombok.Getter;
import lombok.Setter;

@Component
public class AutoDeleteJob {
    
    

    private final JobService jobsService;

    public AutoDeleteJob(JobService jobService ) {
        this.jobsService = jobService;
    }


    @Scheduled(cron = "0 * 1 * * *")
    public void autoDeleteExpireJob(){
        jobsService.autoDeleteJob();
    }
}
