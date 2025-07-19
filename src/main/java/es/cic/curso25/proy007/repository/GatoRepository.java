package es.cic.curso25.proy007.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cic.curso25.proy007.model.Gato;

public interface GatoRepository extends JpaRepository<Gato, Long> {
// es decir, le digo a JPA Spring Data que quiero obtener automáticamente el CRUD de GatoRepository
}
