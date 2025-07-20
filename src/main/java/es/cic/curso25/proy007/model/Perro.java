package es.cic.curso25.proy007.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "PERRO")
public class Perro {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @Version
    private long version;

    //Atributos

    @Column(name = "raza")
    private String raza;
    @Column(name = "edad")
    private int edad;
    @Column(name = "vacunado")
    private boolean vacunado;


    //Constructores

    //Constructor por defecto
    public Perro() {
    }

    //Constructor con parámetros
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
