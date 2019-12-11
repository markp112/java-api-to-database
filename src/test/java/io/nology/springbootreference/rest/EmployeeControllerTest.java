package io.nology.springbootreference.rest;

import io.nology.springbootreference.dao.EmployeeDAO;
import io.nology.springbootreference.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRestController.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeDAO dao;

    @Test
    public void givenEmployees_whenGetAllEmployees_thenReturnJsonArrayOfEmployees() throws Exception {
        Employee ollie = new Employee("Ollie", "Holden", "ollie@me.com");
        Employee shea = new Employee("Shea", "Murphy", "shea@him.com");
        List<Employee> allEmployees = Arrays.asList(ollie, shea);

        when(dao.findAll()).thenReturn(allEmployees);

        mvc.perform(get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(ollie.getFirstName())));
    }
}