package com.example.springbootdash.springbootdash.controllers;

import com.example.springbootdash.springbootdash.Entities.Skill;
import com.example.springbootdash.springbootdash.services.SkillService;
import com.example.springbootdash.springbootdash.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(SkillController.class)  // Tells Spring to only load SkillController and mock the rest
public class SkillControllerTest {

    @Autowired
    private MockMvc mockMvc;  // This is used to simulate HTTP requests

    @MockBean
    private SkillService skillService;  // Mock SkillService

    @MockBean
    private UserService userService;  // Mock UserService

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    void testAddSkill() throws Exception {
        // Arrange: Create a sample Skill object (with the expected values)
        Skill skill = new Skill();
        skill.setGuitar(10);
        skill.setRocketleague(20);

        // Act: Simulate a POST request to the "/skills" endpoint with the skill object as JSON
        mockMvc.perform(post("/skills")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":1, \"guitar\":10, \"rocketleague\":20}"))
                .andExpect(status().isCreated())  // Expect HTTP status 201 (Created)
                .andExpect(content().string("Skill created at /skills/1"));  // Expect the response message

        // Assert: Verify that the service method was called once with the skill argument
        verify(skillService, times(1)).insertSkill(skill);
    }
}
