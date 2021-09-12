package distancia;

import domain.Mascotas.Mascota;
import services.refugiodds.ServicioRefugioDdS;
import services.refugiodds.entidades.Hogar;
import services.refugiodds.entidades.Ubicacion;

import java.io.IOException;
import java.util.List;


import static distancia.Distancia.calcularDistancia;

public class BuscarHogar {

    public Hogar buscarHogarMasCercano(Mascota unaMascota, Ubicacion ubicacion) throws IOException {

        ServicioRefugioDdS servicioRefugioDdS = ServicioRefugioDdS.getInstancia();

        List<Hogar> listadoDeHogares = servicioRefugioDdS.hogares();

        //ListadoDeHogares listadoDeHogares = servicioRefugioDdS.listadoDeHogares(1);

        Hogar hogarMasCercano = new Hogar();

        double lat1 = ubicacion.getLat();
        double lon1 = ubicacion.getLong();

        double minDistancia = -1;

        for (Hogar hogar : listadoDeHogares) {

            if (hogar.lugares_disponibles < 1) {
                continue;
            }

            if (!hogar.admiteTipoMascota(unaMascota.getTipoMascota())) {
                continue;
            }

            if (!hogar.admiteTamanioMascota(unaMascota.getTamanio())) {
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
