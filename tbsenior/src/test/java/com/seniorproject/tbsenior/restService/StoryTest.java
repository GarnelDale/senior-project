package com.seniorproject.tbsenior.restservice;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.StandardCharsets;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoryTest{

    @Autowired
    private MockMvc mvc;

    @Test
    @Order(1)
    public void getStoryTest() throws Exception {
        this.mvc.perform(get("/story")).andExpect(status().isOk())
                .andExpect(jsonPath("$.story", is("There once was a lady named Spicy\r\n" +
                        "She loved her hat quite filthy\r\n" +
                        "It came with a bang\r\n" +
                        "Through the town the sound rang\r\n" +
                        "Of the trash hat of dear lady Spicy")));
    }

    @Test
    @Order(2)
    public void emptyUpdateTest() throws Exception {
        this.mvc.perform(post("/story").content("{\"story\":\"\"}")).andExpect(status().isCreated());
    }

    @Test
    @Order(3)
    public void updateStoryTest() throws Exception {
        this.mvc.perform(post("/story")
                .content("{\"story\":\"Hello Request\"}"))
                .andExpect(status().isCreated());

    }

    @Test
    @Order(3)
    public void putFileConflictTest() throws Exception {
        this.mvc.perform(put("/story")).andExpect(status().isConflict());
    }

    @Test
    @Order(4)
    public void deleteFileTest() throws Exception {
        this.mvc.perform(delete("/story")).andExpect(status().isNoContent());
    }

    @Test
    @Order(5)
    public void deleteMissingTest() throws Exception {
        this.mvc.perform(delete("/story")).andExpect(status().isNoContent());
    }

    @Test
    @Order(6)
    public void getMissingTest() throws Exception {
        this.mvc.perform(get("/story")).andExpect(status().isNotFound());
    }

    @Test
    @Order(7)
    public void putNewFileTest() throws Exception {
        this.mvc.perform(put("/story")).andExpect(status().isCreated());
    }

    @Test
    @Order(8)
    public void postStory() throws Exception {
        this.mvc.perform(post("/story").content("{\"story\":\"There once was a lady named Spicy\r\n" +
                                        "She loved her hat quite filthy\r\n" +
                                        "It came with a bang\r\n" +
                                        "Through the town the sound rang\r\n" +
                                        "Of the trash hat of dear lady Spicy\"}")).andExpect(status().isCreated());
    }
};