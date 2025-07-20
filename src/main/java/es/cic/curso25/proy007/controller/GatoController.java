package es.cic.curso25.proy007.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proy007.model.Gato;
import es.cic.curso25.proy007.service.GatoService;

@RestController
@RequestMapping("/gato")
public class GatoController {

    static final Logger LOGGER = LoggerFactory.getLogger(GatoController.class);
    @Autowired
    private GatoService gatoService;
    
    // C
    @PostMapping
    public Gato create(@RequestBody Gato gato) {
        LOGGER.info("Petición para crear el gato " + gato);
        gato = gatoService.create(gato);
        return gato;
    }

    // R (1): 
    // voy a pasarle un id y devolver el Gato que, guardado en base de datos, tiene dicha id
    @GetMapping("/{id}") // es decir, los vínculos "/gato/{id}"
    public Gato get(@PathVariable Long id) {
        LOGGER.info("Petición para leer datos del gato con id " + id);
        Gato gato = gatoService.get(id);
        return gato;
    }


    // R (All)
    @GetMapping
    public List<Gato> get() {
        LOGGER.info("Petición para listar gatos");
        List<Gato> listaGatos = gatoService.get();
        return listaGatos;
    }

    // U
    @PutMapping
    public void update(@RequestBody Gato gato) {
        LOGGER.info("Petición para actualizar el gato " + gato);
        gatoService.update(gato);
    }

    // D
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Petición para eliminar el gato de id " + id);
        gatoService.delete(id);
    }
}
