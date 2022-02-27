package domain.entities.organizaciones.PreguntasONG;

import domain.entities.organizaciones.Organizacion;
import domain.entities.usuarios.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="atributo")
public class Atributo {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario administradorResponsable;
    @Column
    private String caracteristicaNombre;

    @OneToMany(mappedBy = "atributo",cascade = {CascadeType.ALL})
    private List<OpcionesDePregunta> opciones;

    @ManyToOne
    @JoinColumn(name="tipo_de_dato_id") //TODO tipo de registro
    private TipoDeRegistro tipoDeRegistro;

    @ManyToOne
    @JoinColumn(name = "tipo_de_atributo_id",referencedColumnName = "id") //TODO tipo de dato
    private TipoDePregunta tipoDePregunta;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Atributo() {
        this.opciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getAdministradorResponsable() {
        return administradorResponsable;
    }

    public void setAdministradorResponsable(Usuario administradorResponsable) {
        this.administradorResponsable = administradorResponsable;
    }

    public String getCaracteristicaNombre() {
        return caracteristicaNombre;
    }

    public void setCaracteristicaNombre(String caracteristicaNombre) {
        this.caracteristicaNombre = caracteristicaNombre;
    }

    public List<OpcionesDePregunta> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionesDePregunta> opciones) {
        this.opciones = opciones;
    }

    public TipoDeRegistro getTipoDeRegistro() {
        return tipoDeRegistro;
    }

    public void setTipoDeRegistro(TipoDeRegistro tipoDeRegistro) {
        this.tipoDeRegistro = tipoDeRegistro;
    }

    public void setTipoDePregunta(TipoDePregunta tipoDePregunta) {
        this.tipoDePregunta = tipoDePregunta;
    }

    public TipoDePregunta getTipoDePregunta() {
        return tipoDePregunta;
    }

}

