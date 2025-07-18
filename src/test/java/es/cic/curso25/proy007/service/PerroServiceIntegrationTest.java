package es.cic.curso25.proy007.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PerroServiceIntegrationTest {

    //Inyectar PerroService
        //Si utilizamos mockmvc no se hace autowired private PerroService perroService;
        //Sería @Autowired private MockMvc mockMvc;
        //Con un mapper (?)
    @Autowired
    private PerroService perroService;


}
