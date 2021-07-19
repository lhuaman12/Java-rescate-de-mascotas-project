package domain.Organizaciones.GrupoPublicaciones;

import domain.GestorMascotasPerdidas.MascotaPerdida;
import domain.Mascotas.Mascota;
import domain.Usuarios.Rescatista;

import java.util.stream.Stream;

public class PublicacionMascotaPerdida {
    Rescatista rescatista;
    MascotaPerdida mascotaPerdida;
    EstadoPublicacion estado;


    public PublicacionMascotaPerdida rescatista(Rescatista rescatista){
        this.rescatista=rescatista;
        return this;
    }
    public PublicacionMascotaPerdida mascotaPerdida(MascotaPerdida mascotaPerdida){
        this.mascotaPerdida=mascotaPerdida;
        return this;
    }
    public PublicacionMascotaPerdida estadoPublicacion(EstadoPublicacion estado){
        this.estado=estado;
        return this;
    }

    public EstadoPublicacion getEstadoPublicacion() {
        return estado;
    }

    public void setEstadoPublicacion(EstadoPublicacion aprobada) {
        this.estado=aprobada;
    }
}
