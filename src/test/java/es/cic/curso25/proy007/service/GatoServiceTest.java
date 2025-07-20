package es.cic.curso25.proy007.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.proy007.model.Gato;

@SpringBootTest
public class GatoServiceTest {
    @Autowired
    private GatoService gatoService;

    @Test
    void testCreate() {
        Gato gato = new Gato();
        gato.setRaza("siamés");
        gato.setEdad(2);
        gato.setAdoptado(true);
        gato = gatoService.create(gato);
        Long idGato = gato.getId();
        assertTrue(idGato == 1);
    }

    @Test
    void testDelete() {
        Gato gato = new Gato();
        gato.setRaza("siamés");
        gato.setEdad(2);
        gato.setAdoptado(true);
        gato = gatoService.create(gato);
        Long idGato = gato.getId();
        gatoService.delete(idGato);
        assertNull(gatoService.get(idGato));

    }

    @Test
    void testGetOne() {
        Gato gato1 = new Gato();
        gato1.setRaza("siamés");
        gato1.setEdad(2);
        gato1.setAdoptado(true);
        gato1 = gatoService.create(gato1);
        Long idGato1 = gato1.getId();
        Gato gatoRecibido = gatoService.get(idGato1);
        assertEquals(gatoRecibido, gato1);

        Gato gato2 = new Gato();
        gato2.setRaza("siamés");
        gato2.setEdad(2);
        gato2.setAdoptado(true);
        gato2 = gatoService.create(gato2);
        Long idGato2 = gato2.getId();
        gatoService.delete(idGato2);
        Gato miSupuestoGato = gatoService.get(idGato2);
        assertNull(miSupuestoGato);
    }

    @Test
    void testGetAll() {
        Gato gato1 = new Gato();
        gato1.setRaza("siamés");
        gato1.setEdad(2);
        gato1.setAdoptado(true);
        gatoService.create(gato1);

        Gato gato2 = new Gato();
        gato2.setRaza("persa");
        gato2.setEdad(4);
        gato2.setAdoptado(false);
        gatoService.create(gato2);

        Gato gato3 = new Gato();
        gato3.setRaza("bengalí");
        gato3.setEdad(1);
        gato3.setAdoptado(false);
        gatoService.create(gato3);

        List<Gato> listaGatos = gatoService.get();

        assertEquals(listaGatos.size(), 3);
    }

    @Test
    void testUpdate() {
        Gato gato = new Gato();
        gato.setRaza("siamés");
        gato.setEdad(2);
        gato.setAdoptado(false);
        gato = gatoService.create(gato);
        gato.setEdad(3);
        gato.setAdoptado(true);
        gatoService.update(gato);
        assertEquals(gato.getEdad(), 3);
        assertTrue(gato.isAdoptado());
    }
}
