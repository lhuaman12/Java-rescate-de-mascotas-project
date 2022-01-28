package domain.entities.organizaciones.PreguntasONG;

import domain.entities.organizaciones.Organizacion;
import domain.entities.usuarios.Usuario;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name ="atributo")
public class Atributo {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario administradorResponsable;
    @Column
    private String CaracteristicaNombre;

    @ElementCollection
    @CollectionTable(name="opcion", joinColumns=@JoinColumn(name="id"))
    @Column(name="opcion")
    private List<String> opciones;

    @Enumerated(EnumType.STRING)
    private TipoDeDato tipoDeDato;

    @Enumerated(EnumType.STRING)
    private TipoDeAtributo tipoDeAtributo;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    public Atributo(TipoDeAtributo tipoDeAtributo) {
        this.tipoDeAtributo = tipoDeAtributo;
        this.opciones = new ArrayList<>();
    }


    public Usuario getAdministradorResponsable() {
        return administradorResponsable;
    }

    public void setAdministradorResponsable(Usuario administradorResponsable) {
        this.administradorResponsable = administradorResponsable;
    }

    public String getCaracteristicaNombre() {
        return CaracteristicaNombre;
    }

    public void setCaracteristicaNombre(String caracteristicaNombre) {
        CaracteristicaNombre = caracteristicaNombre;
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

