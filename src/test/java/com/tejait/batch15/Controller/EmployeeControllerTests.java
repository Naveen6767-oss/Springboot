package com.tejait.batch15.Controller;
import com.tejait.batch15.controller.EmployeeController;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(EmployeeController.class)
 class EmployeeControllerTests {

    @MockitoBean
    EmployeeService service;

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

        BDDMockito.given(service.saveEmployee(ArgumentMatchers.any(Employee.class)))
                .willReturn(givenEmp);
        ResultActions result =mockMvc.perform(post("http://localhost:8080/employee/saveEmp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(givenEmp)));
        // then

        result.andExpect(MockMvcResultMatchers.status().isCreated());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.fname").value("Bharat"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.dept").value("java"));








    }
}
