package es.cic.curso25.proy007.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cic.curso25.proy007.model.Perro;

public interface PerroRepository extends JpaRepository<Perro, Long> {
    
}
