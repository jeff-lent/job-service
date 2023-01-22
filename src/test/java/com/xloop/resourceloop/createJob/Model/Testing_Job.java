package com.xloop.resourceloop.createJob.Model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Department_Enum;
import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Employement_Enum;
import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Gender_Enum;
import com.xloop.resourceloop.createJob.Model.Control_Vocabulary.Location_Enum;
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
        job.setDepartment(Department_Enum.ClOUD_ENGINEER);
        assertEquals(Department_Enum.ClOUD_ENGINEER, job.getDepartment());
    }

    @Test
    public void testEmploymentCategory() {
        job.setEmployementCategory(Employement_Enum.FULL_TIME);
        assertEquals(Employement_Enum.FULL_TIME, job.getEmployementCategory());
    }

    @Test
    public void testGender() {
        job.setGender(Gender_Enum.MALE);
        assertEquals(Gender_Enum.MALE, job.getGender());
    }

    @Test
    public void testTraveling() {
        job.setTraveling(Traveling_Enum.NO);
        assertEquals(Traveling_Enum.NO, job.getTraveling());
    }

    @Test
    public void testLocation() {
        job.setLocation(Location_Enum.KARACHI);
        assertEquals(Location_Enum.KARACHI, job.getLocation());
    }
    @Test
    public void testSkills() {
        job.setSkills("Java, JUnit, Spring");
        assertEquals("Java, JUnit, Spring", job.getSkills());
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
    public void testDesignation() {
        job.setDesignations(List.of(new Designation("Software Engineer")));
        assertEquals("Software Engineer", job.getDesignations().get(0).getDesignation());
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
