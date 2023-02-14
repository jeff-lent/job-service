package com.xloop.resourceloop.createJob.Model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
Job title ( text field)

Description (text)

Department (drop-down with add button)

Responsibilities (text field with add button)

Education/degree (text field)

Experience level (drop-down list) (0-25)

Employment Category  (intern, full-time, contract, part-time - dropdown could be more than one)

No. of vacancies (text field)

Gender (male, female, others) (checkbox)

Skills (soft skills & technical skills) (drop down with add button)

Job Location (cities dropdown) 

Requires traveling (yes/no/maybe) (dropdown)

Benefits and perks (text field)

closing date (calendar) (15 years range)
 */
 


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "job_id")
    private Long id;
    
    @Column( nullable = false)
    private String title; 
    
    @Column( nullable = false)
    // @Lob
    private String description;
    
    // @Column( nullable = false)
    // private String department;
    
    @ManyToOne
    @JoinColumn(name = "department_id",nullable = true)
    private Department department;





    @Column( nullable = false)
    private String responsibilities;
    
    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="JOB_EDUCATION_TABLE",

            joinColumns = {
              @JoinColumn( name ="job_id",referencedColumnName="id")
            },
            inverseJoinColumns={
                @JoinColumn(name="education_id",referencedColumnName = "id")
            }
    
    )
    private Set<Education> educations;




    // @OneToMany(mappedBy = "job", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    // private List<Education> educations;
    
    @Column(precision = 2, nullable = false)
    private int experienceLevel;
    
    // @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private List<String> employementCategory; // LIST OF EMOLYEMENT TYPE WOULD SELECTED
    
    @Column( nullable = false)
    private int vacancyCount;
    
    @Column( nullable = false)
    private String gender; // ADDED BOTH, MALE FEMALE


    @ManyToMany( fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinTable( name = "JOB_SOFTSKILL_TABLE",

    joinColumns = {
            @JoinColumn(name = "job_id",referencedColumnName = "id")
    },
    inverseJoinColumns = {
        @JoinColumn(name="soft_skill_id",referencedColumnName = "id")
    }

    )
    private Set<SoftSkill> softSkills; 
    

    // @OneToMany(mappedBy = "job", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    // private List<technicalSkill> technicalSkills; 

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="JOB_TECHNICALSKILL_TABLE",
        joinColumns = {
            @JoinColumn(name = "job_id",referencedColumnName = "id" )
        },
        inverseJoinColumns = {
            @JoinColumn(name="technical_skill_id",referencedColumnName = "id")
        }
    )

    private Set<TechnicalSkill> technicalSkills; 

    


    @Column( nullable = false)
    private String location;
    
    // @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private String traveling;
    
    
    @Column( nullable = false)
    private Date   postDate;
    
    // @OneToMany(mappedBy = "job",  fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    // private List<BenefitsPerks> benefitPerkss;
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="JOB_BENIFITS_TABLE",
        joinColumns = {
            @JoinColumn(name="job_id",referencedColumnName = "id")
        },
        inverseJoinColumns = {
            @JoinColumn(name="benefits_id",referencedColumnName = "id")
        }
    )    
    private Set<BenefitsPerks> benefitPerkss;    

        

    @Column( nullable = false)
    private Date   closeDate;
    
    
    // public void addResponsibilities(Responsibilities responsibilities){

    //     responsibilities.setJob(this);
    //     responsibilitiess.add(responsibilities);
    // }
    
    private boolean active=true;



    @JsonIgnore
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<JobApply> jobApplies;


    private Long hmId;

}
