package services.refugiodds;


import services.refugiodds.entidades.Hogar;
import services.refugiodds.entidades.ListadoDeHogares;

import java.io.IOException;


public class EjemploDeUso {

    public static void main(String[] args) throws IOException {

        ServicioRefugioDdS servicioRefugioDdS = ServicioRefugioDdS.getInstancia();

        ListadoDeHogares listadoDeHogares = servicioRefugioDdS.listadoDeHogares(1);

        for (Hogar hogar : listadoDeHogares.hogares) {
            System.out.println(hogar.id);
            System.out.println(hogar.nombre);
            System.out.println(hogar.ubicacion.direccion);
            System.out.println(hogar.ubicacion.lat);
            System.out.println(hogar.ubicacion.getLong());
            System.out.println(hogar.telefono);
            System.out.println(hogar.admisiones.perros);
            System.out.println(hogar.admisiones.gatos);
            System.out.println(hogar.capacidad);
            System.out.println(hogar.lugares_disponibles);
            System.out.println(hogar.patio);
            for (String caracteristica : hogar.caracteristicas) {
                System.out.println(caracteristica);
            }
        }

    }

}