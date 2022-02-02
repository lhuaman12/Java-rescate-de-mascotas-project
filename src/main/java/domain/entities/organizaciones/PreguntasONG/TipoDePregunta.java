package domain.entities.organizaciones.PreguntasONG;

import domain.entities.organizaciones.Organizacion;

import javax.persistence.*;

@Entity
@Table(name="tipo_de_pregunta")

public class TipoDePregunta {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDePregunta() {

    }

}
