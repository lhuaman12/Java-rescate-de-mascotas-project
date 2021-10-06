package domain.entities.domicilio;

import javax.persistence.*;

@Entity
@Table(name = "localidad")
public class Localidad {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String localidad;

    @ManyToOne
    @JoinColumn(name = "municipio_id", referencedColumnName = "id")
    private Municipio municipio;


    // Constructor

    public Localidad(int id, String localidad, Municipio municipio) {
        this.id = id;
        this.localidad = localidad;
        this.municipio = municipio;
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

}
