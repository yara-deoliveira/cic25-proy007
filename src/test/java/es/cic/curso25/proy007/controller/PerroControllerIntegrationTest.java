package es.cic.curso25.proy007.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso25.proy007.model.Perro;
import es.cic.curso25.proy007.repository.PerroRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PerroControllerIntegrationTest {

    //Inyectar PerroController
        //Si utilizamos mockmvc no se hace autowired -> @Autowired private PerroController perroController;
        //Sería @Autowired private MockMvc mockMvc;
        //Con un mapper (?)
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PerroRepository perroRepository;
    
    @Test
    void testCreate() throws Exception{
        Perro perro = new Perro();
        perro.setRaza("Labrador");
        perro.setEdad(2);
        perro.setVacunado(true);

        String perroJson = objectMapper.writeValueAsString(perro);

        mockMvc.perform(post("/perro")
            .contentType("application/json")
            .content(perroJson))
            .andExpect(status().isOk())
            .andExpect(result -> {
                String respuesta = result.getResponse().getContentAsString();
                                Perro registroCreado = objectMapper.readValue(respuesta, Perro.class);
                                assertTrue(registroCreado.getId() > 0, "El valor debe ser mayor que 0");

                                Optional<Perro> registroRealmenteCreado = perroRepository.findById(registroCreado.getId());
                                assertTrue(registroRealmenteCreado.isPresent());
            });

    }

    @Test
    void testGet() throws Exception {
        Perro perro = new Perro();
        perro.setRaza("Husky");
        perro.setEdad(6);
        perro.setVacunado(false);

        String perroJson = objectMapper.writeValueAsString(perro);

        mockMvc.perform(post("/perro")
            .contentType("application/json")
            .content(perroJson))
            .andExpect(status().isOk());

        mockMvc.perform(get("/perro/1"))
            .andExpect(status().isOk());
        
    }

    void testDelete() throws Exception {
        Perro perro = new Perro();
        perro.setRaza("Chihuahua");
        perro.setEdad(9);
        perro.setVacunado(true);

        String perroJson = objectMapper.writeValueAsString(perro);

        mockMvc.perform(post("/perro")
            .contentType("application/json")
            .content(perroJson))
            .andExpect(status().isOk());

        mockMvc.perform(get("/perro/1"))
            .andExpect(status().isOk());
        
        mockMvc.perform(delete("/perro/1"))
            .andExpect(status().isOk())
            .andReturn();
        
    }

}
