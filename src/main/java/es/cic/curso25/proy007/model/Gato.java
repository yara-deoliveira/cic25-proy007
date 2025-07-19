package es.cic.curso25.proy007.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gato {
    @Id // indicamos que esta va a ser nuestra clave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) // y que sus valores se generarán de este modo
    private Long id;

    private String raza;

    private int edad;
    
    private boolean adoptado;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public boolean isAdoptado() {
        return adoptado;
    }
    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    @Override
    public boolean equals(Object obj) {
        // si el objeto (Gato) que comparamos, obj0 en obj0.equals(obj), es igual en memoria al que pasamos como argumento, son iguales
        if (this == obj)
            return true;
        // si el objeto (Gato) que pasamos como parámetro es null, entonces no lo son (no puedo hacer null.equals)
        if (obj == null)
            return false;
        // si la clase del objeto que comparamamos (Gato) es distinta al del que pasamos como parámetro, nunca pueden coincidir
        if (getClass() != obj.getClass())
            return false;
        // si no está en ninguno de estos dos últimos supuestos, entonces el parámetro ha de ser un objeto Gato, luego podemos
        // castear de forma segura. Tampoco está en el supuesto 1. Veamos qué otro se puede dar.
        Gato other = (Gato) obj;
        if (id == null) { // el id del objeto (Gato) que comparamos es Long, luego puede ser null
            if (other.id != null) // si el id del que pasamos como parámetro (que ya hemos casteado) no es null, no son iguales
                return false;
        } else if (!id.equals(other.id)) // y en caso de no ser null el del objeto (Gato) que comparamos, si su id no coincide con
                                         // el del que pasamos como parámetro, entonces tampoco pueden coincidir
            return false;
        return true;
    }

    // adaptamos hashCode también en consonancia; ya no nos sirve el que extendiese de Object
    @Override
    public int hashCode() { 
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    // creamos un toString más legible
    @Override
    public String toString() {
        return "Gato [id=" + id + ", raza=" + raza + ", edad=" + edad + ", adoptado=" + adoptado + "]";
    }
}
