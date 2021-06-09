package Usuarios;

import Organizaciones.Caracterisitica;
import Organizaciones.Organizacion;

import java.util.Collections;
import java.util.Date;

public class Administrador extends Persona{
    private Organizacion organizacion;

    @Override
    public void crearPerfil(Cuenta cuenta) {
        this.cuenta=cuenta;
    }

    public void agregarCaracteristicas(Caracterisitica...caracterisiticas){
        Collections.addAll(this.organizacion.caracteristicas,caracterisiticas);
    }
    public void agregarCaracterisitica(Caracterisitica caracterisitica){
        this.organizacion.agregarCaracteristica(caracterisitica);
    }
}
