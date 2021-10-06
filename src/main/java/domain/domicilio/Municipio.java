package domain.domicilio;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "municipio")
public class Municipio {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String municipio;

    @ManyToOne
    @JoinColumn(name = "provincia_id", referencedColumnName = "id")
    private Provincia provincia;


    // Constructor
    public Municipio(int id, String municipio, Provincia provincia) {
        this.id = id;
        this.municipio = municipio;
        this.provincia = provincia;
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
