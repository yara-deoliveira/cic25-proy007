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

import es.cic.curso25.proy007.model.Perro;
import es.cic.curso25.proy007.service.PerroService;

@RestController
@RequestMapping("/perro")
public class PerroController {

    //Logger
    private final static Logger LOGGER = LoggerFactory.getLogger(PerroController.class);

    @Autowired
    private PerroService perroService;


    @GetMapping
    public List<Perro> get() {
        LOGGER.info("Devolviendo el listado de perros");
        return perroService.get();
    }

    @GetMapping("/{id}")
    public Perro get(@PathVariable long id) {
        Perro perro = perroService.get(id);

        return perro;
    }


    @PostMapping
    public Perro create(@RequestBody Perro perro) {
       Perro perroNuevo = perroService.create(perro);

        return perroNuevo;
    }

    @PutMapping
    public void update(@RequestBody Perro perro){
        perroService.update(perro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        perroService.delete(id);
    }


}
    
