package com.xloop.resourceloop.createJob.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xloop.resourceloop.createJob.Model.Job;



@Repository
public interface JobRepository extends JpaRepository<Job,Long>{
    
    @Modifying
    @Query("UPDATE Job SET active = false WHERE closeDate <= :currentDate AND active = true")
    public void autoDeleteJob(@Param("currentDate") Date currentDate) throws Exception;

}
