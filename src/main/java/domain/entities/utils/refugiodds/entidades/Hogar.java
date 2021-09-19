package domain.entities.utils.refugiodds.entidades;

import domain.entities.Mascotas.TamanioMascota;
import domain.entities.Mascotas.TipoMascota;

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

    public boolean admiteTamanioMascota(TamanioMascota tamanioMascota) {
        Boolean resultado;
        if (tamanioMascota.equals(TamanioMascota.GRANDE) || tamanioMascota.equals(TamanioMascota.MEDIANA)) {
            resultado = this.patio;
        } else {
            resultado = true;
        }
        return resultado;
    }

}
