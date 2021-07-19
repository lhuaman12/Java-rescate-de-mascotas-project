package domain.GestorMascotasPerdidas;

import domain.Mascotas.Imagen;
import domain.Mascotas.Mascota;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class MascotaPerdida {
    private List<Imagen> fotos;
    private String descripcion;
    private Point2D.Double puntoDeEncuentro;


    public MascotaPerdida() {
        this.fotos = new ArrayList<>();
    }
    public MascotaPerdida SetFoto(Imagen imagen){
        this.fotos.add(imagen);
        return this;
    }
    public MascotaPerdida SetFotos(List<Imagen> imagen){
        this.fotos.addAll(imagen);
        return this;
    }
    public MascotaPerdida descripcion(String descripcion){
        this.descripcion=descripcion;
        return this;
    }
    public MascotaPerdida puntoDeEncuentro(Point2D.Double punto){
        this.puntoDeEncuentro=punto;
        return this;
    }

    public List<Imagen> getFotos() {
        return fotos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Point2D.Double getPuntoDeEncuentro() {
        return puntoDeEncuentro;
    }
}
