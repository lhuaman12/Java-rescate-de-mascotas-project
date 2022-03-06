package domain.entities.distancia;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.utils.refugiodds.BuscadorDeHogaresService;
import domain.entities.utils.refugiodds.entidades.Hogar;
import domain.entities.utils.refugiodds.entidades.Ubicacion;

import java.io.IOException;
import java.util.List;


import static domain.entities.distancia.Distancia.calcularDistancia;

public class BuscarHogar {

    public Hogar buscarHogarMasCercano(MascotaRegistrada unaMascotaRegistrada, Ubicacion ubicacion) throws IOException {

        BuscadorDeHogaresService buscadorDeHogaresService = BuscadorDeHogaresService.getInstancia();

        List<Hogar> listadoDeHogares = buscadorDeHogaresService.hogaresDisponibles();

        //ListadoDeHogares listadoDeHogares = servicioRefugioDdS.listadoDeHogares(1.jpg);

        Hogar hogarMasCercano = new Hogar();

        double lat1 = ubicacion.getLat();
        double lon1 = ubicacion.getLong();

        double minDistancia = -1;

        for (Hogar hogar : listadoDeHogares) {

            if (hogar.lugares_disponibles < 1) {
                continue;
            }

            if (!hogar.admiteTipoMascota(unaMascotaRegistrada.getTipoMascota())) {
                continue;
            }

            if (!hogar.admiteTamanioMascota(unaMascotaRegistrada.getTamanioMascota())) {
                continue;
            }

            double lat2 = hogar.ubicacion.getLat();
            double lon2 = hogar.ubicacion.getLong();

            double distancia = calcularDistancia(lat1, lon1, lat2, lon2);

            if (distancia < minDistancia || minDistancia < 0) {
                minDistancia = distancia;
                hogarMasCercano = hogar;
            }
        }

        return hogarMasCercano;
    }

}