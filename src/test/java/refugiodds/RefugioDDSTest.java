package refugiodds;

import distancia.TipoMascota;
import org.junit.Assert;
import org.junit.Test;
import distancia.BuscarHogar;
import services.refugiodds.ServicioRefugioDdS;
import services.refugiodds.entidades.Hogar;
import services.refugiodds.entidades.ListadoDeHogares;
import services.refugiodds.entidades.Ubicacion;

import java.io.IOException;


public class RefugioDDSTest {


    @Test
    public void buscarHogarPerro() throws IOException {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setDireccion("Parque Centenario");
        ubicacion.setLat(-34.605704841853054);
        ubicacion.setLong(-58.43567671534143);
        TipoMascota tipoMascota = TipoMascota.PERRO;
        BuscarHogar buscarHogar = new BuscarHogar();
        Hogar hogarMasCercano = buscarHogar.buscarHogarMasCercano(tipoMascota, ubicacion);
        Assert.assertEquals("Ayudacan", hogarMasCercano.nombre);

    }

    @Test
    public void buscarHogarGato() throws IOException {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setDireccion("Parque Centenario");
        ubicacion.setLat(-34.605704841853054);
        ubicacion.setLong(-58.43567671534143);
        TipoMascota tipoMascota = TipoMascota.GATO;
        BuscarHogar buscarHogar = new BuscarHogar();
        Hogar hogarMasCercano = buscarHogar.buscarHogarMasCercano(tipoMascota, ubicacion);
        Assert.assertNotEquals("Ayudacan", hogarMasCercano.nombre);

    }

    @Test
    public void listarHogares() throws IOException {

        ServicioRefugioDdS servicioRefugioDdS = ServicioRefugioDdS.getInstancia();

        ListadoDeHogares listadoDeHogares1 = servicioRefugioDdS.listadoDeHogares(1);
        ListadoDeHogares listadoDeHogares2 = servicioRefugioDdS.listadoDeHogares(2);
        ListadoDeHogares listadoDeHogares3 = servicioRefugioDdS.listadoDeHogares(3);
        ListadoDeHogares listadoDeHogares4 = servicioRefugioDdS.listadoDeHogares(4);

        listadoDeHogares1.hogares.addAll(listadoDeHogares2.hogares);
        listadoDeHogares1.hogares.addAll(listadoDeHogares3.hogares);
        listadoDeHogares1.hogares.addAll(listadoDeHogares4.hogares);

        int i = 1;
        for (Hogar hogar : listadoDeHogares1.hogares) {
            System.out.println(i + "\t" + hogar.nombre);
            i++;
        }

        System.out.println("\n\nCantidad total de hogares de tránsito: " + listadoDeHogares1.hogares.size());

    }

}


