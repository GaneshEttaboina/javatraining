package com.lnt.springbootdemo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class TestEmployeeRESTController {
	
	 @Autowired
	  private MockMvc mvc;
	
	@Test
	public void getAllEmployeesAPI() throws Exception 
	{
	  mvc.perform(MockMvcRequestBuilders
	  			.get("/employees")
	  			.accept(MediaType.APPLICATION_JSON))
//	      .andDo(print())
//	      .andExpect(status().isOk())
	  	.andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.[*]").exists())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty());
	}
	
	@Test
	public void createEmployeeAPI() throws Exception 
	{
	  mvc.perform( MockMvcRequestBuilders
		      .post("/employees")
		      .content(asJsonString(new Employee(334, "lastName", 3445.454)))
		      .contentType(MediaType.APPLICATION_JSON)
		      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isCreated());
//	      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
	}
	 
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
