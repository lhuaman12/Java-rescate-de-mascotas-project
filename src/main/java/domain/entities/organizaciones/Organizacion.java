package domain.entities.organizaciones;

import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.organizaciones.Configuraciones.EstandarImagen;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.rescate.Rescate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "organizacion")
public class Organizacion {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MascotaRegistrada> mascotasRegistradas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rescate> rescates;

    @Transient
    private List<Atributo> preguntasRequeridas;

    @Transient
    private EstandarImagen estandarImagen;


    // Constructor
    public Organizacion() {
        this.mascotasRegistradas = new ArrayList<>();
        this.rescates = new ArrayList<>();
        this.preguntasRequeridas = new ArrayList<>();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
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

    public List<Atributo> getPreguntasRequeridas() {
        return preguntasRequeridas;
    }

    public void setPreguntasRequeridas(List<Atributo> preguntasRequeridas) {
        this.preguntasRequeridas = preguntasRequeridas;
    }

    public EstandarImagen getEstandarImagen() {
        return estandarImagen;
    }

    public void setEstandarImagen(EstandarImagen estandarImagen) {
        this.estandarImagen = estandarImagen;
    }


    // Methods
    public void agregarRequerimiento(Atributo atributo){
        this.preguntasRequeridas.add(atributo);
    }

    public void agregarCaracteristica(Atributo caracteristicaMascota) {
    }
}