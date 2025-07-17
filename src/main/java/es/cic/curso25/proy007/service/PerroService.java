package es.cic.curso25.proy007.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso25.proy007.model.Perro;
import es.cic.curso25.proy007.repository.PerroRepository;

@Service
public class PerroService {

    @Autowired
    private PerroRepository perroRepository;

    public long create(Perro perro) {
        perroRepository.save(perro);

        return perro.getId();    
    }

    public Perro get(long id) {
        Optional<Perro> resultado = perroRepository.findById(id);
        return resultado.orElse(null);
    }

    public List<Perro> get() {
        return perroRepository.findAll();
    }

    public void update(Perro perro) {
        perroRepository.save(perro);
    }

    public void delete(long id) {
        perroRepository.deleteById(id);
    }

}
