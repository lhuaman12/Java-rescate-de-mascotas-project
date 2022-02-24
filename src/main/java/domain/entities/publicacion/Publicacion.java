package domain.entities.publicaciones;


import domain.entities.mascotas.Mascota;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publicacion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_de_publicacion")
public abstract class Publicacion {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String titulo;

    @Column
    private String contenido;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<EstadoDePublicacion> estadosDePublicacion;

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


}
