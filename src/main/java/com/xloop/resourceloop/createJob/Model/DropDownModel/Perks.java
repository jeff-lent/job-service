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
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Perks implements GenericDropDownModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @Getter @Setter private String perksName;

    @JsonIgnore
    @ManyToMany(mappedBy = "perks",fetch = FetchType.LAZY)
     private Set<Job> jobs;

     private boolean active=true;


    
    public void addJob(Job job) {
        if (this.jobs == null) {
            this.jobs = new HashSet<>();
        }
        this.jobs.add(job);
    }
   

    public Perks(String Perks) {
        this.perksName = Perks;
    }

    public Perks() {
    }
}
