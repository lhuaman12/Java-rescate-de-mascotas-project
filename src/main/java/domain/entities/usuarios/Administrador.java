package domain.entities.usuarios;

import domain.entities.organizaciones.AtributosOrganizacion.Parametros.CaracteristicaParaRegistro;
import domain.entities.organizaciones.Organizacion;

public class Administrador extends Persona{
    private Organizacion organizacion;

    public void agregarCaracteristicaMascota(CaracteristicaParaRegistro caracteristicaMascota){
        organizacion.agregarCaracteristica(caracteristicaMascota);
    }
}
