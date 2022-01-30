package domain.entities.organizaciones.PreguntasONG;

import javax.persistence.*;

@Entity
@Table(name="tipo_de_dato")
public class TipoDeDato {

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


}
