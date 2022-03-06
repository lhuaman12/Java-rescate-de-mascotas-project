package domain.entities.domicilio;

import javax.persistence.*;


@Entity
@Table(name = "provincia")
public class Provincia {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;


    // Constructor
    public Provincia() {}

    public Provincia(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

}
