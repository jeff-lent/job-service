package com.xloop.resourceloop.createJob.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.Job;


public interface JobRepository extends JpaRepository<Job,Long>{
    
}
