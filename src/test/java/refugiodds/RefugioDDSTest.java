package refugiodds;

import domain.TipoMascota;
import org.junit.Assert;
import org.junit.Test;
import distancia.BuscarHogar;
import services.refugiodds.entidades.Hogar;
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

}


