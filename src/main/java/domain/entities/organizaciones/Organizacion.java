package domain.entities.organizaciones;

import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.organizaciones.Configuraciones.EstandarImagen;
import domain.entities.organizaciones.PreguntasONG.Atributo;

import javax.persistence.*;
import java.awt.geom.Point2D;
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

    @Transient
    private long latitud;

    @Transient
    private long longitud;

    @Transient
    public Point2D.Double coordenadas;

    @Transient
    private List<MascotaRegistrada> mascotasRegistradas;

    @Transient
    private List<Atributo> preguntasRequeridas;

    @Transient
    private EstandarImagen estandarImagen;

    public void agregarRequerimiento(Atributo atributo){
        this.preguntasRequeridas.add(atributo);
    }

    public void agregarCaracteristica(Atributo caracteristicaMascota) {
    }

    // Constructor
    public Organizacion() {}

    public Organizacion(
            int id,
            String nombre,
            String descripcion,
            Domicilio domicilio,
            long latitud,
            long longitud,
            Point2D.Double coordenadas,
            List<MascotaRegistrada> mascotasRegistradas,
            List<Atributo> preguntasRequeridas,
            EstandarImagen estandarImagen) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.domicilio = domicilio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.coordenadas = coordenadas;
        this.mascotasRegistradas = mascotasRegistradas;
        this.preguntasRequeridas = preguntasRequeridas;
        this.estandarImagen = estandarImagen;
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

    public long getLatitud() {
        return latitud;
    }

    public void setLatitud(long latitud) {
        this.latitud = latitud;
    }

    public long getLongitud() {
        return longitud;
    }

    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    public Point2D.Double getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Point2D.Double coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<MascotaRegistrada> getMascotasRegistradas() {
        return mascotasRegistradas;
    }

    public void setMascotasRegistradas(List<MascotaRegistrada> mascotasRegistradas) {
        this.mascotasRegistradas = mascotasRegistradas;
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
}