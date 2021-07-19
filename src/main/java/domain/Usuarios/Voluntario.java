package domain.Usuarios;

import domain.Mascotas.TipoQR;
import domain.Organizaciones.GrupoPublicaciones.EstadoPublicacion;
import domain.Organizaciones.Organizacion;

import java.util.stream.Collectors;

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

    public void aprobarPublicaciones(Organizacion organizacion){
        this.organizacion.getPublicacionesPendientes()
                .forEach(publi -> publi.setEstadoPublicacion(EstadoPublicacion.APROBADA));
    }

}
