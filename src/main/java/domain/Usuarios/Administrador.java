package domain.Usuarios;

import domain.Mascotas.TipoQR;
import domain.Organizaciones.Caracterisitica;
import domain.Organizaciones.Organizacion;

import java.util.Collections;
import java.util.Date;

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
        Collections.addAll(this.organizacion.caracteristicas,caracterisiticas);
    }
    public void agregarCaracterisitica(Caracterisitica caracterisitica){
        this.organizacion.agregarCaracteristica(caracterisitica);
    }
}
