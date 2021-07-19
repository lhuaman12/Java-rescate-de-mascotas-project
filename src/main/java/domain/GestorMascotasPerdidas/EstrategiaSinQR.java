package domain.GestorMascotasPerdidas;

import domain.Organizaciones.GrupoPublicaciones.EstadoPublicacion;
import domain.Organizaciones.GrupoPublicaciones.PublicacionMascotaPerdida;
import domain.Organizaciones.Organizacion;
import domain.Plataforma.Plataforma;

public class EstrategiaSinQR implements HandlerMascotaPerdida{
    Plataforma plataforma;


    public EstrategiaSinQR() {

    }
    public EstrategiaSinQR plataforma(Plataforma plataforma){
        this.plataforma=plataforma;
        return this;
    }

    @Override
    public void gestionarRescate(FormularioMascotaPerdida formularioMascotaPerdida) {
        this.generarPublicacionMascotaPerdida(formularioMascotaPerdida);
    }

    private void generarPublicacionMascotaPerdida(FormularioMascotaPerdida formularioMascotaPerdida) {
        PublicacionMascotaPerdida publicacion =
                new PublicacionMascotaPerdida()
                        .rescatista(formularioMascotaPerdida.rescatista)
                        .mascotaPerdida(formularioMascotaPerdida.datosMascotaPerdida)
                        .estadoPublicacion(EstadoPublicacion.PENDIENTE);

        Organizacion organizacion=
                this.plataforma.getOrganizacionMasCercana(formularioMascotaPerdida.datosMascotaPerdida.getPuntoDeEncuentro());

        organizacion.agregarPublicacionMascotaPerdida(publicacion);
    }
}
