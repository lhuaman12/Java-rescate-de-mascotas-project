package domain.entities.rescate;

import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.FotoMascota;
import domain.entities.organizaciones.Organizacion;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "rescate")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "qr")
public abstract class Rescate {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rescatista_id", referencedColumnName = "id")
    private Usuario rescatista;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;            // Lugar en que se encontró la mascota.

    @Column
    private String descripcion;             // Descripción del estado en que se encontró la mascota.

    @Column(columnDefinition = "DATETIME", name="datetime")
    private LocalDateTime localDateTime;


    // Constructor
    public Rescate() {}


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getRescatista() {
        return rescatista;
    }

    public void setRescatista(Usuario rescatista) {
        this.rescatista = rescatista;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    // Methods

    public void avisarMascotaEncontrada(Contacto contacto){ // del rescatista al duenio
        //MensajeMascotaPerdida mensaje = new MensajeMascotaPerdida(duenio,);
    }
    public Usuario buscarDuenio(){
        return null;
    }
    public void avisarRescatistaPublicacion(){ // cuando alguien responde a la publicacion del rescatista

    }
}
