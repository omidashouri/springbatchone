package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

//@WebMvcTest(GreetController.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetControllerTest {

/*    @Autowired
    private MockMvc mockMvc;*/

    @LocalServerPort
    int randomServerPort;


/*    @Test
    void getUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/greetUser"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(ArgumentMatchers.contains("welcome to Java EE1")));
    }*/

    @Test
    void getUser2() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/greetUser";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals(true, result.getBody().contains("welcome to Java EE1"));
    }
}