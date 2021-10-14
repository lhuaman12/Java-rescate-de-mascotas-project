package domain.entities.usuarios;

import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.CaracteristicasONG;
import domain.entities.mascotas.MascotaBasica;
import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.mascotas.RegistroDeMascotasHandler;
import domain.entities.publicaciones.PublicacionDeAdopcion;
import domain.entities.publicaciones.PublicacionIntencionAdopcion;
import domain.entities.publicaciones.PublicacionRescate;
import domain.entities.rescate.Rescate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column
    private String nroDocumento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private List<Contacto> contactos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private Login login;

    @Transient
    private List<MascotaRegistrada> mascotasRegistradas;
    @Transient
    private List<Rescate> rescates;
    @Transient
    private List<PublicacionRescate> publicacionesRescate;
    @Transient
    private List<PublicacionDeAdopcion> publicacionesAdopcion;
    @Transient
    private List<PublicacionIntencionAdopcion> publicacionesIntAdopcion;


    // Constructor

    public Usuario() {
        this.contactos = new ArrayList<>();

        this.mascotasRegistradas = new ArrayList<>();
        this.rescates = new ArrayList<>();
        this.publicacionesRescate = new ArrayList<>();
        this.publicacionesAdopcion = new ArrayList<>();
        this.publicacionesIntAdopcion = new ArrayList<>();
    }

    public Usuario(
            int id,
            String nombre,
            String apellido,
            Date fechaNacimiento,
            TipoDocumento tipoDocumento,
            String nroDocumento,
            Domicilio domicilio,
            Login login) {

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.domicilio = domicilio;
        this.login = login;

        this.contactos = new ArrayList<>();

        this.mascotasRegistradas = new ArrayList<>();
        this.rescates = new ArrayList<>();
        this.publicacionesRescate = new ArrayList<>();
        this.publicacionesAdopcion = new ArrayList<>();
        this.publicacionesIntAdopcion = new ArrayList<>();
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

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(Contacto contacto) {
        this.contactos.add(contacto);
    }

    public List<MascotaRegistrada> getMascotasRegistradas() {
        return mascotasRegistradas;
    }

    public void setMascotasRegistradas(List<MascotaRegistrada> mascotasRegistradas) {
        this.mascotasRegistradas = mascotasRegistradas;
    }

    public List<Rescate> getRescates() {
        return rescates;
    }

    public void setRescates(List<Rescate> rescates) {
        this.rescates = rescates;
    }

    public List<PublicacionRescate> getPublicacionesRescate() {
        return publicacionesRescate;
    }

    public void setPublicacionesRescate(List<PublicacionRescate> publicacionesRescate) {
        this.publicacionesRescate = publicacionesRescate;
    }

    public List<PublicacionDeAdopcion> getPublicacionesAdopcion() {
        return publicacionesAdopcion;
    }

    public void setPublicacionesAdopcion(List<PublicacionDeAdopcion> publicacionesAdopcion) {
        this.publicacionesAdopcion = publicacionesAdopcion;
    }

    public List<PublicacionIntencionAdopcion> getPublicacionesIntAdopcion() {
        return publicacionesIntAdopcion;
    }

    public void setPublicacionesIntAdopcion(List<PublicacionIntencionAdopcion> publicacionesIntAdopcion) {
        this.publicacionesIntAdopcion = publicacionesIntAdopcion;
    }
}