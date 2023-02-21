package com.xloop.resourceloop.createJob.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Integrating_Class.CandidatePersonalInfo;
import com.xloop.resourceloop.createJob.Integrating_Class.UserProfile;
import com.xloop.resourceloop.createJob.Model.Job;
import com.xloop.resourceloop.createJob.Model.JobApply;
import com.xloop.resourceloop.createJob.Repository.JobApplyRepository;
import com.xloop.resourceloop.createJob.Repository.JobRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.InterfaceForDropDowns;

@Service
public class JobApplyService {

    public final JobApplyRepository jobApplyRepository;
    private final JobRepository jobRepository;

    public JobApplyService(JobApplyRepository jobApplyRepository, JobRepository jobRepository) {
        this.jobApplyRepository = jobApplyRepository;
        this.jobRepository = jobRepository;
    }

    public String ApplyingJob(Long jobId, Long candidateId) {

        Job jobToBeApplied = jobRepository.findById(jobId).get();
        // JobApply checkingAlreadyApply =
        // jobApplyRepository.findByJobAndCandidateId(jobToBeApplied, candidateId);

        if (jobApplyRepository.findByJobAndCandidateId(jobToBeApplied, candidateId).isPresent()) {
            return "Already Applied";
        } else {
            JobApply jobApplyObject = new JobApply();
            jobApplyObject.setApplyDate(new Date());
            jobApplyObject.setCandidateId(candidateId);
            jobApplyObject.setJob(jobToBeApplied);
            jobApplyRepository.save(jobApplyObject);
            return "Applied Successfully";
        }
    }

    public ResponseEntity<List<CandidatePersonalInfo>> getAllAppliedCandidates(Long id) {

        Iterable<JobApply> candidates = jobApplyRepository.findAllByJobId(id);
        if (candidates.spliterator().estimateSize() > 0) { // checking list size
            List<JobApply> listOfJobApply = StreamSupport.stream(candidates.spliterator(), false)
                    .collect(Collectors.toList());
            String candidateList = listOfJobApply.stream()
                    .map(jp -> jp.getCandidateId().toString())
                    .collect(Collectors.joining(","));
            return new UserProfile().getAllAppliedCandidate(candidateList, listOfJobApply);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    public List<Job> getAllAppliedJob(Long candidateId) {

        return StreamSupport.stream(jobApplyRepository.getAllJob(candidateId).spliterator(), false)
                .collect(Collectors.toList());
        // Iterable<JobApply> appliedJobs =
        // jobApplyRepository.findAllByCandidateId(candidateId);

        // if (appliedJobs.spliterator().estimateSize() > 0) { // checking list size
        // List<Job> jobs = StreamSupport.stream(appliedJobs.spliterator() , false).map(
        // aj->aj.getJob()
        // ).collect(Collectors.toList());
        // return jobs;
        // } else {
        // return List.of();
        // }

    }

}
