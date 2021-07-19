package domain.Organizaciones.GrupoPublicaciones;

import java.util.ArrayList;
import java.util.List;

public class GrupoPublicaciones {
    List<PublicacionMascotaPerdida> listaDeMascotasPerdidas;
    List<PublicacionAdopcionMascota> listaDeMascotasEnAdopcion;
    List<PublicacionIntencionAdopcion> listaDeInteresadosEnAdoptar;

    public GrupoPublicaciones() {
        this.listaDeMascotasPerdidas = new ArrayList<>();
        this.listaDeMascotasEnAdopcion = new ArrayList<>();
        this.listaDeInteresadosEnAdoptar= new ArrayList<>();

    }

    public void agregarPublicacionMascotaPerdida(PublicacionMascotaPerdida publicacion) {
        this.listaDeMascotasPerdidas.add(publicacion);
    }

    public List<PublicacionMascotaPerdida> getPublicacionesMascotasPerdidas() {
        return listaDeMascotasPerdidas;
    }
}
