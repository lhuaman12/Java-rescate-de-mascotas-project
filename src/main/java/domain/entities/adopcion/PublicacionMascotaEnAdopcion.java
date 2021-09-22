package domain.entities.adopcion;

import domain.entities.mascotas.FotoMascota;
import domain.entities.mascotas.Sexo;
import domain.entities.mascotas.TamanioMascota;
import domain.entities.mascotas.TipoMascota;
import domain.entities.organizaciones.Organizacion;
import domain.entities.usuarios.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "publicacion_adopcion")
public class PublicacionMascotaEnAdopcion {

    @Id
    @GeneratedValue
    private int id;
    @Transient
    private Usuario usuario;
    @Transient
    private Organizacion organizacion;
    @Column(columnDefinition = "DATE")
    private Date fechaPublicacion;
    @Transient
    private EstadoPublicacion estadoPublicacion;
    @Transient
    private List<FotoMascota> fotosMascota;

    // Preguntas generales
    @Enumerated
    private TipoMascota tipoMascota;
    @Enumerated
    private Sexo sexo;
    @Enumerated
    private TamanioMascota tamanioMascota;

    // Preguntas específicas
    @Transient
    private HashMap<String, String> respuestas;


    // Constructor
    public PublicacionMascotaEnAdopcion(
            Usuario usuario,
            Organizacion organizacion,
            Date fechaPublicacion,
            EstadoPublicacion estadoPublicacion,
            TipoMascota tipoMascota,
            Sexo sexo,
            TamanioMascota tamanioMascota,
            HashMap<String, String> respuestas) {

        this.usuario = usuario;
        this.organizacion = organizacion;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoPublicacion = estadoPublicacion;
        this.tipoMascota = tipoMascota;
        this.sexo = sexo;
        this.tamanioMascota = tamanioMascota;
        this.respuestas = respuestas;

        this.fotosMascota = new ArrayList<>();
    }


    // Getters and Setters

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public EstadoPublicacion getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(EstadoPublicacion estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public TamanioMascota getTamanioMascota() {
        return tamanioMascota;
    }

    public void setTamanioMascota(TamanioMascota tamanioMascota) {
        this.tamanioMascota = tamanioMascota;
    }

    public HashMap<String, String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(HashMap<String, String> respuestas) {
        this.respuestas = respuestas;
    }
}
