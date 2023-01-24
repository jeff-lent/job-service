package com.xloop.resourceloop.createJob.Model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Employement_Enum;
import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Gender_Enum;
import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Traveling_Enum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;


//checking the job class should have all field

@SpringBootTest
class Testing_Job {

    @Test
    void contextLoads() {
    }

    private static Job job;

    @BeforeAll
    public static void setUp() {
        job = new Job();
    }

    @Test
    public void testId() {
        job.setId(1L);
        assertNotNull(job.getId());
        assertEquals(1L, job.getId().longValue());
    }

    @Test
    public void testDepartment() {
        job.setDepartment("ClOUD_ENGINEER");
        assertEquals("ClOUD_ENGINEER", job.getDepartment());
    }

    @Test
    public void testEmploymentCategory() {
        job.setEmployementCategory(List.of(Employement_Enum.FULL_TIME));
        assertEquals(List.of(Employement_Enum.FULL_TIME), job.getEmployementCategory());
    }

    @Test
    public void testGender() {
        job.setGender(List.of(Gender_Enum.MALE));
        assertEquals(List.of(Gender_Enum.MALE), job.getGender());
    }

    @Test
    public void testTraveling() {
        job.setTraveling(Traveling_Enum.NO);
        assertEquals(Traveling_Enum.NO, job.getTraveling());
    }

    @Test
    public void testLocation() {
        job.setLocation("KARACHI");
        assertEquals("KARACHI", job.getLocation());
    }

    @Test
    public void testSoftSkills() {
        job.setSoftSkills(List.of(new  SoftSkill("Communication") ));
        assertEquals("Communication", job.getSoftSkills().get(0).getSoftSkill());
    }

    @Test
    public void testTechnicalSkills() {
        job.setTechnicalSkills(List.of(new  technicalSkill("Java") ));
        assertEquals("Java", job.getTechnicalSkills().get(0).getTechnicalSkill());
    }

    @Test
    public void testPostDate() {
        job.setPostDate(new Date());
        assertNotNull(job.getPostDate());
    }
    @Test
    public void testCloseDate() {
        job.setCloseDate(new Date());
        assertNotNull(job.getCloseDate());
    }

    @Test
    public void testDescription() {
        job.setDescription("Software Engineer Position");
        assertEquals("Software Engineer Position", job.getDescription());
    }

    @Test
    public void testResponsibilities() {
        job.setResponsibilitiess(List.of(new Responsibilities("Develop and maintain software applications")));
        assertEquals("Develop and maintain software applications", job.getResponsibilitiess().get(0).getResponsibility());
    }
    @Test
    public void testTitle() {
        job.setTitle("Backend Engineer");
        assertEquals("Backend Engineer", job.getTitle());
    }
    @Test
    public void testEducation() {
        job.setEducations(List.of(new Education("Bachelors in Computer Science")));
        assertEquals("Bachelors in Computer Science", job.getEducations().get(0).getEducation());
    }
    @Test
    public void testExpLevel() {

        job.setExperienceLevel(3);
        assertEquals(3, job.getExperienceLevel());
    
    }

    @Test
    public void testVacCount() {
        job.setVacancyCount(5);
        assertEquals(5, job.getVacancyCount());
    }

    @Test
    public void testBenefitPerks() {
        job.setBenefitPerkss(List.of(new BenefitsPerks("Health Insurance, Paid Vacation")));
        assertEquals("Health Insurance, Paid Vacation", job.getBenefitPerkss().get(0).getBenefitPerks());
    }

}
