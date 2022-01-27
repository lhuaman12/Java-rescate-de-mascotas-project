package refugiodds;


import domain.entities.mascotas.EdadAproximada;
import domain.entities.mascotas.MascotaPerdida;
import domain.entities.mascotas.TamanioMascota;
import domain.entities.mascotas.TipoMascota;
import domain.entities.utils.refugiodds.BuscadorDeHogaresService;
import domain.entities.utils.refugiodds.entidades.Hogar;
import org.junit.Test;



import java.io.IOException;
import java.util.List;


public class RefugioDDSTest {

/*
    @Test
    public void buscarHogarPerroGrande() throws IOException {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setDireccion("Parque Centenario");
        ubicacion.setLat(-34.605704841853054);
        ubicacion.setLong(-58.43567671534143);
        Mascota m1 = new Mascota(TipoMascota.PERRO,"Copito","Copi",5,"Perro Yokshire, chiquito amable y ladrador", Sexo.MACHO);
        m1.setTamanio(TamanioMascota.GRANDE);
        BuscarHogar buscarHogar = new BuscarHogar();
        Hogar hogarMasCercano = buscarHogar.buscarHogarMasCercano(m1, ubicacion);
        Assert.assertEquals("Naricitas Frias Capital Federal", hogarMasCercano.nombre);

    }*/

/*
    @Test
    public void buscarHogarGato() throws IOException {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setDireccion("Parque Centenario");
        ubicacion.setLat(-34.605704841853054);
        ubicacion.setLong(-58.43567671534143);
        Mascota m2 = new Mascota(TipoMascota.GATO,"David","Chuchi",2,"Gatito siames, con los ojos como bowie", Sexo.MACHO);
        m2.setTamanio(TamanioMascota.MEDIANA);
        BuscarHogar buscarHogar = new BuscarHogar();
        Hogar hogarMasCercano = buscarHogar.buscarHogarMasCercano(m2, ubicacion);
        Assert.assertEquals("Naricitas Frias Capital Federal", hogarMasCercano.nombre);

    }
*/

/*
    @Test
    public void buscarHogarGatoMediano() throws IOException {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setDireccion("20 de Septiembre y 9 de Julio - Mar del Plata");
        ubicacion.setLat(-37.991829156521206);
        ubicacion.setLong(-57.55504484109265);
        Mascota m3 = new Mascota(TipoMascota.GATO,"Dolores","Lola",12,"Labrador negra mayor, tiene la cola con manchas",Sexo.HEMBRA);
        m3.setTamanio(TamanioMascota.MEDIANA);
        BuscarHogar buscarHogar = new BuscarHogar();
        Hogar hogarMasCercano = buscarHogar.buscarHogarMasCercano(m3, ubicacion);
        Assert.assertEquals("Buena Pata", hogarMasCercano.nombre);

    }
*/

    @Test
    public void listarHogares() throws IOException {

        BuscadorDeHogaresService buscadorDeHogaresService = BuscadorDeHogaresService.getInstancia();

        List<Hogar> listadoDeHogares = buscadorDeHogaresService.hogaresDisponibles();
        int i = 1;
        for (Hogar hogar : listadoDeHogares) {
            System.out.println(i + "\t" + hogar.nombre + "\t" + hogar.telefono);
            i++;
        }

        System.out.println("\n\nCantidad total de hogares de tránsito: " + listadoDeHogares.size());

    }
    @Test
    public void buscarHogarDeTransito() throws IOException {
        MascotaPerdida mascota = new MascotaPerdida();
        mascota.setEdadAproximada(EdadAproximada.ABUELO);
        mascota.setTipoMascota(TipoMascota.PERRO);
        mascota.setTamanioMascota(TamanioMascota.GRANDE);
        List<Hogar> hogaresDisponibles=mascota.buscarHogarDeTransito();
        System.out.println("Cantidad de hogares encontrados"+hogaresDisponibles.size());
        hogaresDisponibles.forEach(hogar->System.out.println(hogar.nombre));

    }

}


