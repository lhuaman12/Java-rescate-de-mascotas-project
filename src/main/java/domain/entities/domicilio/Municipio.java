package domain.entities.domicilio;

import javax.persistence.*;

@Entity
@Table(name = "municipio")
public class Municipio {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provincia_id", referencedColumnName = "id")
    private Provincia provincia;


    // Constructor
    public Municipio() {}

    public Municipio(int id, String municipio, Provincia provincia) {
        this.id = id;
        this.nombre = municipio;
        this.provincia = provincia;
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
