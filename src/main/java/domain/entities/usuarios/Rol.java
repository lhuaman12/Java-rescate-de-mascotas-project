package domain.entities.usuarios;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue
    private int id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column
    private String nombre;

    //ADMINISTRADOR,
    //    DUENIO,
    //    RESCATISTA,
    //    ADOPTANTE,
    //    VOLUNTARIO

}
