package domain.entities.usuarios;

import converters.TipoDeDocumentoAttributeConverter;
import domain.entities.distancia.Distancia;
import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.organizaciones.Organizacion;
import domain.entities.publicacion.PublicacionDarEnAdopcion;
import domain.entities.publicacion.PublicacionIntencionAdopcion;
import domain.entities.publicacion.PublicacionRescate;
import domain.entities.rescate.Rescate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;


    @Column
    private String nombre;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    private String apellido;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    //@Enumerated(EnumType.STRING)
    @Convert(converter = TipoDeDocumentoAttributeConverter.class)
    private TipoDocumento tipoDocumento;

    @Column
    private String nroDocumento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Contacto> contactos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private Login login;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Rol> roles;

    @ManyToOne
    @JoinColumn(name = "organizacion_id",referencedColumnName = "id")
    private Organizacion organizacion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MascotaRegistrada> mascotasRegistradas;

    @Transient
    private List<Rescate> rescates;

    @Transient
    private List<PublicacionRescate> publicacionesRescate;

    @Transient
    private List<PublicacionDarEnAdopcion> publicacionesAdopcion;

    @Transient
    private List<PublicacionIntencionAdopcion> publicacionesIntAdopcion;


    // Constructor

    public Usuario() {
        this.contactos = new ArrayList<>();
        this.roles = new ArrayList<>();
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
            LocalDate fechaNacimiento,
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
    // Metodos de usuario
    public Organizacion getOrganizacionMasCercana(List<Organizacion> organizaciones){
            Organizacion organizacionMasCercana = organizaciones.get(0);

            Double distancia1 = Distancia.calcularDistancia(organizaciones.get(0).getDomicilio().getLatitud()
                    ,organizaciones.get(0).getDomicilio().getLongitud(),this.getDomicilio().getLatitud(),this.getDomicilio().getLongitud());
            Double distancia2;

            for(int i=0;i< organizaciones.size();i++){
                distancia2 = Distancia.calcularDistancia(organizaciones.get(i).getDomicilio().getLatitud()
                        ,organizaciones.get(i).getDomicilio().getLongitud(),this.getDomicilio().getLatitud(),this.getDomicilio().getLongitud());
                if(distancia2 < distancia1){
                    organizacionMasCercana = organizaciones.get(i);
                }

            }
            return organizacionMasCercana;
    }

    public void agregarContacto(Contacto contacto){
        this.contactos.add(contacto);
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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

    public List<PublicacionDarEnAdopcion> getPublicacionesAdopcion() {
        return publicacionesAdopcion;
    }

    public void setPublicacionesAdopcion(List<PublicacionDarEnAdopcion> publicacionesAdopcion) {
        this.publicacionesAdopcion = publicacionesAdopcion;
    }

    public List<PublicacionIntencionAdopcion> getPublicacionesIntAdopcion() {
        return publicacionesIntAdopcion;
    }

    public void setPublicacionesIntAdopcion(List<PublicacionIntencionAdopcion> publicacionesIntAdopcion) {
        this.publicacionesIntAdopcion = publicacionesIntAdopcion;
    }
    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

}