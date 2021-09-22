package domain.entities.organizaciones.AtributosOrganizacion.Parametros;

import domain.entities.usuarios.Administrador;

import java.util.List;

public class CaracteristicaParaRegistro {

    private Administrador administradorResponsable; //trazabilidad
    private String CaracteristicaNombre;
    private List<String> opciones;
    private TipoDeDato tipoDeDato;

    public Administrador getAdministradorResponsable() {
        return administradorResponsable;
    }

    public void setAdministradorResponsable(Administrador administradorResponsable) {
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

