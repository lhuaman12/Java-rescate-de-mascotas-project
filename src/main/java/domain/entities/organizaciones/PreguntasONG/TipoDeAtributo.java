package domain.entities.organizaciones.PreguntasONG;

import domain.entities.organizaciones.Organizacion;

import javax.persistence.*;

@Table
@Entity(name="tipo_de_atributo")
public class TipoDeAtributo {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private Atributo Atributo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
