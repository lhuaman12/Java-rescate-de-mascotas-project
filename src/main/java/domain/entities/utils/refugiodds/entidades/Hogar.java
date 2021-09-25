package domain.entities.utils.refugiodds.entidades;


import domain.entities.mascotas.MascotaPerdida;
import domain.entities.mascotas.TamanioMascota;
import domain.entities.mascotas.TipoMascota;

import java.awt.geom.Point2D;
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

    public Boolean admiteMascota(MascotaPerdida mascota){
        return this.admiteTamanioMascota(mascota.getTamanioMascota()) && this.admiteTipoMascota(mascota.getTipoMascota());
    }

    public Boolean cumpleRadioDeCercania(MascotaPerdida mascota,Double radioCercaniaKms){
        Point2D coordenadaHogar = new Point2D.Double(this.ubicacion.getLat(),this.ubicacion.getLong()); // no era necesario instancia variables Poin2D puedo usar la clase directamente
        Point2D coordenadaMascota = new Point2D.Double(mascota.getUbicacion().getLat(),mascota.getUbicacion().getLong());
        if(coordenadaHogar.distance(coordenadaMascota)<=radioCercaniaKms)
            return true;
        else
            return false;

    }

}
