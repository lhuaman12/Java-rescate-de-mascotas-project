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

    @ElementCollection
    @CollectionTable(name="opcion", joinColumns=@JoinColumn(name="id"))
    @Column(name="opcion")
    private List<String> opciones;

    @ManyToOne
    @JoinColumn(name="tipo_de_dato_id")
    private TipoDeDato tipoDeDato;

    @ManyToOne
    @JoinColumn(name = "tipo_de_atributo_id",referencedColumnName = "id")
    private TipoDeAtributo tipoDeAtributo;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    public TipoDeAtributo getTipoDeAtributo() {
        return tipoDeAtributo;
    }

    public void setTipoDeAtributo(TipoDeAtributo tipoDeAtributo) {
        this.tipoDeAtributo = tipoDeAtributo;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Atributo() {
        //this.tipoDeAtributo = tipoDeAtributo;
        this.opciones = new ArrayList<>();
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

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public TipoDeDato getTipoDeDato() {
        return tipoDeDato;
    }

    public void setTipoDeDato(TipoDeDato tipoDeDato) {
        this.tipoDeDato = tipoDeDato;
    }
}

