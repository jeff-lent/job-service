package com.xloop.resourceloop.createJob.Model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;

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
@Setter
@Getter

public class TechnicalSkill implements GenericDropDownModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    @Getter @Setter private String technicalSkill;

    // @JsonIgnore
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "job_id")
    // @Getter @Setter private Job job;


    @JsonIgnore
    @ManyToMany(mappedBy = "technicalSkills",fetch = FetchType.LAZY)
    private Set<Job> jobs;


    private boolean active=true;


    
    public void addJob(Job job) {
        if (this.jobs == null) {
            this.jobs = new HashSet<>();
        }
        this.jobs.add(job);
    }
    

    public TechnicalSkill(String technicalSkill){
        this.technicalSkill = technicalSkill;
    }


    public TechnicalSkill() {}
}
