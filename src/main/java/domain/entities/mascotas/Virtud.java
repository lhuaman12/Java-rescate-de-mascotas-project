package domain.entities.mascotas;


import javax.persistence.*;

@Entity
@Table(name = "virtud")
public class Virtud {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre; //CARINIOSO,MANSO,PROTECTOR,TIMIDO,ALEGRE,CARACTER_FUERTE

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
