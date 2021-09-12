package domain.Usuarios;

import domain.Mascotas.TipoQR;
import domain.Organizaciones.Organizacion;

public class Voluntario extends Persona{

    private Organizacion organizacion;

    @Override
    public Boolean tieneQRAsociado(TipoQR codigoQR) {
        return null;
    }

    private Voluntario organizacion(Organizacion org){
        this.organizacion=org;
        return this;
    }


}
