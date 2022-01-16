package domain.entities.usuarios;


import converters.MedioDeComunicacionAttributeConverter;

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

    @Column(length = 32)
    private String telefono;

    @Column
    private String email;

    //@Transient
    //@Column(columnDefinition = "String")
    @Convert( converter = MedioDeComunicacionAttributeConverter.class)
    private MedioDeNotificacion medioDeNotificacion;

    // notificaciones de trazabilidad
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notificacion> notificaciones;


    // Constructor
    public Contacto() {
        this.notificaciones = new ArrayList<>();
    }

    public Contacto(String nombre,
                    String apellido,
                    String telefono,
                    String email) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;

        this.notificaciones = new ArrayList<>();
    }

    public String getDatos(){
        String data = new String();
        data="Nombre: "+ getNombre()+"\n"+
             "Apellido: "+ getApellido()+"\n"+
             "Telefono: "+ getTelefono()+"\n"+
             "Email: "+ getEmail();
        return data;
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

    public MedioDeNotificacion getMedioDeNotificacion() {
        return medioDeNotificacion;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    // ToDo
    public void setMedioDeNotificacion(MedioDeNotificacion medioDeNotificacion) {
        this.medioDeNotificacion = medioDeNotificacion;
    }

    // ToDo
    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    //


}
