package es.cic.curso25.proy007.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso25.proy007.model.Perro;
import es.cic.curso25.proy007.repository.PerroRepository;

@SpringBootTest
public class PerroServiceIntegrationTest {

    //Inyectar PerroService
        //Si utilizamos mockmvc no se hace autowired private PerroService perroService;
        //Sería @Autowired private MockMvc mockMvc;
        //Con un mapper (?)

    @Autowired
    private PerroService perroService;

    @Test
    void testCreate() {
        String razaPerro = "labrador";

        Perro perro = new Perro();
        perro.setRaza(razaPerro);

        Perro perro2 = perroService.create(perro);

        assertEquals(razaPerro, perro2.getRaza());
    }

}
