package com.xloop.resourceloop.createJob.Model;

import java.util.Date;
import java.util.List;

import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Department_Enum;
import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Employement_Enum;
import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Gender_Enum;
import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Location_Enum;
import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Traveling_Enum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter @Setter
@ToString
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private Department_Enum department;
    
    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private Employement_Enum employementCategory;
    
    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private Gender_Enum gender;
    
    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private Traveling_Enum traveling;
    
    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private Location_Enum location;
    
    @Column( nullable = false)
    private String skills;
    
    @Column( nullable = false)
    private Date   postDate;

    @Column( nullable = false)
    private Date   closeDate;

    @Column( nullable = false)
    private String description;
    

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responsibilities> responsibilitiess;
    
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Designation> designations;
    
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educations;
    
    @OneToMany(mappedBy = "job",  fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BenefitsPerks> benefitPerkss;

    @Column(precision = 3, nullable = false)
    private int experienceLevel;
    
    @Column( nullable = false)
    private int vacancyCount;
    
    // public void addResponsibilities(Responsibilities responsibilities){

    //     responsibilities.setJob(this);
    //     responsibilitiess.add(responsibilities);
    // }
    

}
