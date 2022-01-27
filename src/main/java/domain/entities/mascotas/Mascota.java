package domain.entities.mascotas;

import domain.entities.organizaciones.Organizacion;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "mascota")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Mascota {

    @Id
    @GeneratedValue
    private int id;

    //@Column
    //private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    @Enumerated(EnumType.STRING)
    private EdadAproximada edadAproximada;

    @Enumerated(EnumType.STRING)
    private TipoMascota tipoMascota;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private TamanioMascota tamanioMascota;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FotoMascota> fotosMascota;

    @Column(columnDefinition = "DATETIME", name="datetime")
    private LocalDateTime dateTime;

    // Constructor
    public Mascota() {
        this.fotosMascota = new ArrayList<>();
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public TamanioMascota getTamanioMascota() {
        return tamanioMascota;
    }

    public void setTamanioMascota(TamanioMascota tamanioMascota) {
        this.tamanioMascota = tamanioMascota;
    }

    public List<FotoMascota> getFotosMascota() {
        return fotosMascota;
    }

    public void setFotosMascota(List<FotoMascota> fotosMascota) {
        this.fotosMascota = fotosMascota;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    /*
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    */
    public EdadAproximada getEdadAproximada() {
        return edadAproximada;
    }

    public void setEdadAproximada(EdadAproximada edadAproximada) {
        this.edadAproximada = edadAproximada;
    }

    // Methods

}
