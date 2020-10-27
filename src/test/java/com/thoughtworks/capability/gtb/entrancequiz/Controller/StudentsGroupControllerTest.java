package com.thoughtworks.capability.gtb.entrancequiz.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.Dto.Students;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentsGroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class StudentsGroupControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    StudentsGroupService studentsGroupService;

    @Test
    void should_get_all_students() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("成吉思汗")))
                .andExpect(jsonPath("$[14].id", is(15)))
                .andExpect(jsonPath("$[14].name", is("蔡文姬")));
    }

    @Test
    void should_add_new_student() throws Exception {
        mockMvc.perform(post("/add")
                .content("宫本武藏")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        int size = studentsGroupService.getAll().size();
        Students student = studentsGroupService.getAll().get(15);
        assertEquals(16, size);
        assertEquals("宫本武藏", student.getName());
    }
}