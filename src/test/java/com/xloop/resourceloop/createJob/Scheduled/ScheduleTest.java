package com.xloop.resourceloop.createJob.Scheduled;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xloop.resourceloop.createJob.Schedulled.AutoDeleteJob;
import com.xloop.resourceloop.createJob.Service.JobService;

@SpringBootTest
public class ScheduleTest {
    
    @Mock
    private JobService jobService;

    @Autowired
    private AutoDeleteJob autoDeleteJob;
    

    @Test
    public void testAutoDeleteMethod(){
        
        autoDeleteJob = new AutoDeleteJob(jobService);

        Mockito.doNothing().when(jobService).autoDeleteJob();

        autoDeleteJob.autoDeleteExpireJob();
        
        Mockito.verify(jobService, Mockito.times(1)).autoDeleteJob();
    }
}
