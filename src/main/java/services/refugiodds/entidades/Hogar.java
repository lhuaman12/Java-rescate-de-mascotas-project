package services.refugiodds.entidades;
import domain.TipoMascota;

import java.util.List;

public class Hogar {

    public String id;
    public String nombre;
    public Ubicacion ubicacion;
    public String telefono;
    public Admision admisiones;
    public int capacidad;
    public int lugares_disponibles;
    public boolean patio;
    public List<String> caracteristicas;

    private class Admision {

        public boolean perros;
        public boolean gatos;

    }

    public boolean admiteTipoMascota(TipoMascota tipoMascota) {

        switch (tipoMascota) {
            case PERRO:
                return admisiones.perros;
            case GATO:
                return admisiones.gatos;
            default:
                return false;
        }

    }

}
