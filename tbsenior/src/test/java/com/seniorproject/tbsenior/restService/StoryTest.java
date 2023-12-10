package com.seniorproject.tbsenior.restservice;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class StoryTest{

    @Autowired
    private MockMvc mvc;

    @Test
    public void getStoryTest() throws Exception {
        this.mvc.perform(get("/story")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.story", is("There once was a lady named Spicy\r\n" +
                        "She loved her hat quite filthy\r\n" +
                        "It came with a bang\r\n" +
                        "Through the town the sound rang\r\n" +
                        "Of the trash hat of dear lady Spicy")));
    }
};