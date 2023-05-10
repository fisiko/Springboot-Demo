package com.qa.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerMvcTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception{
        Person newPerson = new Person("Bob", 42, "Builder");
        String newPersonAsJson = this.mapper.writeValueAsString(newPerson);
        RequestBuilder mockRequest = MockMvcRequestBuilders.post("/create").contentType(MediaType.APPLICATION_JSON).content(newPersonAsJson);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        Person newPerson1 = new Person(1, "Bob", 42, "Builder");
        String newPersonAsJson1 = this.mapper.writeValueAsString(newPerson1);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(newPersonAsJson1);

        this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

    }

}
