package com.example.demo.controller;

import com.example.demo.dto.PersonaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class PersonaControllerTest {
    private final static String BASE_URL = "/persona/";

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void create() throws Exception {
        PersonaDTO personaDTO = buildPersonaDTO();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(personaDTO)))
                .andReturn();
        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void createWithError() throws Exception {
        PersonaDTO personaDTO = new PersonaDTO();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(personaDTO)))
                .andReturn();
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void getAll() throws Exception {
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL)
                        .queryParam("enablePagination","false")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        assertEquals(200, mockMvcResult.getResponse().getStatus());
    }

    @Test
    void deleteById() {
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private PersonaDTO buildPersonaDTO(){
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre("David");
        personaDTO.setApellido("Gaviria");
        personaDTO.setCorreo("ashjashjd@ashjksd.com");
        personaDTO.setNumeroDocumentoIdentificacion(45454545);
        personaDTO.setEdad(12);
        return personaDTO;
    }
}