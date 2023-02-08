package com.xloop.resourceloop.createJob.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xloop.resourceloop.createJob.Model.BenefitsPerks;
import com.xloop.resourceloop.createJob.Model.Education;
import com.xloop.resourceloop.createJob.Model.Job;
import com.xloop.resourceloop.createJob.Model.Responsibilities;
import com.xloop.resourceloop.createJob.Model.SoftSkill;
import com.xloop.resourceloop.createJob.Model.TechnicalSkill;
import com.xloop.resourceloop.createJob.Service.JobService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@SpringBootTest
@AutoConfigureMockMvc
public class Test_Job_Controller {
    
    private MockMvc mockMvc;
    
    @InjectMocks
    private JobController jobController;
    
    @Mock
    private JobService jobService;
    
    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(jobController).build();
    }
    
    @Test
    public void testPostJob() throws Exception {

        Date pd = Date.from( LocalDate.of(2022, 1, 15).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ) ;
        Date dd = Date.from( LocalDate.of(2022, 1, 25).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ) ;

        
        Job job = new Job();
        job.setId(1L);
        job.setTitle("Backend Engineer");
        job.setDepartment("ClOUD_ENGINEER");
        job.setEmployementCategory(List.of("FULL TIME") );
        job.setGender("MALE" );
        job.setTraveling("NO");
        job.setLocation("KARACHI");
        job.setSoftSkills(Set.of(new SoftSkill("Communication")));
      //  job.setTechnicalSkills(List.of(new technicalSkill("Java"), new technicalSkill("Junit")));
        job.setPostDate(pd);
        job.setCloseDate(dd);
        job.setDescription("Software Engineer Position");
        job.setResponsibilitiess(List.of(new Responsibilities("Develop and maintain software applications")));
        job.setExperienceLevel(3);
        job.setVacancyCount(5);
      //  job.setEducations(List.of(new Education("Bachelors in Computer Science")));
      //  job.setBenefitPerkss(List.of(new BenefitsPerks("Health Insurance, Paid Vacation")));
        
        when(jobService.save(any(Job.class))).thenReturn(job);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(job);

        System.out.println(json);
        mockMvc.perform(post("/job/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.title").value("Backend Engineer"))
            .andExpect(jsonPath("$.department").value("ClOUD_ENGINEER"))
            .andExpect(jsonPath("$.employementCategory").value("FULL TIME"))
            .andExpect(jsonPath("$.gender").value("MALE"))
            .andExpect(jsonPath("$.traveling").value("NO"))
            .andExpect(jsonPath("$.location").value("KARACHI"))
            .andExpect(jsonPath("$.softSkills[0].softSkill").value("Communication"))
            .andExpect(jsonPath("$.technicalSkills[0].technicalSkill").value("Java"))
            .andExpect(jsonPath("$.postDate").value(pd.getTime()))
            .andExpect(jsonPath("$.closeDate").value(dd.getTime()))
            .andExpect(jsonPath("$.description").value("Software Engineer Position"))
            .andExpect(jsonPath("$.experienceLevel").value(3))
            .andExpect(jsonPath("$.vacancyCount").value(5))
            .andExpect(jsonPath("$.responsibilitiess[0].responsibility").value("Develop and maintain software applications"))
            .andExpect(jsonPath("$.educations[0].education").value("Bachelors in Computer Science"))
            .andExpect(jsonPath("$.benefitPerkss[0].benefitPerks").value("Health Insurance, Paid Vacation"));
    }



    @Test
    public void testUpdateJob()throws Exception{


        Date pd = Date.from( LocalDate.of(2022, 1, 15).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ) ;
        Date dd = Date.from( LocalDate.of(2022, 1, 25).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ) ;
        
        Job job = new Job();
        job.setId(1L);
        job.setTitle("Backend Engineer");
        job.setDepartment("ClOUD_ENGINEER");
        job.setEmployementCategory(List.of("FULL TIME") );
        job.setGender("MALE" );
        job.setTraveling("NO");
        job.setLocation("KARACHI");
        job.setSoftSkills(Set.of(new SoftSkill("Communication")));
       // job.setTechnicalSkills(List.of(new technicalSkill("Java"), new technicalSkill("Junit")));
        job.setPostDate(pd);
        job.setCloseDate(dd);
        job.setDescription("Software Engineer Position");
        job.setResponsibilitiess(List.of(new Responsibilities("Develop and maintain software applications")));
        job.setExperienceLevel(3);
        job.setVacancyCount(5);
      //  job.setEducations(List.of(new Education("Bachelors in Computer Science")));
     //   job.setBenefitPerkss(List.of(new BenefitsPerks("Health Insurance, Paid Vacation")));
        
        
        when(jobService.update(any(Job.class))).thenReturn(job);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(job);

        System.out.println(json);
        mockMvc.perform(post("/job/update/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.title").value("Backend Engineer"))
            .andExpect(jsonPath("$.department").value("ClOUD_ENGINEER"))
            .andExpect(jsonPath("$.employementCategory").value("FULL TIME"))
            .andExpect(jsonPath("$.gender").value("MALE"))
            .andExpect(jsonPath("$.traveling").value("NO"))
            .andExpect(jsonPath("$.location").value("KARACHI"))
            .andExpect(jsonPath("$.softSkills[0].softSkill").value("Communication"))
            .andExpect(jsonPath("$.technicalSkills[0].technicalSkill").value("Java"))
            .andExpect(jsonPath("$.postDate").value(pd.getTime()))
            .andExpect(jsonPath("$.closeDate").value(dd.getTime()))
            .andExpect(jsonPath("$.description").value("Software Engineer Position"))
            .andExpect(jsonPath("$.experienceLevel").value(3))
            .andExpect(jsonPath("$.vacancyCount").value(5))
            .andExpect(jsonPath("$.responsibilitiess[0].responsibility").value("Develop and maintain software applications"))
            .andExpect(jsonPath("$.educations[0].education").value("Bachelors in Computer Science"))
            .andExpect(jsonPath("$.benefitPerkss[0].benefitPerks").value("Health Insurance, Paid Vacation"));
    }


    @Test
    public void testDeleteJob() throws Exception{

        Mockito.doNothing().when(jobService).delete(any());        
        mockMvc.perform(
            delete("/job/delete/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        Mockito.verify(jobService, Mockito.times(1)).delete(any());
    }

    @Test
    public void testGettingJobList() throws Exception{
        
        Job job1 = new Job();
        job1.setId(1L);
        Job job2 = new Job();
        job2.setId(2L);
        Job job3 = new Job();
        job3.setId(3L);
        Job job4 = new Job();
        job4.setId(4L);

        when(jobService.viewAllJob()).thenReturn(List.of(job1,job2,job3,job4));
        
        mockMvc.perform(get("/job/all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1L))
        .andExpect(jsonPath("$[1].id").value(2L))
        .andExpect(jsonPath("$[2].id").value(3L))
        .andExpect(jsonPath("$[3].id").value(4L));

    }

    
    @Test
    public void testViewJob() throws Exception {

        Date pd = Date.from( LocalDate.of(2022, 1, 15).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ) ;
        Date dd = Date.from( LocalDate.of(2022, 1, 25).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ) ;

        
        Job job = new Job();
        job.setId(1L);
        job.setTitle("Backend Engineer");
        job.setDepartment("ClOUD_ENGINEER");
        job.setEmployementCategory(List.of("FULL TIME") );
        job.setGender("MALE" );
        job.setTraveling("NO");
        job.setLocation("KARACHI");
        job.setSoftSkills(Set.of(new SoftSkill("Communication")));
       // job.setTechnicalSkills(List.of(new technicalSkill("Java"), new technicalSkill("Junit")));
        job.setPostDate(pd);
        job.setCloseDate(dd);
        job.setDescription("Software Engineer Position");
        job.setResponsibilitiess(List.of(new Responsibilities("Develop and maintain software applications")));
        job.setExperienceLevel(3);
        job.setVacancyCount(5);
      //  job.setEducations(List.of(new Education("Bachelors in Computer Science")));
     //   job.setBenefitPerkss(List.of(new BenefitsPerks("Health Insurance, Paid Vacation")));
        
        when(jobService.getAJob(any())).thenReturn(Optional.of(job));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(job);

        System.out.println(json);
        mockMvc.perform(get("/job/detail/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.title").value("Backend Engineer"))
            .andExpect(jsonPath("$.department").value("ClOUD_ENGINEER"))
            .andExpect(jsonPath("$.employementCategory").value("FULL TIME"))
            .andExpect(jsonPath("$.gender").value("MALE"))
            .andExpect(jsonPath("$.traveling").value("NO"))
            .andExpect(jsonPath("$.location").value("KARACHI"))
            .andExpect(jsonPath("$.softSkills[0].softSkill").value("Communication"))
            .andExpect(jsonPath("$.technicalSkills[0].technicalSkill").value("Java"))
            .andExpect(jsonPath("$.postDate").value(pd.getTime()))
            .andExpect(jsonPath("$.closeDate").value(dd.getTime()))
            .andExpect(jsonPath("$.description").value("Software Engineer Position"))
            .andExpect(jsonPath("$.experienceLevel").value(3))
            .andExpect(jsonPath("$.vacancyCount").value(5))
            .andExpect(jsonPath("$.responsibilitiess[0].responsibility").value("Develop and maintain software applications"))
            .andExpect(jsonPath("$.educations[0].education").value("Bachelors in Computer Science"))
            .andExpect(jsonPath("$.benefitPerkss[0].benefitPerks").value("Health Insurance, Paid Vacation"));
    }


    @Test
    public void testGettingDeactiveJobList() throws Exception{
        
        Job job1 = new Job();
        job1.setId(1L);
        Job job2 = new Job();
        job2.setId(2L);
        Job job3 = new Job();
        job3.setId(3L);
        Job job4 = new Job();
        job4.setId(4L);

        when(jobService.viewDeactivatedJobs()).thenReturn(List.of(job1,job2,job3,job4));
        
        mockMvc.perform(get("/job/deactivated").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[1].id").value(2L))
        .andExpect(jsonPath("$[2].id").value(3L))
        .andExpect(jsonPath("$[3].id").value(4L));

    }
}
