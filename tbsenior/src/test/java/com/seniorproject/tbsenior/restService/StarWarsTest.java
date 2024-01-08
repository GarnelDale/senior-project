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
public class StarWarsTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getScrollTest() throws Exception {
        this.mvc.perform(get("/third-party")).andExpect(status().isOk());
    }

    @Test
    public void getShipTest() throws Exception {
        this.mvc.perform(get("/third-party/{ship}","Death Star")).andExpect(status().isOk());
    }
}