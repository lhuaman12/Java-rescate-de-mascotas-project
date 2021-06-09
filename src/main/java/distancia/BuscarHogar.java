package services.refugiodds;

import domain.TipoMascota;
import services.refugiodds.entidades.Hogar;
import services.refugiodds.entidades.ListadoDeHogares;
import services.refugiodds.entidades.Ubicacion;

import java.io.IOException;


import static distancia.Distancia.distance;

public class BuscarHogar {

    public Hogar buscarHogarMasCercano(TipoMascota tipoMascota, Ubicacion ubicacion) throws IOException {

        ServicioRefugioDdS servicioRefugioDdS = ServicioRefugioDdS.getInstancia();

        // ListadoDeHogares listadoDeHogares = null;

        ListadoDeHogares listadoDeHogares = servicioRefugioDdS.listadoDeHogares(1);


        Hogar hogarMasCercano = new Hogar();

        double lat1 = ubicacion.getLat();
        double lon1 = ubicacion.getLong();

        hogarMasCercano.nombre = "";
        double min = 9999999999999999999999.999999;

        for (Hogar hogar : listadoDeHogares.hogares) {

            if (hogar.lugares_disponibles < 1) {
                continue;
            }

            if (!hogar.admiteTipoMascota(tipoMascota)) {
                continue;
            }

            double lat2 = hogar.ubicacion.getLat();
            double lon2 = hogar.ubicacion.getLong();

            double distancia = distance(lat1, lon1, lat2, lon2);

            //System.out.println(distancia + "\t" + hogar.nombre + "\n");

            if (distancia < min) {
                min = distancia;
                hogarMasCercano = hogar;
            }
        }

        return hogarMasCercano;
    }

}
