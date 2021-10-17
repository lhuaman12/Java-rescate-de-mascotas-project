package domain.entities.usuarios;

import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.organizaciones.Organizacion;

public class Administrador {
    private Organizacion organizacion;


    public void agregarCaracteristicaMascota(Atributo caracteristicaMascota){
        organizacion.agregarCaracteristica(caracteristicaMascota);
    }
}
