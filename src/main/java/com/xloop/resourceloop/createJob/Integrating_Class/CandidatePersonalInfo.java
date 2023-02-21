package com.xloop.resourceloop.createJob.Integrating_Class;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidatePersonalInfo {
    private Long id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;
    private String nationalIdentityNumber;
    private String phoneNumber;
    private String city;
    private String address;
    private String linkedProfile;
    private String maritalStatus;
    private String email;
    private Long userId;
    private Date appliedDate;
}
