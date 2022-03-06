package domain.entities.publicacion;


import domain.entities.organizaciones.Organizacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publicacion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_de_publicacion")

// La publicacion es una herencia, para que las publicaciones puedan generar el titulo y cuerpo automaticamente segun su tipo

public abstract class Publicacion {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String titulo;

    @Column
    private String contenido;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EstadoDePublicacion> estadosDePublicacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    public Publicacion() {
        this.estadosDePublicacion = new ArrayList<>();
    }

    abstract public void generarTitulo();

    abstract void generarContenido();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<EstadoDePublicacion> getEstadoDePublicacions() {
        return estadosDePublicacion;
    }

    public void setEstadoDePublicacions(List<EstadoDePublicacion> estadoDePublicacions) {
        this.estadosDePublicacion = estadoDePublicacions;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }


}
