package es.cic.curso25.proy007.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso25.proy007.model.Gato;
import es.cic.curso25.proy007.model.Perro;
import es.cic.curso25.proy007.repository.GatoRepository;

@Service
public class GatoService {

private static final Logger LOGGER = LoggerFactory.getLogger(GatoService.class);

@Autowired
private GatoRepository gatoRepository;

// C
public Gato create(Gato gato) {
    LOGGER.info("Guardo gato" + gato);
    // guardo el gato en base de datos
    gatoRepository.save(gato);
    return gato;
}

// R (1)
public Gato get(Long id) {
    // como lo hago con Long y no long, tengo que dividir casos
    if (id == null) {
        LOGGER.info("Imposible; no puedo hallar un gato asociado a la id" + id);
        return null; 
    }
    else {
        LOGGER.info("Obtengo gato de id: " + id);
        Optional<Gato> gato = gatoRepository.findById(id); // el Optional es por si la id no está en base de datos
        return gato.orElse(null); // es decir, si es Optional, devuelvo null
    }
}

// si hubiese guardado id como long y no Long
// public Gato get(long id) {
    // la id nunca puede ser null, luego ahí me ahorro el problema
    // Optional<Gato> gato = gatoRepository.findById(); // el Optional es por si la id no está en base de datos
    // return gato.orElse(null); // es decir, si es Optional, devuelvo null
// }


// R (all)
public List<Gato> get() {
    return gatoRepository.findAll();
}


// U
public void update(Gato gato) {
        gatoRepository.save(gato);
}


// D
public void delete(Long id) {
    gatoRepository.deleteById(null);
}
}
