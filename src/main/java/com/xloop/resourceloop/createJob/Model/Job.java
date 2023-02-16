package com.xloop.resourceloop.createJob.Model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xloop.resourceloop.createJob.Model.DropDownModel.Benefits;
import com.xloop.resourceloop.createJob.Model.DropDownModel.Department;
import com.xloop.resourceloop.createJob.Model.DropDownModel.Education;
import com.xloop.resourceloop.createJob.Model.DropDownModel.JobType;
import com.xloop.resourceloop.createJob.Model.DropDownModel.Location;
import com.xloop.resourceloop.createJob.Model.DropDownModel.Perks;
import com.xloop.resourceloop.createJob.Model.DropDownModel.SoftSkill;
import com.xloop.resourceloop.createJob.Model.DropDownModel.TechnicalSkill;

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
 * Job title ( text field)
 * 
 * Description (text)
 * 
 * Department (drop-down with add button)
 * 
 * Responsibilities (text field with add button)
 * 
 * Education/degree (text field)
 * 
 * Experience level (drop-down list) (0-25)
 * 
 * Employment Category (intern, full-time, contract, part-time - dropdown could
 * be more than one)
 * 
 * No. of vacancies (text field)
 * 
 * Gender (male, female, others) (checkbox)
 * 
 * Skills (soft skills & technical skills) (drop down with add button)
 * 
 * Job Location (cities dropdown)
 * 
 * Requires traveling (yes/no/maybe) (dropdown)
 * 
 * Benefits and perks (text field)
 * 
 * closing date (calendar) (15 years range)
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        // @Column(name = "job_id")
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(columnDefinition = "TEXT", nullable = false)
        private String description;

        @ManyToOne
        @JoinColumn(name = "department_id", nullable = true)
        private Department departments;

        @ManyToOne
        @JoinColumn(name = "location_id", nullable = true)
        private Location locations;

        @Column(columnDefinition = "TEXT", nullable = false)
        private String responsibilities;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "JOB_EDUCATION_TABLE" 
                        , joinColumns = { @JoinColumn(name = "job_id", referencedColumnName = "id")}
                        , inverseJoinColumns = { @JoinColumn(name = "education_id", referencedColumnName = "id")})
        private Set<Education> educations;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "JOB_JOBTYPE_TABLE" 
                        , joinColumns = { @JoinColumn(name = "job_id", referencedColumnName = "id")}
                        , inverseJoinColumns = { @JoinColumn(name = "jobType_id", referencedColumnName = "id")})
        private Set<JobType> jobTypes;


        @Column(precision = 2, nullable = false)
        private int experienceLevel;


        @Column(nullable = false)
        private int vacancyCount;

        @Column(nullable = false)
        private String gender; // ADDED BOTH, MALE FEMALE

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "JOB_SOFTSKILL_TABLE"
                        , joinColumns = { @JoinColumn(name = "job_id", referencedColumnName = "id")}
                        , inverseJoinColumns = { @JoinColumn(name = "soft_skill_id", referencedColumnName = "id")})
        private Set<SoftSkill> softSkills;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "JOB_TECHNICALSKILL_TABLE"
                        , joinColumns = { @JoinColumn(name = "job_id", referencedColumnName = "id")}
                        , inverseJoinColumns = { @JoinColumn(name = "technical_skill_id", referencedColumnName = "id")})
        private Set<TechnicalSkill> technicalSkills;

        @Column(nullable = false)
        private String traveling;

        @Column(nullable = false)
        private Date postDate;


        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "JOB_BENIFITS_TABLE", joinColumns = {
                        @JoinColumn(name = "job_id", referencedColumnName = "id")
        }, inverseJoinColumns = {
                        @JoinColumn(name = "benefits_id", referencedColumnName = "id")
        })
        private Set<Benefits> benefits;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "JOB_PERKS_TABLE", joinColumns = {
                        @JoinColumn(name = "job_id", referencedColumnName = "id")
        }, inverseJoinColumns = {
                        @JoinColumn(name = "perks_id", referencedColumnName = "id")
        })
        private Set<Perks> perks;

        @Column(nullable = false)
        private Date closeDate;

        private boolean active = true;

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        @OneToMany(mappedBy = "job", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<JobApply> jobApplies;

        @JsonIgnoreProperties
        public int getJobApplies() {
                return jobApplies == null ? 0 : jobApplies.size();
        }

        private Long hmId;

}
