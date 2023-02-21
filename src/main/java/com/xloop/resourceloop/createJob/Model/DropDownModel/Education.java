package com.xloop.resourceloop.createJob.Model.DropDownModel;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xloop.resourceloop.createJob.Model.Job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
public class Education implements GenericDropDownModel{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    @Getter @Setter private String educationName;

    @JsonIgnore
    @ManyToMany(mappedBy = "educations",fetch = FetchType.LAZY)
    private Set<Job> jobs;



    public void addJob(Job job) {
        if (this.jobs == null) {
            this.jobs = new HashSet<>();
        }
        this.jobs.add(job);
    }
    
    private boolean active=true;


    public Education(String education) {
        this.educationName = education;
    }

    public Education() {
    }

}
