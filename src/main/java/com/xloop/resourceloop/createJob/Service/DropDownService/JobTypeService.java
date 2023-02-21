package com.xloop.resourceloop.createJob.Service.DropDownService;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.DropDownModel.JobType;
import com.xloop.resourceloop.createJob.Repository.JobTypeRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;

@Service
public class JobTypeService extends GenericDropDown<JobType, JobTypeRepository>  {
    

    public JobTypeService(JobTypeRepository jobTypeRepository){
        super(jobTypeRepository);
    }

}
