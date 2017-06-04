package ru.irtech.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void index() throws Exception {
        Thread.sleep(5000); // Connection to remote wundergraund server do not always perform immediate after starting application.
        mockMvc.perform(get("/weather"));
        mockMvc.perform(post("/weather")
                .param("region", "RU/Moscow")
                .param("yearFrom", "2017")
                .param("yearTo", "2017")
                .param("monTo", "2")
                .param("dayTo", "2")
                .param("monFrom", "2")
                .param("dayFrom", "1"));

        mockMvc.perform(post("/weather")
                .param("region", "RU/Moscow")
                .param("yearFrom", "1990") // Special mistake.
                .param("yearTo", "3000") // Special mistake.
                .param("monTo", "2")
                .param("dayTo", "2")
                .param("monFrom", "2")
                .param("dayFrom", "1"));
    }
}