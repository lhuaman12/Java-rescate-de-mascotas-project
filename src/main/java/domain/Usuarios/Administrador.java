package domain.Usuarios;

import domain.Mascotas.TipoQR;
import domain.Organizaciones.Caracterisiticas.Caracterisitica;
import domain.Organizaciones.Organizacion;

import java.util.Collections;

public class Administrador extends Persona{
    private Organizacion organizacion;

    @Override
    public void crearPerfil(Cuenta cuenta) {
        this.cuenta=cuenta;
    }

    @Override
    public Boolean tieneQRAsociado(TipoQR codigoQR) {
        return null;
    }

    public void agregarCaracteristicas(Caracterisitica...caracterisiticas){
        Collections.addAll(this.organizacion.getCaracteristicas(),caracterisiticas);
    }
    public void agregarCaracterisitica(Caracterisitica caracterisitica){
        this.organizacion.agregarCaracteristica(caracterisitica);
    }

    private Administrador organizacion(Organizacion org){
        this.organizacion=org;
        return this;
    }


}
