package domain.entities.domicilio;

import javax.persistence.*;


@Entity
@Table(name = "provincia")
public class Provincia {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String provincia;


    // Constructor
    public Provincia() {}

    public Provincia(int id, String provincia) {
        this.id = id;
        this.provincia = provincia;
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
