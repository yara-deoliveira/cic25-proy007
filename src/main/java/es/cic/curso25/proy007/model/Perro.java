package es.cic.curso25.proy007.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Perro {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    //Atributos
    private Long id;
    private String raza;
    private int edad;
    private boolean vacunado;

    //Constructores
    public Perro() {
    }

    public Perro(Long id, String raza, int edad, boolean vacunado) {
        this.id = id;
        this.raza = raza;
        this.edad = edad;
        this.vacunado = vacunado;
    }

    //Getters y Setters
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
    public boolean isVacunado() {
        return vacunado;
    }
    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    //Método toString()
    @Override
    public String toString() {
        return "Perro [id=" + id + ", raza=" + raza + ", edad=" + edad + ", vacunado=" + vacunado + "]";
    }

    
}
