package domain.entities.publicaciones;

import domain.entities.organizaciones.Organizacion;
import domain.entities.rescate.Rescate;

public class PublicacionRescate extends Publicacion {
    Rescate rescate;
    Organizacion organizacion;

    @Override
    public void generarTitulo() {

    }

    @Override
    void generarContenido() {

    }
}
