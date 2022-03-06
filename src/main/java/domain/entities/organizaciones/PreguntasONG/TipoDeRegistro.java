package domain.entities.organizaciones.PreguntasONG;

import javax.persistence.*;

@Entity
@Table(name="tipo_de_registro")
public class TipoDeRegistro {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    public TipoDeRegistro() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
