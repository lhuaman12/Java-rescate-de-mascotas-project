package domain.Usuarios;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "contacto")
public class Contacto {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String telefono;
    @Column
    private String email;
    @Transient
    private List<MedioDeNotificacion> mediosDeNotificacion;
    @Transient
    private List<Notificacion> notificaciones;


    // Constructor
    public Contacto(String nombre,
                    String apellido,
                    String telefono,
                    String email) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.mediosDeNotificacion = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MedioDeNotificacion> getMediosDeNotificacion() {
        return mediosDeNotificacion;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    // ToDo
    public void setMediosDeNotificacion(List<MedioDeNotificacion> mediosDeNotificacion) {
        this.mediosDeNotificacion = mediosDeNotificacion;
    }

    // ToDo
    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    //


}
