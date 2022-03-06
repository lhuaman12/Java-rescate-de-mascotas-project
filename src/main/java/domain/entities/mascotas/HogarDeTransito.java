package domain.entities.mascotas;

import domain.entities.domicilio.Domicilio;

import javax.persistence.*;

@Entity
@Table(name = "hogar_de_transito")
public class HogarDeTransito {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    @OneToOne
    @JoinColumn(name = "domicilio_id",referencedColumnName = "id")
    private Domicilio domicilio;

    @Column
    private String telefono;

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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
