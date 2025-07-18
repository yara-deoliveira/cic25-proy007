package es.cic.curso25.proy007.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PerroControllerIntegrationTest {

    //Inyectar PerroController
        //Si utilizamos mockmvc no se hace autowired -> @Autowired private PerroController perroController;
        //Sería @Autowired private MockMvc mockMvc;
        //Con un mapper (?)
    @Autowired
    private PerroController perroController;


}
