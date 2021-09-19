package com.example.employeeservice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestInstance;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;



@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeRepository employeeRepository;

    @BeforeAll
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void getAllEmployees() throws Exception{
        List<Employee> employeeList = Arrays.asList(new Employee(1,"John",
                "warner","john@gmail.com","consultant"));
        when(employeeRepository.findAll()).thenReturn(employeeList);

        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getEmployee() throws Exception{

        Employee emp = new Employee(1,"John",
                "warner","john@gmail.com","consultant");

        Optional<Employee> optionalEmployee= Optional.of(emp);
        when(employeeRepository.findById(1l)).thenReturn(optionalEmployee);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",Matchers.is("John")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName",Matchers.is("warner")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email",Matchers.is("john@gmail.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.jobTitle",Matchers.is("consultant")));
        Mockito.verify(employeeRepository).findById(1l);
    }

    @Test
    void createEmployee() throws Exception{

        String jsonString = "{\n" +
                "\"id\":1,\n" +
                "\"firstName\":\"John\",\n" +
                "\"lastName\":\"warner\",\n" +
                "\"email\":\"john@gmail.com\",\n" +
                "\"jobTitle\":\"consultant\"\n" +
                "}";
        Employee emp = new Employee(1,"John",
                "warner","john@gmail.com","consultant");
        when(employeeRepository.save(emp)).thenReturn(emp);
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                        .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(print());
                .andExpect(MockMvcResultMatchers.jsonPath("$.id",Matchers.is(1)))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",Matchers.is("John")))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.lastName",Matchers.is("warner")))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.email",Matchers.is("john@gmail.com")))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.jobTitle",Matchers.is("consultant")));
    }

    @Test
    void updateEmployee() throws Exception{

        String jsonString = "{\n" +
                "\"id\":1,\n" +
                "\"firstName\":\"Updated\",\n" +
                "\"lastName\":\"warner\",\n" +
                "\"email\":\"john@gmail.com\",\n" +
                "\"jobTitle\":\"consultant\"\n" +
                "}";
        Employee emp = new Employee(1,"Updated",
                "warner","john@gmail.com","consultant");
        Optional<Employee> optionalEmployee= Optional.of(emp);
        when(employeeRepository.findById(1l)).thenReturn(optionalEmployee);
        when(employeeRepository.save(emp)).thenReturn(emp);
        mockMvc.perform(MockMvcRequestBuilders.put("/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id",Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",Matchers.is("Updated")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName",Matchers.is("warner")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email",Matchers.is("john@gmail.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.jobTitle",Matchers.is("consultant")));

    }

    @Test
    void deleteEmployee() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/employees/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}