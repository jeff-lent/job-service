package com.xloop.resourceloop.createJob.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.DropDownModel.JobType;

public interface JobTypeRepository extends JpaRepository<JobType,Long>  {
    
    public List<JobType> findAllByJobTypeNameIn(List<String> jobtype);
    public List<JobType> findAllByJobTypeNameInAndActiveIsTrue(List<String> jobTypes);



}
