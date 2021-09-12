package domain.Usuarios;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column(columnDefinition = "DATE")
    private Date fechaNacimiento;
    @Enumerated
    private TipoDocumento tipoDocumento;
    @Column
    private int nroDocumento;

    // Constructor
    public Usuario(String nombre,
                   String apellido,
                   Date fechaNacimiento,
                   TipoDocumento tipoDocumento,
                   int nroDocumento) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;

    }


    // Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
}


