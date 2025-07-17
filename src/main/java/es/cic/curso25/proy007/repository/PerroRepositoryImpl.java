package es.cic.curso25.proy007.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import es.cic.curso25.proy007.model.Perro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PerroRepositoryImpl {


    @PersistenceContext
    private EntityManager em;

    private Map<Long, Perro> perros = new HashMap<>();

    public long create(Perro perro) {
        em.persist(perro);

        return perro.getId();
    }

        private long getSiguienteIdConStreams() {
        long mayor = 
            perros
                .keySet()
                .stream()
                .max(
                    (primero, segundo) -> (int) (segundo.longValue() - primero.longValue())
                ).get();
        return mayor + 1;        
    }

        private long getSiguienteId() {
        long mayor = 0;
        
        Set<Long> ids = perros.keySet();
        
        Iterator<Long> iteratorId =  ids.iterator();


        while (iteratorId.hasNext()) {
            Long siguiente = iteratorId.next();
            if (siguiente.longValue() > mayor) {
                mayor = siguiente;
            }
        }
        mayor++;
        return mayor;
    }
    

}
