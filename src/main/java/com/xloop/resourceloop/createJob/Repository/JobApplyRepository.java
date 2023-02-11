package com.xloop.resourceloop.createJob.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.Job;
import com.xloop.resourceloop.createJob.Model.JobApply;

public interface JobApplyRepository extends JpaRepository<JobApply, Long> {
    public Optional<JobApply> findByJobAndCandidateId(Job job, Long candidateId );
    public Iterable<JobApply>  findAllByJobId(Long jobId);
}
