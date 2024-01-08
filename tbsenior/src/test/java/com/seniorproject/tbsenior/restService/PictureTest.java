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
public class PictureTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @Order(1)
    public void getGIFTest() throws Exception {
        this.mvc.perform(get("/picture")).andExpect(status().isOk());
    }

    @Test
    @Order(2)
    public void removeGIFTest() throws Exception {
        this.mvc.perform(delete("/picture")).andExpect(status().isNoContent());
    }

    @Test
    @Order(3)
    public void removeMissingGIFTest() throws Exception {
        this.mvc.perform(delete("/picture")).andExpect(status().isNoContent());
    }

    @Test
    @Order(4)
    public void getMissingGIFTest() throws Exception {
        this.mvc.perform(get("/picture")).andExpect(status().isNotFound());
    }
}