package com.xloop.resourceloop.createJob.Integrating_Class;

// import com.xloop.resourceloop.createJob.RestTemplate.RestTemplate;
import org.springframework.web.client.RestTemplate;

import com.xloop.resourceloop.createJob.Model.JobApply;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Streams;
import org.springframework.http.ResponseEntity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserProfile {

    // @Autowired
    // private RestTemplate restTemplate;

    public ResponseEntity<List<CandidatePersonalInfo>> getAllAppliedCandidate(String candidateListString, List<JobApply> listOfJobApply) {

        
        try {
            String endpointUrl = "http://userprofileserviceelastic-env.eba-piepztun.ap-south-1.elasticbeanstalk.com/api/personal_information/users/list/"+ candidateListString;
            ResponseEntity<CandidatePersonalInfo[]> response = new RestTemplate().getForEntity(endpointUrl, CandidatePersonalInfo[].class);
            List<CandidatePersonalInfo> candidatesPersonalInfo = Arrays.stream( response.getBody())
                                                                        .map(cd-> {
                                                                            JobApply jobApply = listOfJobApply.parallelStream()
                                                                                                .filter(jp->jp.getCandidateId()==cd.getUserId())
                                                                                                .findFirst().get();
                                                                            cd.setAppliedDate(jobApply.getApplyDate());
                                                                            return cd;
                                                                        })
                                                                        .collect(Collectors.toList());
            return ResponseEntity.ok().body(candidatesPersonalInfo);
                                        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(408).build();
        }

        // ResponseEntity<String> response = restTemplate.getForEntity(endpointUrl,
        // String.class);
        // System.out.println(response.getBody());
    }
}
