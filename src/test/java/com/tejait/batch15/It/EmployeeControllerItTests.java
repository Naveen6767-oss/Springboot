package com.tejait.batch15.It;

import com.tejait.batch15.model.Employee;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
 class EmployeeControllerItTests {



    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;


    @Test
    void givenEmp_whenSaveEmp_thenReturnSavedEmp() throws Exception {
        // given
        Employee givenEmp = Employee.builder()
                // .id(1)
                .fname("Bharat")
                .lname("p")
                .fullname("Bharat p")
                .age(22)
                .dept("java")
                .salary(100000L).empCode("ja123va")
                .build();





        ResultActions result =mockMvc.perform(post("/employee/saveEmp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(givenEmp)));
        // then

        result.andExpect(MockMvcResultMatchers.status().isCreated());

        result.andExpect(MockMvcResultMatchers.jsonPath("$.fname").value("Bharat"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.dept").value("java"));

    }
}
