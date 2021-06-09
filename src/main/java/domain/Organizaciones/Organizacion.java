package domain.Organizaciones;

import domain.Mascotas.Mascota;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;

public class Organizacion {
    public String nombre;
    public String direccion;
    public Point2D.Double coordenadas;
    public List<Caracterisitica> caracteristicas;
    public List<Mascota> mascotasRegistradas;

    public Organizacion(String nombre, String direccion, Point2D.Double coordenadas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Point2D.Double getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Point2D.Double coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Caracterisitica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracterisitica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void agregarCaracteristica(Caracterisitica caracterisitica) {
        this.caracteristicas.add(caracterisitica);
    }


    public void agregarMascota(Mascota mascota) {
        this.mascotasRegistradas.add(mascota);
    }

}
