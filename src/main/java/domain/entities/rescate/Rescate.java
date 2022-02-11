package domain.entities.rescate;

import domain.entities.distancia.Distancia;
import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.MascotaPerdida;
import domain.entities.organizaciones.Organizacion;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "rescate")

public class Rescate {

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascota_perdida_id", referencedColumnName = "id")
    MascotaPerdida mascotaPerdida;

    @Column(columnDefinition = "DATETIME", name="datetime")
    private LocalDateTime localDateTime;


    // metodos
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

    public MascotaPerdida getMascotaPerdida() {
        return mascotaPerdida;
    }

    public void setMascotaPerdida(MascotaPerdida mascotaPerdida) {
        this.mascotaPerdida = mascotaPerdida;
    }

    // Methods

}
