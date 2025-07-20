package es.cic.curso25.proy007.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.proy007.model.Gato;

@SpringBootTest
public class GatoControllerTest {

    @Autowired
    private GatoController gatoController;

    @Test
    void testCreate() {
        Gato gato = new Gato();
        gato.setRaza("siamés");
        gato.setEdad(2);
        gato.setAdoptado(true); // hasta aquí, hemos dado todos los atributos menos id
        gato = gatoController.create(gato); // aquí le asignamos la id
        Long idGato = gato.getId(); // la identificamos
        Gato gatoVerificado = gatoController.get(idGato); // esto es un poco redundante, pero es por testear get (1)
        assertTrue(gatoVerificado.getId() == 1); // por cómo hemos decidido generar ids, debería ser 1

    }

    @Test
    void testDelete() {
        Gato gato = new Gato();
        gato.setRaza("siamés");
        gato.setEdad(2);
        gato.setAdoptado(true); // hasta aquí, hemos dado todos los atributos menos id
        gato = gatoController.create(gato); // aquí le asignamos la id
        Long idGato = gato.getId(); // la identificamos
        gatoController.delete(idGato); // y borramos el gato cuya id sea esa
        Gato gatoBorrado = gatoController.get(idGato); // ahora, no debería haber ningún gato con la id que hemos borrado
        assertNull(gatoBorrado); // luego esto debería ser cierto
    }

    @Test
    void testGetOne() {
        Gato gato = new Gato();
        gato.setRaza("siamés");
        gato.setEdad(2);
        gato.setAdoptado(true); // hasta aquí, hemos dado todos los atributos menos id
        gato = gatoController.create(gato); // aquí le asignamos la id
        Long idGato = gato.getId(); // la identificamos
        gato = gatoController.get(idGato);
        // comprobamos ahora que el get ha funcionado correctamente: si se han leído bien los datos, deberían coincidir
        assertEquals(gato.getRaza(), "siamés");
        assertEquals(gato.getEdad(), 2);
        assertTrue(gato.isAdoptado());
        assertEquals(gato.getId(), 1); // y aquí, porque es el "primer gato"
    }

    @Test
    void testGetAll() {
        Gato gato1 = new Gato();
        gato1.setRaza("siamés");
        gato1.setEdad(2);
        gato1.setAdoptado(true);
        gatoController.create(gato1);

        Gato gato2 = new Gato();
        gato2.setRaza("persa");
        gato2.setEdad(4);
        gato2.setAdoptado(false);
        gatoController.create(gato2);

        Gato gato3 = new Gato();
        gato3.setRaza("bengalí");
        gato3.setEdad(1);
        gato3.setAdoptado(false);
        gatoController.create(gato3);

        List<Gato> listaGatos = gatoController.get();

        assertEquals(listaGatos.size(), 3);
    }

    @Test
    void testUpdate() {
        Gato gato = new Gato();
        gato.setRaza("siamés");
        gato.setEdad(2);
        gato.setAdoptado(false); // hasta aquí, hemos dado todos los atributos menos id
        gato = gatoController.create(gato); // aquí le asignamos la id
        gato.setEdad(3);
        gato.setAdoptado(true);
        gatoController.update(gato);
        assertEquals(gato.getEdad(), 3);
        assertTrue(gato.isAdoptado());
    }
}
